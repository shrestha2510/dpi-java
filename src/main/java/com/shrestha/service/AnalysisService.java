package com.shrestha.service;

import com.shrestha.export.CsvExporter;
import com.shrestha.reader.PcapFileReader;
import com.shrestha.report.FlowReport;
import com.shrestha.tracker.Flow;
import com.shrestha.rules.RuleEngine;
import com.shrestha.report.SummaryReport;

import java.util.Collection;

public class AnalysisService {

    private final PcapFileReader pcapFileReader;
    private final FlowReport flowReport;
    private final CsvExporter csvExporter;
    private final RuleEngine ruleEngine;
    private final SummaryReport summaryReport;

    public AnalysisService() {
        this.pcapFileReader = new PcapFileReader();
        this.flowReport = new FlowReport();
        this.csvExporter = new CsvExporter();
        this.ruleEngine = new RuleEngine();
        this.summaryReport = new SummaryReport();
    }

    public void analyze(String filePath) {

        Collection<Flow> flows = pcapFileReader.readPcap(filePath);

        flowReport.generate(flows);
        summaryReport.generate(flows);
        ruleEngine.analyze(flows);

        try {

            csvExporter.export(flows, "flows.csv");

            System.out.println("\nCSV exported successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Collection<Flow> analyzeFlows(String filePath) {

        return pcapFileReader.readPcap(filePath);

    }
}