package fr.gab400.improvident.panels.pages;

import fr.gab400.improvident.panels.PanelManager;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.File;

public class Settings extends ContentPanel {
	
	private final FileChooser fileChooser = new FileChooser();
	GridPane contentPane = new GridPane();
	private Points points;
	
	@Override
	public String getName() {
		return "Parametres";
	}
	
	@Override
	public String getStylesheetPath() {
		return "css/content/settings.css";
	}
	
	@Override
	public void init(PanelManager panelManager) {
		super.init(panelManager);
		
		// Background
		this.layout.getStyleClass().add("settings-layout");
		
		// Content
		contentPane.getStyleClass().add("content-pane");
		setCanTakeAllSize(contentPane);
		this.layout.getChildren().add(contentPane);
		
		Label selected = new Label("(Aucune map selectionee)");
		selected.setTranslateX(30);
		selected.setTranslateY(100);
		contentPane.getChildren().add(selected);
		
		// File chooser
		fileChooser.setTitle("Sauvegarder le chemin de la map");
		Button chooseFile = new Button("Chemin de la map");
		chooseFile.setOnMouseClicked(actionEvent -> {
			File file = fileChooser.showOpenDialog(panelManager.getStage());
			points.setMapPath(file.getPath());
			selected.setText("(Map enregistree : " + file.getAbsoluteFile() + ")");
			Alert response = new Alert(Alert.AlertType.CONFIRMATION);
			response.setHeaderText("Map sauvegardee");
			response.setContentText("Votre map a bien ete sauvegardee !");
			response.show();
		});
		chooseFile.getStyleClass().add("choose-file-btn");
		chooseFile.setPrefWidth(125);
		chooseFile.setPrefHeight(30);
		setTop(chooseFile);
		chooseFile.setTranslateX(30);
		chooseFile.setTranslateY(70);
		contentPane.getChildren().add(chooseFile);
	}
}
