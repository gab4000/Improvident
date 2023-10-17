package fr.gab400.improvident.panels.panel;

import javafx.scene.Node;

public interface IMovable {
	
	void setLeft(Node node);
	void setRight(Node node);
	void setTop(Node node);
	void setBottom(Node node);
	void setBaseline(Node node);
	void setCenterH(Node node);
	void setCenterV(Node node);
}
