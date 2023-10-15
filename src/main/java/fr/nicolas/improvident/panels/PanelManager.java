package fr.nicolas.improvident.panels;

import fr.nicolas.improvident.frames.Improvident;
import fr.nicolas.improvident.panels.panel.IPanel;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PanelManager {
	
	public final int WIDTH = 800;
	public final int HEIGHT = 500;
	private final Improvident improvident;
	private final Stage stage;
	private final GridPane contentPane = new GridPane();
	private GridPane layout;
	
	public PanelManager(Improvident improvident, Stage stage) {
		this.improvident = improvident;
		this.stage = stage;
	}
	
	public void init() {
		this.stage.setTitle("Improvident");
		this.stage.resizableProperty().set(false);
		this.stage.setWidth(WIDTH);
		this.stage.setHeight(HEIGHT);
		this.stage.initStyle(StageStyle.UNIFIED);
		this.stage.centerOnScreen();
		this.stage.getIcons().add(new Image("icon.png"));
		
		this.layout = new GridPane();
		
		Scene scene = new Scene(this.layout);
		
		this.stage.setScene(scene);
		
		this.layout.add(this.contentPane, 0, 0);
		GridPane.setVgrow(this.contentPane, Priority.ALWAYS);
		GridPane.setHgrow(this.contentPane, Priority.ALWAYS);
		
		this.stage.show();
	}
	
	public void showPanel(IPanel panel) {
		this.contentPane.getChildren().clear();
		this.contentPane.getChildren().add(panel.getLayout());
		if (panel.getStylesheetPath() != null) {
			this.stage.getScene().getStylesheets().clear();
			this.stage.getScene().getStylesheets().add(panel.getStylesheetPath());
		}
		panel.init(this);
		panel.onShow();
	}
	
	public Improvident getImprovident() {
		return improvident;
	}
	
	public Stage getStage() {
		return stage;
	}
}
