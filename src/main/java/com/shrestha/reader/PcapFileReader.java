package com.shrestha.reader;

import com.shrestha.model.PacketInfo;
import com.shrestha.parser.PacketParser;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;

public class PcapFileReader {

    private final PacketParser packetParser;

    public PcapFileReader() {
        this.packetParser = new PacketParser();
    }

    public void readPcap(String filePath) {

        try {

            PcapHandle handle = Pcaps.openOffline(filePath);


            Packet packet;
            int count = 0;

            while ((packet = handle.getNextPacket()) != null) {

                count++;

                PacketInfo packetInfo = packetParser.parse(packet);

                System.out.println("--------------------------------");
                System.out.println("Packet #" + count);
                System.out.println("Source MAC      : " + packetInfo.getSourceMac());
                System.out.println("Destination MAC : " + packetInfo.getDestinationMac());
                System.out.println("Source IP       : " + packetInfo.getSourceIp());
                System.out.println("Destination IP  : " + packetInfo.getDestinationIp());
                System.out.println("IP Version      : " + packetInfo.getIpVersion());
                System.out.println("Protocol        : " + packetInfo.getTransportProtocol());
                System.out.println("Application     : " + packetInfo.getApplicationProtocol());
                System.out.println("Source Port     : " + packetInfo.getSourcePort());
                System.out.println("Destination Port: " + packetInfo.getDestinationPort());
                System.out.println("Length          : " + packet.length() + " bytes");
            }

            handle.close();

            System.out.println("--------------------------------");
            System.out.println("Total Packets : " + count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}