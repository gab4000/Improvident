package fr.gab400.improvident.panels.pages;

import fr.gab400.improvident.panels.PanelManager;

public class CV extends Coures {
	@Override
	public String getName() {
		return "Cours videos";
	}
	
	@Override
	public void init(PanelManager panelManager) {
		super.init(panelManager);
		
		load();
	}
}