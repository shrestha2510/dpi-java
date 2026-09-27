package com.shrestha.reader;

import com.shrestha.model.PacketInfo;
import com.shrestha.parser.PacketParser;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;
import com.shrestha.tracker.FlowTracker;
import com.shrestha.tracker.Flow;

import com.shrestha.printer.PacketPrinter;
import java.util.Collection;

public class PcapFileReader {

    private final PacketParser packetParser;
    private final FlowTracker flowTracker;

    private final PacketPrinter packetPrinter;


    public PcapFileReader() {
        this.packetParser = new PacketParser();
        this.flowTracker = new FlowTracker();
        this.packetPrinter = new PacketPrinter();

    }

    public Collection<Flow> readPcap(String filePath) {

        try {

            PcapHandle handle = Pcaps.openOffline(filePath);


            Packet packet;
            int count = 0;

            while ((packet = handle.getNextPacket()) != null) {

                count++;

                PacketInfo packetInfo = packetParser.parse(packet);
                packetInfo.setTimestamp(handle.getTimestamp().getTime());
                packetPrinter.print(packetInfo, count);
                flowTracker.processPacket(packetInfo);
            }

            handle.close();

            System.out.println("--------------------------------");
            System.out.println("Total Packets : " + count);
            System.out.println("\n========== FLOWS ==========\n");
            return flowTracker.getFlows();
        }catch (Exception e) {
            e.printStackTrace();
            return java.util.Collections.emptyList();
        }
    }
}