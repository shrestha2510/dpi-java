package com.shrestha.tracker;

public class Flow {

    private final String flowId;

    private final String sourceIp;
    private final String destinationIp;

    private final int sourcePort;
    private final int destinationPort;

    private final String protocol;
    private final String applicationProtocol;

    private int packetCount;
    private long totalBytes;

    private long firstTimestamp;
    private long lastTimestamp;

    public Flow(String flowId,
                String sourceIp,
                String destinationIp,
                int sourcePort,
                int destinationPort,
                String protocol,
                String applicationProtocol,
                long timestamp) {

        this.flowId = flowId;
        this.sourceIp = sourceIp;
        this.destinationIp = destinationIp;
        this.sourcePort = sourcePort;
        this.destinationPort = destinationPort;
        this.protocol = protocol;
        this.applicationProtocol = applicationProtocol;

        this.packetCount = 0;
        this.totalBytes = 0;
        this.firstTimestamp = timestamp;
        this.lastTimestamp = timestamp;
    }



    public String getFlowId() {
        return flowId;
    }
    public void addPacket(int bytes, long timestamp) {

        packetCount++;
        totalBytes += bytes;

        lastTimestamp = timestamp;
    }
    public String getSourceIp() {
        return sourceIp;
    }

    public String getDestinationIp() {
        return destinationIp;
    }

    public int getSourcePort() {
        return sourcePort;
    }

    public int getDestinationPort() {
        return destinationPort;
    }

    public String getProtocol() {
        return protocol;
    }

    public int getPacketCount() {
        return packetCount;
    }

    public long getTotalBytes() {
        return totalBytes;
    }

    public long getFirstTimestamp() {
        return firstTimestamp;
    }

    public long getLastTimestamp() {
        return lastTimestamp;
    }

    public long getDuration() {
        return lastTimestamp - firstTimestamp;
    }

    public String getApplicationProtocol() {
        return applicationProtocol;
    }
    
    public double getAveragePacketSize() {
        if (packetCount == 0) {
            return 0;
        }

        return (double) totalBytes / packetCount;
    }
}