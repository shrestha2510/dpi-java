package com.shrestha.rules;

import com.shrestha.tracker.Flow;

public class LargeFlowRule implements DetectionRule {

    private static final long THRESHOLD = 50000;

    @Override
    public String check(Flow flow) {

        if (flow.getTotalBytes() > THRESHOLD) {

            return "[HIGH] Large Flow Detected : "
                    + flow.getFlowId()
                    + " | Bytes = "
                    + flow.getTotalBytes();
        }

        return null;
    }
}