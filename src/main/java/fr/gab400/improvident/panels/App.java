package fr.gab400.improvident.panels;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import fr.gab400.improvident.panels.categories.*;
import fr.gab400.improvident.components.ButtonType;
import fr.gab400.improvident.panels.panel.Panel;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class App extends Panel {
	
	GridPane sideMenu = new GridPane();
	GridPane navContent = new GridPane();
	public ButtonType type;
	private Label title;
	
	Node activeLink;
	
	ContentPanel currentPage;
	
	Button homeBtn, csBtn, cvBtn, coBtn, ceBtn, pBtn, settingsBtn;
	
	@Override
	public String getName() {
		return null;
	}
	
	@Override
	public String getStylesheetPath() {
		return "css/app.css";
	}
	
	@Override
	public void init(PanelManager panelManager) {
		super.init(panelManager);
		
		// Background
		this.layout.getStyleClass().add("app-layout");
		setCanTakeAllSize(layout);
		
		ColumnConstraints columnConstraints = new ColumnConstraints();
		columnConstraints.setHalignment(HPos.LEFT);
		columnConstraints.setMaxWidth(50);
		columnConstraints.setMinWidth(50);
		this.layout.getColumnConstraints().addAll(columnConstraints, new ColumnConstraints());
		this.layout.add(sideMenu, 0, 0);
		
		// Bg Image
		GridPane bgImage = new GridPane();
		setCanTakeAllSize(bgImage);
		bgImage.getStyleClass().add("bg-image");
		this.layout.add(bgImage, 1, 0);
		
		// Side Menu
		setCanTakeAllSize(this.layout);
		sideMenu.getStyleClass().add("side-menu");
		setLeft(sideMenu);
		setCenterH(sideMenu);
		setCenterV(sideMenu);
		
		// Nav content
		this.layout.add(navContent, 1, 0);
		navContent.getStyleClass().add("nav-content");
		setLeft(navContent);
		setCenterH(navContent);
		setCenterV(navContent);
		
		// App page
		title = new Label();
		title.setFont(Font.font("Roboto", FontWeight.BOLD, FontPosture.REGULAR, 30f));
		title.getStyleClass().add("app-title");
		setCanTakeAllSize(title);
		setTop(title);
		title.setTranslateY(10d);
		title.setTranslateX(20d);
		bgImage.getChildren().add(title);
		
		/*
		 * Side menu
		 */
		
		// HomeBtn
		FontAwesomeIconView home = new FontAwesomeIconView(FontAwesomeIcon.HOME);
		home.getStyleClass().add("icon");
		homeBtn = new Button();
		homeBtn.getStyleClass().add("sidemenu-nav-btn");
		homeBtn.setGraphic(home);
		setCanTakeAllSize(homeBtn);
		setCenterV(homeBtn);
		homeBtn.setTranslateY(- 200d);
		setCenterH(homeBtn);
		homeBtn.setOnMouseClicked(e -> setPage(new Home(), homeBtn));
		
		// CSBtn
		FontAwesomeIconView cs = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);
		cs.getStyleClass().add("icon");
		csBtn = new Button();
		csBtn.getStyleClass().add("sidemenu-nav-btn");
		csBtn.setGraphic(cs);
		setCanTakeAllSize(csBtn);
		setCenterV(csBtn);
		csBtn.setTranslateY(- 150d);
		setCenterH(csBtn);
		csBtn.setOnMouseClicked(e -> setPage(new CS(), csBtn));
		
		// CVBtn
		FontAwesomeIconView cv = new FontAwesomeIconView(FontAwesomeIcon.VIDEO_CAMERA);
		cv.getStyleClass().add("icon");
		cvBtn = new Button();
		cvBtn.getStyleClass().add("sidemenu-nav-btn");
		cvBtn.setGraphic(cv);
		setCanTakeAllSize(cvBtn);
		setCenterV(cvBtn);
		cvBtn.setTranslateY(- 100d);
		setCenterH(cvBtn);
		cvBtn.setOnMouseClicked(e -> setPage(new CV(), cvBtn));
		
		// COBtn
		FontAwesomeIconView co = new FontAwesomeIconView(FontAwesomeIcon.COMMENTING);
		co.getStyleClass().add("icon");
		coBtn = new Button();
		coBtn.getStyleClass().add("sidemenu-nav-btn");
		coBtn.setGraphic(co);
		setCanTakeAllSize(coBtn);
		setCenterV(coBtn);
		coBtn.setTranslateY(- 50d);
		setCenterH(coBtn);
		coBtn.setOnMouseClicked(e -> setPage(new CO(), coBtn));
		
		// CEBtn
		FontAwesomeIconView ce = new FontAwesomeIconView(FontAwesomeIcon.BOOK);
		ce.getStyleClass().add("icon");
		ceBtn = new Button();
		ceBtn.getStyleClass().add("sidemenu-nav-btn");
		ceBtn.setGraphic(ce);
		setCanTakeAllSize(ceBtn);
		setCenterV(ceBtn);
		ceBtn.setTranslateY(0d);
		setCenterH(ceBtn);
		ceBtn.setOnMouseClicked(e -> setPage(new CE(), ceBtn));
		
		// PBtn
		FontAwesomeIconView p = new FontAwesomeIconView(FontAwesomeIcon.GAMEPAD);
		p.getStyleClass().add("icon");
		pBtn = new Button();
		pBtn.getStyleClass().add("sidemenu-nav-btn");
		pBtn.setGraphic(p);
		setCanTakeAllSize(pBtn);
		setCenterV(pBtn);
		pBtn.setTranslateY(50d);
		setCenterH(pBtn);
		pBtn.setOnMouseClicked(e -> setPage(new Points(), pBtn));
		
		// SettingsBtn
		FontAwesomeIconView settings = new FontAwesomeIconView(FontAwesomeIcon.GEARS);
		settings.getStyleClass().add("icon");
		settingsBtn = new Button();
		settingsBtn.getStyleClass().add("sidemenu-nav-btn");
		settingsBtn.setGraphic(settings);
		setCanTakeAllSize(settingsBtn);
		setCenterV(settingsBtn);
		settingsBtn.setTranslateY(100d);
		setCenterH(settingsBtn);
		settingsBtn.setOnMouseClicked(e -> setPage(new Settings(), settingsBtn));
		
		sideMenu.getChildren().addAll(homeBtn, csBtn, cvBtn, coBtn, ceBtn, pBtn, settingsBtn);
	}
	@Override
	public void onShow() {
		super.onShow();
		setPage(new Home(), homeBtn);
	}
	
	public void setPage(ContentPanel panel, Node navBtn) {
		
		if (activeLink != null) activeLink.getStyleClass().remove("active");
		activeLink = navBtn;
		activeLink.getStyleClass().add("active");
		
		this.navContent.getChildren().clear();
		if (panel != null) {
			this.navContent.getChildren().add(panel.getLayout());
			currentPage = panel;
			title.setText(currentPage.getName());
			if (panel.getStylesheetPath() != null) {
				this.panelManager.getStage().getScene().getStylesheets().clear();
				this.panelManager.getStage().getScene().getStylesheets().addAll(this.getStylesheetPath(), panel.getStylesheetPath());
			}
			panel.init(this.panelManager);
			panel.onShow();
		}
	}
}
