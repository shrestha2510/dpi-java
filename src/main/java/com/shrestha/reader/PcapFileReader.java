package com.shrestha.reader;

import com.shrestha.model.PacketInfo;
import com.shrestha.parser.PacketParser;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;
import com.shrestha.tracker.FlowTracker;
import com.shrestha.tracker.Flow;
import com.shrestha.report.FlowReport;
import com.shrestha.printer.PacketPrinter;
import com.shrestha.export.CsvExporter;
import java.io.IOException;

public class PcapFileReader {

    private final PacketParser packetParser;
    private final FlowTracker flowTracker;
    private final FlowReport flowReport;
    private final PacketPrinter packetPrinter;
    private final CsvExporter csvExporter;

    public PcapFileReader() {
        this.packetParser = new PacketParser();
        this.flowTracker = new FlowTracker();
        this.flowReport = new FlowReport();
        this.packetPrinter = new PacketPrinter();
        this.csvExporter = new CsvExporter();
    }

    public void readPcap(String filePath) {

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
            flowReport.generate(flowTracker.getFlows());

            String fileName = "flows.csv";

            csvExporter.export(
                    flowTracker.getFlows(),
                    fileName
            );

            System.out.println("CSV saved at: " + new java.io.File(fileName).getAbsolutePath());

            System.out.println("\nCSV exported successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}