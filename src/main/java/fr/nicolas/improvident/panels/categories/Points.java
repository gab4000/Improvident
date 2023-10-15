package fr.nicolas.improvident.panels.categories;

public class Points extends ContentPanel {
	
	private String mapPath;
	
	@Override
	public String getName() {
		return "Points";
	}
	
	@Override
	public String getStylesheetPath() {
		return "css/content/points.css";
	}
	
	public void setMapPath(String mapPath) {
		this.mapPath = mapPath;
	}
}
