package fr.gab400.improvident;

import fr.gab400.improvident.panels.App;
import fr.gab400.improvident.panels.PanelManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Improvident extends Application {
	
	private static Improvident instance;

	public Improvident() {
		instance = this;
	}
	
	public static Improvident getInstance() {
		return instance;
	}
	
	@Override
	public void start(Stage stage) {
		PanelManager panelManager = new PanelManager(this, stage);
		panelManager.init();
		
		panelManager.showPanel(new App());
	}

	@Override
	public void stop() {
		Platform.exit();
		System.exit(0);
	}
}
