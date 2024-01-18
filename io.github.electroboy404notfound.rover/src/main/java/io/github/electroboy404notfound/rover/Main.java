package io.github.electroboy404notfound.rover;

import java.io.IOException;

import com.pi4j.io.serial.Baud;
import com.pi4j.io.serial.DataBits;
import com.pi4j.io.serial.FlowControl;
import com.pi4j.io.serial.Parity;
import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialConfig;
import com.pi4j.io.serial.SerialFactory;
import com.pi4j.io.serial.SerialPort;
import com.pi4j.io.serial.StopBits;
import com.pi4j.wiringpi.Gpio;

import io.github.electroboy404notfound.rover.helper.DHT11;
import io.github.electroboy404notfound.rover.helper.DHT11.DHT11Data;
import io.github.electroboy404notfound.rover.helper.MPU6050;
import io.github.electroboy404notfound.rover.server.Server;

public class Main {
	public static Main instance;
	
	private Serial serial;
	
	public DHT11Data averageData = DHT11Data.build(-1, -1, -1);
	
	public MPU6050 mpu6050Sensor;
	
	public Main() throws Exception {
		instance = this;
		
		System.out.println("Rover initlisation start");
		
		System.out.println("Connecting to wheels...");
		serial = SerialFactory.createInstance();
		
		SerialConfig config = new SerialConfig();
		config.device(SerialPort.getDefaultPort())
			  .baud(Baud._115200)
			  .dataBits(DataBits._8)
			  .parity(Parity.NONE)
			  .stopBits(StopBits._1)
			  .flowControl(FlowControl.NONE);
		serial.open(config);
		
		halt();
		System.out.println("Connected to wheels!");
		
		System.out.println("Initlising sensors...");
		if (Gpio.wiringPiSetup() == -1) {
			System.out.println(" ==>> GPIO SETUP FAILED");
			return;
		}
		
		new Thread(() -> {
			DHT11 sensor = new DHT11(7);
			
			DHT11Data currentReading;
			
			float averageF = 0;
			float averageC = 0;
			float averageH = 0;
			
			while(true) {
				for(int i = 0; i < 10; i++) {
					try {
						currentReading = sensor.getTemperature();
						averageF += currentReading.getTemperature(true);
						averageC += currentReading.getTemperature(false);
						averageH += currentReading.getHumidity();
					} catch(NullPointerException e) {
						i--;
					}
				}
				
				averageF /= 10;
				averageC /= 10;
				averageH /= 10;
				
				Main.instance.averageData = DHT11Data.build(averageF, averageC, averageH);
			}
		}, "DHT11 Sensor Read Thread").start();
		
		mpu6050Sensor = new MPU6050(0x68);
		
		System.out.println("All sensors are ready!");
		
		new Server(0x0607).startServer(this);
		
		System.out.println("Rover server has been started!");
		
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			try {
				serial.close();
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}));
	}

	public static void main(String[] args) throws Exception {
		new Main();
	}

	public void halt() throws IllegalStateException, IOException {
		serial.write('0');
	}
	public void front() throws IllegalStateException, IOException {
		serial.write('1');
	}
	public void back() throws IllegalStateException, IOException {
		serial.write('2');
	}
	public void frontLeft() throws IllegalStateException, IOException {
		serial.write('4');
	}
	public void frontRight() throws IllegalStateException, IOException {
		serial.write('3');
	}
	public void backLeft() throws IllegalStateException, IOException {
		serial.write('6');
	}
	public void backRight() throws IllegalStateException, IOException {
		serial.write('5');
	}
}
