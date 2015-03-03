package com.catalyst.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract class AbstractClient {

	public String writeToTCPSocket(String serverIP, int serverPort, String message) {
		try {
			Socket socket = new Socket(serverIP, serverPort);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			PrintWriter writer = new PrintWriter(out);
			
			// write the message to socket
			writer.write(message);
			writer.flush();
			
			// read the input
			int input;
			StringBuilder builder = new StringBuilder();
			while ((input = reader.read()) != -1) {
				builder.append((char) input); 
			}
			
			socket.close();
			return builder.toString();
		} catch (UnknownHostException exp) {
			exp.printStackTrace();
			System.out.println(exp.getLocalizedMessage());
			System.exit(1);
		} catch (IOException exp) {
			exp.printStackTrace();
			System.out.println(exp.getLocalizedMessage());
			System.exit(1);
		}
		
		return null;
	}
	
}
