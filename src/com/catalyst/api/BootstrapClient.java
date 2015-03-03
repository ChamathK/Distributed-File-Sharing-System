package com.catalyst.api;


public class BootstrapClient extends AbstractClient {
	
	// bootstrap server IP address
	private String serverIP;
	// bootstrap server port
	private int serverPort;
	
	public BootstrapClient(String serverIP, int serverPort) {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
	}
	
	public void registerWithBootsrapServer(String nodeIPAddress, int nodePort, String username) {
		// auto generate message
		String messageSuffix = "REG " + nodeIPAddress + " " + nodePort + " " + username;
		int suffixLength = messageSuffix.length();
		String message = String.format("%04d", suffixLength + 5) + " " + messageSuffix;
		
		String response = writeToTCPSocket(serverIP, serverPort, message);
		System.out.println(response);
	}
	
	public void unRegisterWithBootsrapServer() {
		
	}
}
