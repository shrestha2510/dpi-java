package com.shrestha;

import com.shrestha.reader.PcapFileReader;

public class Main {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println(" Java Deep Packet Inspection Tool ");
        System.out.println("==================================");

        PcapFileReader reader = new PcapFileReader();

        reader.readPcap("captures/dns-test2.pcapng");
    }
}