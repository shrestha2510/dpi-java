package com.shrestha.detector;

import com.shrestha.model.PacketInfo;

public class ProtocolDetector {

    public void detect(PacketInfo packetInfo) {

        int port = Math.min(
                packetInfo.getSourcePort(),
                packetInfo.getDestinationPort());

        String transport = packetInfo.getTransportProtocol();

        switch (port) {

            case 80:
                packetInfo.setApplicationProtocol("HTTP");
                break;

            case 443:

                if ("TCP".equals(transport)) {
                    packetInfo.setApplicationProtocol("HTTPS");
                }
                else if ("UDP".equals(transport)) {
                    packetInfo.setApplicationProtocol("QUIC / HTTP3");
                }

                break;

            case 53:
                packetInfo.setApplicationProtocol("DNS");
                break;

            case 22:
                packetInfo.setApplicationProtocol("SSH");
                break;

            case 21:
                packetInfo.setApplicationProtocol("FTP");
                break;

            case 25:
                packetInfo.setApplicationProtocol("SMTP");
                break;

            case 110:
                packetInfo.setApplicationProtocol("POP3");
                break;

            case 143:
                packetInfo.setApplicationProtocol("IMAP");
                break;

            case 123:
                packetInfo.setApplicationProtocol("NTP");
                break;

            case 67:
            case 68:
                packetInfo.setApplicationProtocol("DHCP");
                break;

            default:
                packetInfo.setApplicationProtocol("Unknown");
        }
    }
}