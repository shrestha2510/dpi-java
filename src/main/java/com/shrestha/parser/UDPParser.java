package com.shrestha.parser;

import com.shrestha.model.PacketInfo;
import org.pcap4j.packet.UdpPacket;

public class UDPParser {

    public void parse(UdpPacket udpPacket, PacketInfo packetInfo) {

        packetInfo.setSourcePort(
                udpPacket.getHeader().getSrcPort().valueAsInt());

        packetInfo.setDestinationPort(
                udpPacket.getHeader().getDstPort().valueAsInt());

    }
}