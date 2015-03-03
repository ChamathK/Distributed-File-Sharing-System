package com.catalyst;
import com.catalyst.api.BootstrapClient;
import com.catalyst.utils.Configuration;

public class Main {

	public static void main(String args[]) {
		
		// register with bootstrap server
		BootstrapClient bsClient = new BootstrapClient(Configuration.SERVER_IP, Configuration.SERVER_PORT);
		bsClient.registerWithBootsrapServer(Configuration.CLIENT_IP, Configuration.CLIENT_PORT, "catalyst");
		
	}
	
}
