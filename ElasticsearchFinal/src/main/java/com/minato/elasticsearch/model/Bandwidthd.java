package com.minato.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "bandwidthd", type = "bandwidthd", shards = 1, replicas = 0, refreshInterval = "-1")
public class Bandwidthd {

//	@Id
//	private int id;

	@Id
	private String ipAddress;
	
	private String total;
	private String totalSent;
	private String totalReceived;
	private String ftp;
	private String http;
	private String p2p;
	private String tcp;
	private String udp;
	private String icmp;

	private String presentTime;

	public Bandwidthd(String ipAddress, String total, String totalSent, String totalReceived, String ftp, String http,
			String p2p, String tcp, String udp, String icmp, String presentTime) {
//		this.id = id;
		this.ipAddress = ipAddress;
		this.total = total;
		this.totalSent = totalSent;
		this.totalReceived = totalReceived;
		this.ftp = ftp;
		this.http = http;
		this.p2p = p2p;
		this.tcp = tcp;
		this.udp = udp;
		this.icmp = icmp;
		this.presentTime = presentTime;
	}

	public Bandwidthd() {
	}

	public String getPresentTime() {
		return presentTime;
	}

	public void setPresentTime(String presentTime) {
		this.presentTime = presentTime;
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getTotalSent() {
		return totalSent;
	}

	public void setTotalSent(String totalSent) {
		this.totalSent = totalSent;
	}

	public String getTotalReceived() {
		return totalReceived;
	}

	public void setTotalReceived(String totalReceived) {
		this.totalReceived = totalReceived;
	}

	public String getFtp() {
		return ftp;
	}

	public void setFtp(String ftp) {
		this.ftp = ftp;
	}

	public String getHttp() {
		return http;
	}

	public void setHttp(String http) {
		this.http = http;
	}

	public String getP2p() {
		return p2p;
	}

	public void setP2p(String p2p) {
		this.p2p = p2p;
	}

	public String getTcp() {
		return tcp;
	}

	public void setTcp(String tcp) {
		this.tcp = tcp;
	}

	public String getUdp() {
		return udp;
	}

	public void setUdp(String udp) {
		this.udp = udp;
	}

	public String getIcmp() {
		return icmp;
	}

	public void setIcmp(String icmp) {
		this.icmp = icmp;
	}

}
