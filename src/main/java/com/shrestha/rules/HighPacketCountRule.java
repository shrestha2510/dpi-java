package com.shrestha.rules;

import com.shrestha.tracker.Flow;

public class HighPacketCountRule implements DetectionRule {

    private static final int THRESHOLD = 50;

    @Override
    public String check(Flow flow) {

        if (flow.getPacketCount() > THRESHOLD) {

            return "[MEDIUM] High Packet Count : "
                    + flow.getFlowId()
                    + " | Packets = "
                    + flow.getPacketCount();
        }

        return null;
    }
}