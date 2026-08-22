package com.shrestha.rules;

import com.shrestha.tracker.Flow;

public interface DetectionRule {

    String check(Flow flow);

}