package com.shrestha.report;

import com.shrestha.tracker.Flow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FlowReport {

    public void generate(Iterable<Flow> flows) {

        List<Flow> flowList = new ArrayList<>();

        for (Flow flow : flows) {
            flowList.add(flow);
        }

        flowList.sort(
                Comparator.comparingLong(Flow::getTotalBytes)
                        .reversed());

        System.out.println();
        System.out.println("=======================================");
        System.out.println("     DEEP PACKET INSPECTION REPORT");
        System.out.println("=======================================");
        System.out.println();

        System.out.println("Total Flows : " + flowList.size());
        System.out.println();

        int limit = Math.min(5, flowList.size());

        for (int i = 0; i < limit; i++) {

            Flow flow = flowList.get(i);

            System.out.println("---------------------------------------");
            System.out.println("Rank : " + (i + 1));
            System.out.println("Flow : " + flow.getFlowId());
            System.out.println("Protocol : " + flow.getProtocol());
            System.out.println("Application : " + flow.getApplicationProtocol());
            System.out.println("Packets : " + flow.getPacketCount());
            System.out.println("Bytes : " + flow.getTotalBytes());
            System.out.println("Duration : " + flow.getDuration() + " ms");
            System.out.printf("Average Packet Size : %.2f bytes%n",
                    flow.getAveragePacketSize());
        }

        System.out.println();
        System.out.println("=======================================");
    }
}