package fr.gab400.improvident.panels.pages;

import fr.gab400.improvident.Improvident;
import fr.gab400.improvident.components.Chrono;
import fr.gab400.improvident.components.Chronos;
import fr.gab400.improvident.panels.PanelManager;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.Optional;

public class Home extends ContentPanel {
	
	GridPane contentPane = new GridPane(), buttonsPane = new GridPane();
	private int i = 0;
	private Chrono chrono;
	private final Button chronoStopBtn = new Button("Arreter le chrono");
	private boolean isChronoStopButtonShowed = false, canStop = false;
	
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
		
		contentPane.getChildren().add(buttonsPane);
		setCanTakeAllSize(buttonsPane);
		
		// chronoStopBtn
		this.chronoStopBtn.getStyleClass().add("chrono-btn");
		this.chronoStopBtn.setPrefWidth(150);
		this.chronoStopBtn.setPrefHeight(30);
		this.chronoStopBtn.setFont(new Font(15));
		this.chronoStopBtn.setTranslateX(30);
		this.chronoStopBtn.setTranslateY(60);
		this.chronoStopBtn.setOnMouseClicked(mouseEvent -> {
			if (isChronoStopButtonShowed) {
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.APPLY, ButtonType.CANCEL);
				alert.setTitle("Arreter le chrono ?");
				alert.setContentText("Etes vous sur de vouloir arreter le chrono ?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.APPLY) {
					removeChronoStopButton();
					chrono.stop();
				} else if (result.get() == ButtonType.CANCEL) {
					alert.close();
				}
			}
		});
		addButtons();
	}
	
	private void showChronoStopButton() {
		if (!isChronoStopButtonShowed) {
			buttonsPane.getChildren().clear();
			buttonsPane.getChildren().add(chronoStopBtn);
			isChronoStopButtonShowed = true;
		}
	}
	
	private void removeChronoStopButton() {
		buttonsPane.getChildren().clear();
		addButtons();
		isChronoStopButtonShowed = false;
	}
	
	private void addButtons() {
		i = 0;
		for (Chronos chronos : Chronos.values()) {
			Button chronoBtn = new Button(chronos.name);
			chronoBtn.getStyleClass().add("chrono-btn");
			setTop(chronoBtn);
			chronoBtn.setPrefWidth(150);
			chronoBtn.setPrefHeight(30);
			chronoBtn.setFont(new Font(15));
			chronoBtn.setTranslateX(30);
			chronoBtn.setTranslateY(60 + 35 * i);
			chronoBtn.setOnMouseClicked(mouseEvent -> {
				showChronoStopButton();
				chrono = new Chrono(chronos.timer, chronos.points);
			});
			
			Label pointIndicator = new Label(String.valueOf(chronos.points));
			ImageView image = new ImageView(new Image("assets/images/point.png"));
			pointIndicator.setGraphic(image);
			setTop(pointIndicator);
			pointIndicator.setFont(new Font(15));
			pointIndicator.setTranslateX(190);
			pointIndicator.setTranslateY(60 + 36 * i);
			
			
			buttonsPane.getChildren().addAll(chronoBtn, pointIndicator);
			i++;
		}
	}
}