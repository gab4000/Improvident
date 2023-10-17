package fr.gab400.improvident.components;

public enum Chronos {
	
	Q("Chrono 15min", 15, 10),
	T("Chrono 30min", 30, 15),
	QC("Chrono 45min", 45, 25),
	H("Chrono 1h", 60, 40),
	HT("Chrono 1h30", 90, 65);
	
	public String name;
	public int timer;
	public int points;
	
	Chronos(String name, int timer, int points) {
		this.name = name;
		this.timer = timer;
		this.points = points;
	}
}
