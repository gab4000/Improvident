package fr.gab400.improvident.panels.categories;

import fr.gab400.improvident.components.Chronos;
import fr.gab400.improvident.panels.PanelManager;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Home extends ContentPanel {
	
	GridPane contentPane = new GridPane();
	private int i;
	
	@Override
	public String getName() {
		return "Accueil";
	}
	
	@Override
	public String getStylesheetPath() {
		return "css/content/home.css";
	}

	@Override
	public void init(PanelManager panelManager) {
		super.init(panelManager);
		
		// Background
		this.layout.getStyleClass().add("home-layout");
		
		// Content
		contentPane.getStyleClass().add("content-pane");
		setCanTakeAllSize(contentPane);
		this.layout.getChildren().add(contentPane);
		
		for (Chronos chronos : Chronos.values()) {
			Button chronoBtn = new Button(chronos.name);
			chronoBtn.getStyleClass().add("chrono-btn-" + chronos.timer);
			setTop(chronoBtn);
			chronoBtn.setTranslateX(30);
			chronoBtn.setTranslateY(60 + 30 * i);
			contentPane.getChildren().add(chronoBtn);
			i++;
		}
	}
}