package me.electronicsboy.roverguiproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.JSONObject;

/*
Based on https://github.com/ElectroGamingStudios/JavaGameEngine/tree/main/src/main/java/me/ElectronicsBoy/PureJavaGameEngine/networking
 */
public class Client {
    private Socket socket;
	private DataListener dl;
	private PrintWriter printWriter;

    public Client(String ip, int port) {
    	this.dl = new DataListener() {	
			@Override
			public void gotData(JSONObject data) {
				System.out.println("IGNORE " + data);
			}
		};
    	try {
            Client.this.socket = new Socket(ip, port);
            System.out.println("Connected");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    	
    	new Thread(() -> {
            BufferedReader bf;
            try {
                bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                printWriter = new PrintWriter(socket.getOutputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                while(true) {
                    String line;
                    while ((line = bf.readLine()) != null) {
                        try {
                            Client.this.dl.gotData(new JSONObject(line));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void sendData(String state) {
        try {
            printWriter.println(state);
            printWriter.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void setDataListner(DataListener dl) {
    	this.dl = dl;
    }
    
    public interface DataListener {
        void gotData(JSONObject data);
    }
}