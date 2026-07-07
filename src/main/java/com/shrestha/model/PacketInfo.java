package com.shrestha.model;

public class PacketInfo {

    private String sourceMac;
    private String destinationMac;

    private int ipVersion;

    private String sourceIp;
    private String destinationIp;

    private int sourcePort;
    private int destinationPort;

    private String transportProtocol;

    private int packetLength;

    private long timestamp;

    private long sequenceNumber;

    public String getApplicationProtocol() {
        return applicationProtocol;
    }

    public void setApplicationProtocol(String applicationProtocol) {
        this.applicationProtocol = applicationProtocol;
    }

    private String applicationProtocol;

    public long getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public long getAcknowledgementNumber() {
        return acknowledgementNumber;
    }

    public void setAcknowledgementNumber(long acknowledgementNumber) {
        this.acknowledgementNumber = acknowledgementNumber;
    }

    public String getTcpFlags() {
        return tcpFlags;
    }

    public void setTcpFlags(String tcpFlags) {
        this.tcpFlags = tcpFlags;
    }

    private long acknowledgementNumber;

    private String tcpFlags;

    public PacketInfo() {
    }

    public String getSourceMac() {
        return sourceMac;
    }

    public void setSourceMac(String sourceMac) {
        this.sourceMac = sourceMac;
    }

    public String getDestinationMac() {
        return destinationMac;
    }

    public void setDestinationMac(String destinationMac) {
        this.destinationMac = destinationMac;
    }

    public int getIpVersion() {
        return ipVersion;
    }

    public void setIpVersion(int ipVersion) {
        this.ipVersion = ipVersion;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public String getDestinationIp() {
        return destinationIp;
    }

    public void setDestinationIp(String destinationIp) {
        this.destinationIp = destinationIp;
    }

    public int getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(int sourcePort) {
        this.sourcePort = sourcePort;
    }

    public int getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(int destinationPort) {
        this.destinationPort = destinationPort;
    }

    public String getTransportProtocol() {
        return transportProtocol;
    }

    public void setTransportProtocol(String transportProtocol) {
        this.transportProtocol = transportProtocol;
    }

    public int getPacketLength() {
        return packetLength;
    }

    public void setPacketLength(int packetLength) {
        this.packetLength = packetLength;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}