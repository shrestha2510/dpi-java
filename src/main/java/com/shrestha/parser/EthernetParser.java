package com.shrestha.parser;

import com.shrestha.model.PacketInfo;
import org.pcap4j.packet.EthernetPacket;

public class EthernetParser {

    public void parse(EthernetPacket ethernetPacket, PacketInfo packetInfo) {

        packetInfo.setSourceMac(
                ethernetPacket.getHeader()
                        .getSrcAddr()
                        .toString());

        packetInfo.setDestinationMac(
                ethernetPacket.getHeader()
                        .getDstAddr()
                        .toString());
    }

}