package com.shrestha.rules;

import com.shrestha.tracker.Flow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RuleEngine {

    private final List<DetectionRule> rules;

    public RuleEngine() {

        rules = new ArrayList<>();

        rules.add(new LargeFlowRule());
        rules.add(new HighPacketCountRule());
        rules.add(new LongDurationRule());
    }

    public void analyze(Collection<Flow> flows) {

        System.out.println();
        System.out.println("============= ALERTS =============");

        for (Flow flow : flows) {

            for (DetectionRule rule : rules) {

                String result = rule.check(flow);

                if (result != null) {
                    System.out.println(result);
                }
            }
        }
    }
}