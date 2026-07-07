package com.shrestha.parser;

import com.shrestha.model.PacketInfo;
import org.pcap4j.packet.EthernetPacket;
import org.pcap4j.packet.IpV4Packet;
import org.pcap4j.packet.Packet;
import org.pcap4j.packet.TcpPacket;
import org.pcap4j.packet.UdpPacket;

public class PacketParser {

    private final EthernetParser ethernetParser;
    private final IPv4Parser ipv4Parser;
    private final TCPParser tcpParser;
    private final UDPParser udpParser;

    public PacketParser() {
        ethernetParser = new EthernetParser();
        ipv4Parser = new IPv4Parser();
        tcpParser = new TCPParser();
        udpParser = new UDPParser();
    }

    public PacketInfo parse(Packet packet) {

        PacketInfo packetInfo = new PacketInfo();

        EthernetPacket ethernetPacket = packet.get(EthernetPacket.class);

        if (ethernetPacket != null) {

            ethernetParser.parse(ethernetPacket, packetInfo);

            IpV4Packet ipPacket = ethernetPacket.get(IpV4Packet.class);

            if (ipPacket != null) {
                ipv4Parser.parse(ipPacket, packetInfo);
                TcpPacket tcpPacket = ipPacket.get(TcpPacket.class);

                if (tcpPacket != null) {
                    tcpParser.parse(tcpPacket, packetInfo);
                }

                UdpPacket udpPacket = ipPacket.get(UdpPacket.class);

                if (udpPacket != null) {
                    udpParser.parse(udpPacket, packetInfo);
                }
            }
        }

        return packetInfo;
    }
}