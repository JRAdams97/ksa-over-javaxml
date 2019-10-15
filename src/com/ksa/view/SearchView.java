package com.ksa.view;

import com.ksa.controller.SearchController;
import com.ksa.controller.SourceController;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class SearchView extends VBox {

	private final SearchController controller;

	private GridPane layout;
	private final TextField searchField = new TextField();
	private final Button searchBtn = new Button("Search");

//	private final MenuBar menuBar = new MenuBar();
//	private final Menu menu = new Menu("Main Menu");
//	private final MenuItem sourceMenuItem = new MenuItem("Source");
//	private final MenuItem searchMenuItem = new MenuItem("Search");
//	private final MenuItem visualizationMenuItem = new MenuItem("Visualization");

	public TextField getSearchField() {
		return searchField;
	}

	public Button getSearchBtn() {
		return searchBtn;
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

	public SearchView(final SearchController controller) {
		this.controller = controller;

		this.searchField.setOnAction(controller);
		this.searchBtn.setOnAction(controller);

		this.getChildren().addAll(searchField, searchBtn);
//		this.sourceMenuItem.setOnAction(controller);

		initView();
	}

	private void initView() {
//		menu.getItems().addAll(sourceMenuItem, searchMenuItem, visualizationMenuItem);
//		menuBar.getMenus().add(menu);

		setAlignment(Pos.CENTER);
		setMaxWidth(400);
	}
}
