package com.shrestha;

import com.shrestha.service.AnalysisService;

public class Main {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println(" Java Deep Packet Inspection Tool ");
        System.out.println("==================================");

        AnalysisService analysisService = new AnalysisService();

        analysisService.analyze("captures/dns-test2.pcapng");
    }
}