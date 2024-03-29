package io.github.electroboy404notfound.rover.helper;
import com.pi4j.wiringpi.Gpio;

public class DHT11 {
	private static final int MAXTIMINGS = 85;
	
	private final int[] dht11_dat = { 0, 0, 0, 0, 0 };

	private final int pin;
	
	public DHT11(final int pin) {
		this.pin = pin;
	}

	public DHT11Data getTemperature() {
		int laststate = Gpio.HIGH;
		int j = 0;
		dht11_dat[0] = dht11_dat[1] = dht11_dat[2] = dht11_dat[3] = dht11_dat[4] = 0;

		Gpio.pinMode(pin, Gpio.OUTPUT);
		Gpio.digitalWrite(pin, Gpio.LOW);
		Gpio.delay(18);

		Gpio.digitalWrite(pin, Gpio.HIGH);
		Gpio.pinMode(pin, Gpio.INPUT);

		for (int i = 0; i < MAXTIMINGS; i++) {
			int counter = 0;
			while (Gpio.digitalRead(pin) == laststate) {
				counter++;
				Gpio.delayMicroseconds(1);
				if (counter == 255) {
					break;
				}
			}

			laststate = Gpio.digitalRead(pin);

			if (counter == 255) {
				break;
			}

			/* ignore first 3 transitions */
			if (i >= 4 && i % 2 == 0) {
				/* shove each bit into the storage bytes */
				dht11_dat[j / 8] <<= 1;
				if (counter > 16) {
					dht11_dat[j / 8] |= 1;
				}
				j++;
			}
		}
		// check we read 40 bits (8bit x 5 ) + verify checksum in the last
		// byte
		if (j >= 40 && checkParity()) {
			float h = (float) ((dht11_dat[0] << 8) + dht11_dat[1]) / 10;
			if (h > 100) {
				h = dht11_dat[0]; // for DHT11
			}
			float c = (float) (((dht11_dat[2] & 0x7F) << 8) + dht11_dat[3]) / 10;
			if (c > 125) {
				c = dht11_dat[2]; // for DHT11
			}
			if ((dht11_dat[2] & 0x80) != 0) {
				c = -c;
			}
			final float f = c * 1.8f + 32;
			
			return DHT11Data.build(f, c, h);
		}
		
//		System.out.println("Invalid sensor data! *skipped*");
		return null;

	}

	private boolean checkParity() {
		return dht11_dat[4] == (dht11_dat[0] + dht11_dat[1] + dht11_dat[2] + dht11_dat[3] & 0xFF);
	}
	
	public static class DHT11Data {
		private float temperaturef, temperaturec, humidity;
		
		private DHT11Data(float f, float c, float h) {
			this.temperaturef = f;
			this.temperaturec = c;
			this.humidity = h;
		}
		
		public float getTemperature(boolean fahrenheit) {
			return fahrenheit ? temperaturef : temperaturec;
		}
		public float getHumidity() {
			return humidity;
		}
		
		public static DHT11Data build(float f, float c, float h) {
			return new DHT11Data(f, c, h);
		}
	}
}
