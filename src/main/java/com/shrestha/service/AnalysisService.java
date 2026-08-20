package com.shrestha.service;

import com.shrestha.reader.PcapFileReader;

public class AnalysisService {

    private final PcapFileReader pcapFileReader;

    public AnalysisService() {
        this.pcapFileReader = new PcapFileReader();
    }

    public void analyze(String filePath) {
        pcapFileReader.readPcap(filePath);
    }
}