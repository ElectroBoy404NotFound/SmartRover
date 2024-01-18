package io.github.electroboy404notfound.rover.helper;

import com.pi4j.wiringpi.I2C;

public class MPU6050 {
	public static final byte MPU6050_REG_PWR_MGMT_1   = 0x6B;
	public static final byte MPU6050_REG_SMPLRT_DIV   = 0x19;
	public static final byte MPU6050_REG_CONFIG       = 0x1A;
	public static final byte MPU6050_REG_GYRO_CONFIG  = 0x1B;
	public static final byte MPU6050_REG_INT_ENABLE   = 0x38;
	public static final byte MPU6050_REG_ACCEL_XOUT_H = 0x3B;
	public static final byte MPU6050_REG_ACCEL_YOUT_H = 0x3D;
	public static final byte MPU6050_REG_ACCEL_ZOUT_H = 0x3F;
	public static final byte MPU6050_REG_GYRO_XOUT_H  = 0x43;
	public static final byte MPU6050_REG_GYRO_YOUT_H  = 0x45;
	public static final byte MPU6050_REG_GYRO_ZOUT_H  = 0x47;
	
	private int fd;
	
	public MPU6050(int i2cAddress) {
		this.fd = I2C.wiringPiI2CSetup(i2cAddress);

		I2C.wiringPiI2CWriteReg8(fd, MPU6050_REG_SMPLRT_DIV, 7);
		I2C.wiringPiI2CWriteReg8(fd, MPU6050_REG_PWR_MGMT_1, 1);
		I2C.wiringPiI2CWriteReg8(fd, MPU6050_REG_CONFIG, 0);
		I2C.wiringPiI2CWriteReg8(fd, MPU6050_REG_GYRO_CONFIG, 24);
		I2C.wiringPiI2CWriteReg8(fd, MPU6050_REG_INT_ENABLE, 1);
	}	
	
	private int readRawData(int addr) {
		int high = I2C.wiringPiI2CReadReg8(fd, addr);
		int low = I2C.wiringPiI2CReadReg8(fd, addr+1);
		
		int value = ((high << 8) | low);
		if(value > 32768)
            value -= 65536;
		
		return value;
	}
	
	public MPU6050Data getData() {
		return MPU6050Data.build(readRawData(MPU6050_REG_GYRO_XOUT_H), readRawData(MPU6050_REG_GYRO_YOUT_H), readRawData(MPU6050_REG_GYRO_ZOUT_H), readRawData(MPU6050_REG_ACCEL_XOUT_H), readRawData(MPU6050_REG_ACCEL_YOUT_H), readRawData(MPU6050_REG_ACCEL_ZOUT_H));
	}
	
	public static class MPU6050Data {
		private int x, y, z, ax, ay, az;
		
		private MPU6050Data(int x, int y, int z, int ax, int ay, int az) {
			this.x = x;
			this.y = y;
			this.z = z;
			
			this.ax = ax;
			this.ay = ay;
			this.az = az;
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public int getZ() {
			return z;
		}
		
		public int getAX() {
			return ax;
		}
		public int getAY() {
			return ay;
		}
		public int getAZ() {
			return az;
		}
		
		public static MPU6050Data build(int x, int y, int z, int ax, int ay, int az) {
			return new MPU6050Data(x, y, z, ax, ay, az);
		}
	}
}
