import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;

public class RoverClient {

    private static JLabel sensorLabel;
    private static boolean[] inputArray = new boolean[6]; // W, A, S, D, Space, Enter
    private static BufferedImage videoFrame;

    public static void main(String[] args) {
        // Create UI components
        JFrame frame = new JFrame("Rover Client");
        JPanel mainPanel = new JPanel(new BorderLayout());
        sensorLabel = new JLabel("Sensor Data: ");
        mainPanel.add(sensorLabel, BorderLayout.NORTH);

        // Video panel to display live stream
        JPanel videoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (videoFrame != null) {
                    g.drawImage(videoFrame, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        mainPanel.add(videoPanel, BorderLayout.CENTER);

        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

        try {
            // Connect to the rover TCP server
            Socket roverSocket = new Socket("192.168.29.98", 0x607);
            BufferedReader roverReader = new BufferedReader(new InputStreamReader(roverSocket.getInputStream()));
            PrintWriter roverWriter = new PrintWriter(roverSocket.getOutputStream(), true);

            // Connect to the camera HTTP server
//            URL cameraURL = new URL("http://192.168.29.188/stream");
            // Use the cameraURL to access the live video stream, you may need to use a library like OpenCV for this.

            // Create a JSON object for sending input data to the rover
            JSONObject inputJson = new JSONObject();

            // Set up keyboard input handling
            frame.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    handleKeyPress(e.getKeyChar());
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    handleKeyRelease(e.getKeyChar());
                }
            });

            // Main loop for continuous communication
            while (true) {
            	// Simulate keyboard input (W, A, S, D) based on user interaction or other logic
                inputJson.put("inputs", new JSONArray()
                        .put(inputArray[0]) // W
                        .put(inputArray[1]) // A
                        .put(inputArray[2]) // S
                        .put(inputArray[3]) // D
                        .put(inputArray[4]) // Space
                        .put(inputArray[5])); // Enter

                // Send input data to the rover
                roverWriter.println(inputJson.toString());
                System.out.println(inputJson.toString());
                // Receive sensor data from the rover
                String sensorData = roverReader.readLine();
                processSensorData(sensorData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processSensorData(String sensorData) {
        // Parse and process the received sensor data from the rover
        JSONObject sensorJson = new JSONObject(sensorData);
        JSONObject sensorValues = sensorJson.getJSONObject("sensors");

        // Extract sensor values and update the UI
        double temperatureC = sensorValues.getJSONObject("DHT11").getDouble("temp_C");
        double temperatureF = sensorValues.getJSONObject("DHT11").getDouble("temp_F");
        double humidity = sensorValues.getJSONObject("DHT11").getDouble("humid");
//        double accelerometerX = sensorValues.getJSONObject("MPU6050").getDouble("x");
//        double accelerometerY = sensorValues.getJSONObject("MPU6050").getDouble("y");
//        double accelerometerZ = sensorValues.getJSONObject("MPU6050").getDouble("z");
//        double accelerationX = sensorValues.getJSONObject("MPU6050").getDouble("ax");
//        double accelerationY = sensorValues.getJSONObject("MPU6050").getDouble("ay");
//        double accelerationZ = sensorValues.getJSONObject("MPU6050").getDouble("az");

        // Update the UI with the sensor data
        SwingUtilities.invokeLater(() -> {
            sensorLabel.setText("Sensor Data: " +
                    "Temperature=" + temperatureC + "°C, " +
                    "Temperature=" + temperatureF + "°F, " +
                    "Humidity=" + humidity + "%, " );
//                    "Accelerometer X=" + accelerometerX + ", " +
//                    "Accelerometer Y=" + accelerometerY + ", " +
//                    "Accelerometer Z=" + accelerometerZ + ", " +
//                    "Acceleration X=" + accelerationX + ", " +
//                    "Acceleration Y=" + accelerationY + ", " +
//                    "Acceleration Z=" + accelerationZ);
        });

        // Add your logic here to handle sensor data
    }

    private static void handleKeyPress(char key) {
        switch (key) {
            case 'w':
                inputArray[0] = true; // W
                break;
            case 'a':
                inputArray[1] = true; // A
                break;
            case 's':
                inputArray[2] = true; // S
                break;
            case 'd':
                inputArray[3] = true; // D
                break;
            // Handle other keys as needed
        }
    }

    private static void handleKeyRelease(char key) {
        switch (key) {
            case 'w':
                inputArray[0] = false; // W
                break;
            case 'a':
                inputArray[1] = false; // A
                break;
            case 's':
                inputArray[2] = false; // S
                break;
            case 'd':
                inputArray[3] = false; // D
                break;
            // Handle other keys as needed
        }
    }
}
