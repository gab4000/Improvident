package fr.gab400.improvident.panels.panel;

import fr.gab400.improvident.panels.PanelManager;
import javafx.scene.layout.GridPane;

public interface IPanel {
	
	void init(PanelManager panelManager);
	GridPane getLayout();
	void onShow();
	String getName();
	String getStylesheetPath();
}
