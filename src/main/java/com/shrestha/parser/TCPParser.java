package com.shrestha.parser;

import com.shrestha.model.PacketInfo;
import org.pcap4j.packet.TcpPacket;

public class TCPParser {

    public void parse(TcpPacket tcpPacket, PacketInfo packetInfo) {

        packetInfo.setSourcePort(
                tcpPacket.getHeader().getSrcPort().valueAsInt());

        packetInfo.setDestinationPort(
                tcpPacket.getHeader().getDstPort().valueAsInt());

    }
}