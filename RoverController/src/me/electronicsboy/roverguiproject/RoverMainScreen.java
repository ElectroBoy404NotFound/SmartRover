package me.electronicsboy.roverguiproject;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.Icon;

import org.json.JSONArray;
import org.json.JSONObject;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author elect
 */
public class RoverMainScreen extends javax.swing.JFrame implements NativeKeyListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = -219042031269438717L;

	private boolean[] inputs = new boolean[8];
	
	private static RoverMainScreen instance;
	
	/**
     * Creates new form NewJFrame
	 * @throws NativeHookException 
     */
    public RoverMainScreen() throws NativeHookException {
    	HashMap<Integer, Integer> keymap = new HashMap<>();
    	keymap.put(17, 1); // W
    	keymap.put(31, 2); // S
    	
    	keymap.put(30, 3); // A
    	keymap.put(32, 4); // D
    	
    	keymap.put(57416, 5); // Up arrow
    	keymap.put(57424, 6); // Down arrow
    	
    	keymap.put(57419, 7); // Left arrow
    	keymap.put(57421, 8); // Right arrow
    	
    	TempStorage.addOrSet("KEYMAP", keymap);
    	
    	instance = this;
    	
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws NativeHookException 
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws NativeHookException {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        gyro = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        axelright = new javax.swing.JLabel();
        axeldown = new javax.swing.JLabel();
        axelup = new javax.swing.JLabel();
        axelright1 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        tempF = new javax.swing.JLabel();
        tempC = new javax.swing.JLabel();
        humid = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        videoToggleButton = new javax.swing.JToggleButton();
        gyroCalib = new javax.swing.JButton();
        axelCalib = new javax.swing.JButton();
        inputToggleButton = new javax.swing.JToggleButton();
        changeKeymap = new javax.swing.JButton();
        panelLiveVideo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        liveVideo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);;
        
        jPanel1.setPreferredSize(new java.awt.Dimension(1020, 780));
        
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Control Panel");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Sensor Data");

        gyro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gyro.setText("Gyro X: 255  Y: 255  Z: 255 ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Accelerometer");

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\elect\\Downloads\\rover.jpg")); // NOI18N

        axelright.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        axelright.setText("0.0");

        axeldown.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        axeldown.setText("0.0");

        axelup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        axelup.setText("0.0");

        axelright1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        axelright1.setText("0.0");

        label1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label1.setText("Temperature & Humidity");

        tempF.setText("100 °F");

        tempC.setText("200 °C");

        humid.setText("100%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gyro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(39, 39, 39)
                                            .addComponent(axelup, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(axeldown, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(axelright1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(axelright, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tempC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tempF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(humid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gyro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(axelright))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(axelup)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(axelright1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(axeldown)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tempF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tempC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(humid)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel3.setText("Settings");

        videoToggleButton.setText("Recieve Video");

        gyroCalib.setText("Calibrate Gyro");
        gyroCalib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gyroCalibActionPerformed(evt);
            }
        });

        axelCalib.setText("Calibrate Accelerometer");
        axelCalib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                axelCalibActionPerformed(evt);
            }
        });

        inputToggleButton.setText("Use Arrow Keys for Input");

        changeKeymap.setText("Change Key Bindings");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(videoToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(axelCalib, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gyroCalib, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changeKeymap, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(videoToggleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gyroCalib)
                    .addComponent(changeKeymap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(axelCalib)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputToggleButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel6.setText("Live Video");

        jPanel5.setPreferredSize(new java.awt.Dimension(320, 240));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(liveVideo, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(liveVideo, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelLiveVideoLayout = new javax.swing.GroupLayout(panelLiveVideo);
        panelLiveVideo.setLayout(panelLiveVideoLayout);
        panelLiveVideoLayout.setHorizontalGroup(
            panelLiveVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLiveVideoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLiveVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLiveVideoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLiveVideoLayout.setVerticalGroup(
            panelLiveVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLiveVideoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelLiveVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelLiveVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 234, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        
        GlobalScreen.addNativeKeyListener(this);
        GlobalScreen.registerNativeHook();
        
//        ServerIPDialog dialog = new ServerIPDialog(new javax.swing.JFrame(), true);
//        dialog.setVisible(true);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ServerIPDialog dialog = new ServerIPDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }// </editor-fold>                        

    private void gyroCalibActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void axelCalibActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    @SuppressWarnings("unchecked")
	@Override
    public void nativeKeyPressed(NativeKeyEvent arg0) {
    	NativeKeyListener.super.nativeKeyPressed(arg0);
    	
//    	System.out.println(arg0.getKeyCode() + " PRESS "  + arg0.getKeyChar());
    	
    	if(((HashMap<Integer, Integer>) TempStorage.get("KEYMAP")).get(arg0.getKeyCode()) != null && this.getFocusOwner() != null) {
    		System.out.println(((HashMap<Integer, Integer>) TempStorage.get("KEYMAP")).get(arg0.getKeyCode()) + " PRESS");
    		inputs[((HashMap<Integer, Integer>) TempStorage.get("KEYMAP")).get(arg0.getKeyCode()) - 1] = true;
    	}
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public void nativeKeyReleased(NativeKeyEvent arg0) {
    	NativeKeyListener.super.nativeKeyReleased(arg0);
    	
//    	System.out.println(arg0.getKeyCode() + " RELEASE " + arg0.getKeyChar());
    	
    	if(((HashMap<Integer, Integer>) TempStorage.get("KEYMAP")).get(arg0.getKeyCode()) != null && this.getFocusOwner() != null) {
    		System.out.println(((HashMap<Integer, Integer>) TempStorage.get("KEYMAP")).get(arg0.getKeyCode()) + " RELEASED");
    		inputs[((HashMap<Integer, Integer>) TempStorage.get("KEYMAP")).get(arg0.getKeyCode()) - 1] = false;
    	}
    }                      

    /**
     * @param args the command line arguments
     * @throws NativeHookException 
     */
    public static void main(String args[]) throws NativeHookException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            	if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RoverMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoverMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoverMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoverMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        new RoverMainScreen().setVisible(true);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton axelCalib;
    private javax.swing.JLabel axeldown;
    private javax.swing.JLabel axelright;
    private javax.swing.JLabel axelright1;
    private javax.swing.JLabel axelup;
    private javax.swing.JButton changeKeymap;
    private javax.swing.JLabel gyro;
    private javax.swing.JButton gyroCalib;
    private javax.swing.JLabel humid;
    private javax.swing.JToggleButton inputToggleButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private java.awt.Label label1;
    private javax.swing.JLabel liveVideo;
    private javax.swing.JPanel panelLiveVideo;
    private javax.swing.JLabel tempC;
    private javax.swing.JLabel tempF;
    private javax.swing.JToggleButton videoToggleButton;
    // End of variables declaration                   
	
    public void start() {
		new Thread(() -> {
			((Client) TempStorage.get("CLIENT")).setDataListner((json) -> {
				JSONObject sensors = json.getJSONObject("sensors");
				JSONObject DHT11 = sensors.getJSONObject("DHT11");
				RoverMainScreen.this.tempC.setText("Centigrade: " + DHT11.getBigDecimal("temp_C").toString() + "°C");
				RoverMainScreen.this.tempF.setText("Fahrenheit: " + DHT11.getBigDecimal("temp_F").toString() + "°F");
				RoverMainScreen.this.humid.setText("Humidity: " + DHT11.getBigDecimal("humid").toString() + "%");
				
				System.out.println(json);
			});
			long lastTime = System.nanoTime();
			while(true) {
				if((System.nanoTime() - lastTime) >= 100000000) {
					try {
						JSONObject inputs = new JSONObject();
						JSONArray arr = new JSONArray();
						
						arr.put(RoverMainScreen.this.inputs[0]);
						arr.put(RoverMainScreen.this.inputs[1]);
						
						arr.put(RoverMainScreen.this.inputs[2]);
						arr.put(RoverMainScreen.this.inputs[3]);
						
						arr.put(false);
						arr.put(false);
						
						inputs.put("inputs", arr);
						
						System.out.println(inputs.toString());
						
						((Client) TempStorage.get("CLIENT")).sendData(inputs.toString());
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					lastTime = System.nanoTime();
				}
			}
		}, "Network Thread").start();
		
		new Thread(() -> {
			while(true) {
				try  {
					URL url = new URL("http://192.168.29.188/capture");
				    Image image = ImageIO.read(url);
				    liveVideo.setIcon(new Icon() {
						
						@Override
						public void paintIcon(Component c, Graphics g, int x, int y) {
							g.drawImage(image, x, y, null);
						}
						
						@Override
						public int getIconWidth() {
							return 320;
						}
						
						@Override
						public int getIconHeight() {
							return 240;
						}
					});
				} catch (IOException e) {
				    e.printStackTrace();
				}
			}
		}, "Camera Thread").start();
	}
    
    public static RoverMainScreen getInstance() {
    	return instance;
    }
}