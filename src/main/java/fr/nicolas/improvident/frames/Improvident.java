package fr.nicolas.improvident.frames;

import fr.nicolas.improvident.components.ButtonType;
import fr.nicolas.improvident.panels.App;
import fr.nicolas.improvident.panels.PanelManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Improvident extends Application {
	
	private PanelManager panelManager;
	private static Improvident instance;

	public Improvident() {
		instance = this;
	}
	
	public static Improvident getInstance() {
		return instance;
	}
	
	@Override
	public void start(Stage stage) {
		this.panelManager = new PanelManager(this, stage);
		this.panelManager.init();
		
		this.panelManager.showPanel(new App());
	}

	@Override
	public void stop() {
		Platform.exit();
		System.exit(0);
	}
}
