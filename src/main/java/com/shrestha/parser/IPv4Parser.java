package com.shrestha.parser;

import com.shrestha.model.PacketInfo;
import org.pcap4j.packet.IpV4Packet;

public class IPv4Parser {

    public void parse(IpV4Packet ipPacket,
                      PacketInfo packetInfo) {

        packetInfo.setIpVersion(4);

        packetInfo.setSourceIp(
                ipPacket.getHeader()
                        .getSrcAddr()
                        .getHostAddress());

        packetInfo.setDestinationIp(
                ipPacket.getHeader()
                        .getDstAddr()
                        .getHostAddress());

        packetInfo.setTransportProtocol(
                ipPacket.getHeader()
                        .getProtocol()
                        .name());

    }

}