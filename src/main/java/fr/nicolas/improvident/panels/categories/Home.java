package fr.nicolas.improvident.panels.categories;

import fr.nicolas.improvident.panels.PanelManager;

public class Home extends ContentPanel {
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
	}
}