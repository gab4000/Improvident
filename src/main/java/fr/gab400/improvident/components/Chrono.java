package fr.gab400.improvident.components;

import javafx.scene.control.Alert;

import java.io.*;

public class Chrono implements Runnable {
	
	private int initialTime;
	private int time;
	private int sec = 60;
	private int gain;
	private boolean isRunning = false;
	private boolean canStart = true;
	
	public Chrono(int time, int gain) {
		this.initialTime = time;
		this.time = time;
		this.gain = gain;
		
		start();
	}
	
	public void start() {
		if (canStart) {
			isRunning = true;
			new Thread(this).start();
		}
	}
	
	public void stop() {
		isRunning = false;
		
	}
	
	@Override
	public void run() {
		while (isRunning) {
			canStart = false;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			sec--;
			if (sec <= 0) {
				sec = 60;
				time--;
			}
			if (time <= 0) {
				this.stop();
				
				int oldPoints = 0;
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader("categories/p/points.txt"));
					oldPoints = Integer.parseInt(bufferedReader.readLine());
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				oldPoints += gain;
				
				try {
					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("categories/p/points.txt"));
					bufferedWriter.write("" + oldPoints);
					bufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText("Chrono termine");
				alert.setContentText("Votre chrono de " + initialTime + "min est termine");
				alert.show();
			}
			canStart = true;
		}
	}
	
	public boolean isRunning() {
		return isRunning;
	}
	
	public void setRunning(boolean running) {
		isRunning = running;
	}
}
