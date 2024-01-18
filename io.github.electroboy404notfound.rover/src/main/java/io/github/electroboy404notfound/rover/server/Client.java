package io.github.electroboy404notfound.rover.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import io.github.electroboy404notfound.rover.Main;

public class Client {
	protected InputStreamReader in;
	protected BufferedReader bf;
	private PrintWriter pw;
	private Socket socket;
	
	private Main main;
	
	public Client(Socket socket, Main main) throws IOException {
		this.socket = socket;
		in = new InputStreamReader(socket.getInputStream());
		bf = new BufferedReader(in);
		pw = new PrintWriter(socket.getOutputStream());
		this.main = main;
		
		System.out.println(socket.getInetAddress().getHostAddress() + " is now connected!");
		
		try (Scanner s = new Scanner(bf)) {
			while(true) {
				while(s.hasNext()) 
					try { dataReceive(s.nextLine()); }
					catch(Exception e) { e.printStackTrace(); }
			}
		}
	}

	private void dataReceive(String nextLine) throws IllegalStateException, IOException {
		System.out.println("[INFO] Recieved data: " + nextLine);
		JSONObject jsonObject = new JSONObject(nextLine);
		if(jsonObject.has("inputs")) {
			JSONArray jsonInputs = jsonObject.getJSONArray("inputs");
			
			// Front
			boolean front = jsonInputs.getBoolean(0);
			// Back
			boolean back = jsonInputs.getBoolean(1);
			
			// Front left
			boolean frontLeft = jsonInputs.getBoolean(2);
			// Front right
			boolean frontRight = jsonInputs.getBoolean(3);
			
			// Back left
			boolean backLeft = jsonInputs.getBoolean(4);
			// Back right
			boolean backRight = jsonInputs.getBoolean(5);
			
			boolean halt = !(front || back || frontLeft || frontRight || backLeft || backRight);
			
			if(halt) main.halt();
			else
				if(front) main.front();
				else if (back) main.back();
				else if(frontLeft) main.frontLeft();
				else if(frontRight) main.frontRight();
				else if(backLeft) main.backLeft();
				else if(backRight) main.backRight();
			
			System.out.println(front + " " + halt);
		}
		
		JSONObject jsonObjects = new JSONObject();
		JSONObject jsonSensors = new JSONObject();
		
		JSONObject jsonSensorsDHT11 = new JSONObject();
		jsonSensorsDHT11.put("temp_C", Main.instance.averageData.getTemperature(false));
		jsonSensorsDHT11.put("temp_F", Main.instance.averageData.getTemperature(true));
		jsonSensorsDHT11.put("humid", Main.instance.averageData.getHumidity());
		jsonSensors.put("DHT11", jsonSensorsDHT11);
		
		JSONObject jsonSensorsMPU6050 = new JSONObject();
		
		jsonSensorsMPU6050.put("x", Main.instance.mpu6050Sensor.getData().getX());
		jsonSensorsMPU6050.put("y", Main.instance.mpu6050Sensor.getData().getY());
		jsonSensorsMPU6050.put("z", Main.instance.mpu6050Sensor.getData().getZ());
		
		jsonSensorsMPU6050.put("ax", Main.instance.mpu6050Sensor.getData().getAX());
		jsonSensorsMPU6050.put("ay", Main.instance.mpu6050Sensor.getData().getAY());
		jsonSensorsMPU6050.put("az", Main.instance.mpu6050Sensor.getData().getAZ());
		
		jsonSensors.put("MPU6050", jsonSensorsMPU6050);
		
		jsonObjects.put("sensors", jsonSensors);
		pw.write(jsonObjects.toString());
		pw.write("\r\n");
		pw.flush();
		
		System.out.println(jsonObjects.toString() + " has been sent");
	}

	public void end() throws Exception {
		pw.close();
		socket.close();
	}
}
