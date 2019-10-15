package com.ksa.view;

import com.ksa.controller.SourceController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SourceView extends VBox {

	private final SourceController controller;

	private BorderPane headLayout = new BorderPane();
	private VBox bodyLayout = new VBox();

	private TextArea xmlSource;
	private Button browseBtn = new Button("Browse...");
	private Button loadBtn = new Button("Load XML");
//	private final MenuBar menuBar = new MenuBar();
//	private final Menu menu = new Menu("Main Menu");
//	private final MenuItem sourceMenuItem = new MenuItem("Source");
//	private final MenuItem searchMenuItem = new MenuItem("Search");
//	private final MenuItem visualizationMenuItem = new MenuItem("Visualization");

	public TextArea getXmlSource() {
		return xmlSource;
	}

	public Button getBrowseBtn() {
		return browseBtn;
	}

	public Button getLoadBtn() {
		return loadBtn;
	}

//	public MenuBar getMenuBar() {
//		return menuBar;
//	}

//	public Menu getMenu() {
//		return menu;
//	}
//
//	public MenuItem getSourceMenuItem() {
//		return sourceMenuItem;
//	}
//
//	public MenuItem getSearchMenuItem() {
//		return searchMenuItem;
//	}
//
//	public MenuItem getVisualizationMenuItem() {
//		return visualizationMenuItem;
//	}

	public SourceView(final SourceController controller) {
		this.controller = controller;

		this.browseBtn.setOnAction(controller);
		this.loadBtn.setOnAction(controller);

		this.getChildren().addAll(browseBtn, loadBtn);
//		this.searchMenuItem.setOnAction(controller);

		initView();
	}

	private void initView() {
		xmlSource = new TextArea();

//		menu.getItems().addAll(sourceMenuItem, searchMenuItem, visualizationMenuItem);
//		menuBar.getMenus().add(menu);

//		bodyLayout.setAlignment(Pos.CENTER);
//		bodyLayout.getChildren().addAll(xmlSource, browseBtn, loadBtn);
//
//		headLayout.setTop(menuBar);
//		headLayout.setCenter(bodyLayout);

		setAlignment(Pos.CENTER);
		setMaxWidth(400);
	}
}
