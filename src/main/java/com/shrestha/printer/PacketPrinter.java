package com.shrestha.printer;

import com.shrestha.model.PacketInfo;

public class PacketPrinter {

    public void print(PacketInfo packetInfo, int packetNumber) {

        System.out.println("--------------------------------");
        System.out.println("Packet #" + packetNumber);
        System.out.println("Source MAC      : " + packetInfo.getSourceMac());
        System.out.println("Destination MAC : " + packetInfo.getDestinationMac());
        System.out.println("Source IP       : " + packetInfo.getSourceIp());
        System.out.println("Destination IP  : " + packetInfo.getDestinationIp());
        System.out.println("IP Version      : " + packetInfo.getIpVersion());
        System.out.println("Protocol        : " + packetInfo.getTransportProtocol());
        System.out.println("Application     : " + packetInfo.getApplicationProtocol());
        System.out.println("Source Port     : " + packetInfo.getSourcePort());
        System.out.println("Destination Port: " + packetInfo.getDestinationPort());
        System.out.println("Length          : " + packetInfo.getPacketLength() + " bytes");
        System.out.println("Timestamp       : " + packetInfo.getTimestamp());
    }
}