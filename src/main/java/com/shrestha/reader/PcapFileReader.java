package com.shrestha.reader;

import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;

public class PcapFileReader {

    public void readPcap(String filePath) {

        try {

            PcapHandle handle = Pcaps.openOffline(filePath);

            Packet packet;
            int count = 0;

            while ((packet = handle.getNextPacket()) != null) {

                count++;

                System.out.println("----------------------------");
                System.out.println("Packet #" + count);
                System.out.println("Length : " + packet.length() + " bytes");
            }

            handle.close();

            System.out.println("----------------------------");
            System.out.println("Total Packets : " + count);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}