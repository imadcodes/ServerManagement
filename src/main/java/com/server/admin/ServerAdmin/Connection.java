package com.server.admin.ServerAdmin;

import java.time.LocalDateTime;

public class Connection {

	private String id;
	private String sourceServer;
	private String targetServer;
	private LocalDateTime date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSourceServer() {
		return sourceServer;
	}

	public void setSourceServer(String sourceServer) {
		this.sourceServer = sourceServer;
	}

	public String getTargetServer() {
		return targetServer;
	}

	public void setTargetServer(String targetServer) {
		this.targetServer = targetServer;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Connection [id=" + id + ", sourceServer=" + sourceServer + ", targetServer=" + targetServer + ", date="
				+ date + "]";
	}


}
