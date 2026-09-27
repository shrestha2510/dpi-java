# Java Deep Packet Inspection Tool

A Java-based Deep Packet Inspection (DPI) project built using Pcap4J.

This project analyzes PCAP files and demonstrates practical Computer Networks concepts including:

- Packet Parsing
- Flow Tracking
- Protocol Identification
- Application Detection
- Traffic Analysis
- Network Security Alerts
- CSV Export Reporting

---

## Features

### Packet Analysis

Extracts:

- Source IP
- Destination IP
- Source Port
- Destination Port
- Transport Protocol
- Packet Length
- Timestamp

---

### Flow Tracking

Groups packets into flows using:

Source IP + Destination IP + Source Port + Destination Port + Protocol

For each flow:

- Packet Count
- Total Bytes
- Duration

are calculated.

---

### Protocol Detection

Detects:

- TCP
- UDP
- DNS
- HTTPS
- QUIC / HTTP3

---

### Traffic Summary

Generates:

- Total Flows
- Total Packets
- Total Bytes
- Protocol Distribution
- Application Distribution

Example:

Total Flows : 29
Total Packets : 461
Total Bytes : 244101

Protocols:
TCP : 17
UDP : 12

Applications:
HTTPS : 13
DNS : 14
QUIC / HTTP3 : 2

---

### Security Alert Engine

Detects:

#### Large Flow

Triggered when:

Bytes > 50,000

Example:

[HIGH] Large Flow Detected

#### High Packet Count

Triggered when:

Packets > 50

Example:

[MEDIUM] High Packet Count

#### Long Duration Flow

Triggered when:

Duration > 5 seconds

Example:

[LOW] Long Duration Flow

---

### CSV Export

Exports flow information to:

flows.csv

Fields:

- Flow ID
- Protocol
- Application
- Packets
- Bytes
- Duration

---

## Technologies Used

- Java 23
- Maven
- Pcap4J
- Npcap
- Git
- IntelliJ IDEA

---

## Project Structure

src/main/java/com/shrestha

├── parser
├── reader
├── tracker
├── detector
├── rules
├── report
├── export
├── model
├── service

---

## How to Run

Compile:

```bash
mvn clean compile
```

Run:

```bash
mvn exec:java -Dexec.mainClass="com.shrestha.Main"
```

---

## Sample Output

```text
========== ANALYSIS SUMMARY ==========

Total Flows   : 29
Total Packets : 461
Total Bytes   : 244101

Protocols:
UDP : 12
TCP : 17

Applications:
HTTPS : 13
DNS : 14
QUIC / HTTP3 : 2

Largest Flow:
192.168.1.10:64146-23.193.165.42:443-TCP
Packets : 97
Bytes   : 89347

======================================
```

---

## Concepts Demonstrated

- OSI Model
- TCP/IP Stack
- Packet Capture
- Network Flows
- DNS Analysis
- HTTPS Traffic Analysis
- QUIC Protocol
- Network Monitoring
- Intrusion Detection Basics
- Traffic Engineering

---

## Author

Shrestha Gupta

B.Tech Information Technology

G.L. Bajaj Institute of Technology and Management

Expected Graduation: 2027