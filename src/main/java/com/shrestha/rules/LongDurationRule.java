package com.shrestha.rules;

import com.shrestha.tracker.Flow;

public class LongDurationRule implements DetectionRule {

    private static final long THRESHOLD = 15000;

    @Override
    public String check(Flow flow) {

        if (flow.getDuration() > THRESHOLD) {

            return "[LOW] Long Duration Flow : "
                    + flow.getFlowId()
                    + " | Duration = "
                    + flow.getDuration()
                    + " ms";
        }

        return null;
    }
}