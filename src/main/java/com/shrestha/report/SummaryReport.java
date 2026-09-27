package com.shrestha.report;

import com.shrestha.tracker.Flow;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SummaryReport {

    public void generate(Collection<Flow> flows) {

        int totalFlows = flows.size();

        long totalPackets = 0;
        long totalBytes = 0;

        Map<String, Integer> protocolStats = new HashMap<>();
        Map<String, Integer> applicationStats = new HashMap<>();

        Flow largestFlow = null;

        for (Flow flow : flows) {

            totalPackets += flow.getPacketCount();
            totalBytes += flow.getTotalBytes();

            protocolStats.put(
                    flow.getProtocol(),
                    protocolStats.getOrDefault(flow.getProtocol(), 0) + 1
            );

            String app = flow.getApplicationProtocol();

            if (app != null) {

                applicationStats.put(
                        app,
                        applicationStats.getOrDefault(app, 0) + 1
                );
            }

            if (largestFlow == null ||
                    flow.getTotalBytes() > largestFlow.getTotalBytes()) {

                largestFlow = flow;
            }
        }

        System.out.println("\n========== ANALYSIS SUMMARY ==========\n");

        System.out.println("Total Flows   : " + totalFlows);
        System.out.println("Total Packets : " + totalPackets);
        System.out.println("Total Bytes   : " + totalBytes);

        System.out.println("\nProtocols:");

        protocolStats.forEach(
                (protocol, count) ->
                        System.out.println(protocol + " : " + count)
        );

        System.out.println("\nApplications:");

        applicationStats.forEach(
                (app, count) ->
                        System.out.println(app + " : " + count)
        );

        if (largestFlow != null) {

            System.out.println("\nLargest Flow:");

            System.out.println(
                    largestFlow.getFlowId()
            );

            System.out.println(
                    "Packets : " + largestFlow.getPacketCount()
            );

            System.out.println(
                    "Bytes   : " + largestFlow.getTotalBytes()
            );
        }

        System.out.println("\n======================================");
    }
}