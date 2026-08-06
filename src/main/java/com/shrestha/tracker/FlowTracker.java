package com.shrestha.tracker;

import com.shrestha.model.PacketInfo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FlowTracker {

    private final Map<String, Flow> flows = new HashMap<>();

    public void processPacket(PacketInfo packetInfo) {

        String endpoint1 =
                packetInfo.getSourceIp() + ":" + packetInfo.getSourcePort();

        String endpoint2 =
                packetInfo.getDestinationIp() + ":" + packetInfo.getDestinationPort();

        String flowId;

        if (endpoint1.compareTo(endpoint2) < 0) {
            flowId = endpoint1 + "-" + endpoint2 + "-" + packetInfo.getTransportProtocol();
        } else {
            flowId = endpoint2 + "-" + endpoint1 + "-" + packetInfo.getTransportProtocol();
        }

        Flow flow = flows.get(flowId);

        if (flow == null) {

            flow = new Flow(
                    flowId,
                    packetInfo.getSourceIp(),
                    packetInfo.getDestinationIp(),
                    packetInfo.getSourcePort(),
                    packetInfo.getDestinationPort(),
                    packetInfo.getTransportProtocol(),
                    packetInfo.getApplicationProtocol(),
                    packetInfo.getTimestamp()
            );

            flows.put(flowId, flow);
        }

        flow.addPacket(
                packetInfo.getPacketLength(),
                packetInfo.getTimestamp()
        );
    }

    public Collection<Flow> getFlows() {
        return flows.values();
    }
}