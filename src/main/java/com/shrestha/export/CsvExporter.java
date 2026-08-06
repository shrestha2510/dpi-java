package com.shrestha.export;

import com.shrestha.tracker.Flow;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class CsvExporter {

    public void export(Collection<Flow> flows, String fileName) throws IOException {

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            writer.println(
                    "Flow ID,Protocol,Application,Packets,Bytes,Duration (ms),Average Packet Size"
            );

            for (Flow flow : flows) {

                writer.printf(
                        "%s,%s,%s,%d,%d,%d,%.2f%n",
                        flow.getFlowId(),
                        flow.getProtocol(),
                        flow.getApplicationProtocol(),
                        flow.getPacketCount(),
                        flow.getTotalBytes(),
                        flow.getDuration(),
                        flow.getAveragePacketSize()
                );

            }
        }
    }
}