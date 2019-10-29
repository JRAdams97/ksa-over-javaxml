package com.ksa.view;

import com.ksa.controller.SearchController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class SearchView extends VBox {

	private static final String LBL_SEARCH = "Search: ";
	private static final String LBL_SEARCHRESULT = "Please enter either the title of a movie, or "
			+ "any of its associated keywords. When you press the search button, the results of "
			+ "the search operation will be visible in the text area.";

	private final SearchController controller;

	private final HBox searchPanel = new HBox();
	private final TextArea searchResults = new TextArea();
	private final Label searchResultsLbl = new Label(LBL_SEARCHRESULT);
	private final TextField searchField = new TextField();
	private final Button searchBtn = new Button("Search");
	private final Label searchFldLbl = new Label(LBL_SEARCH);
	private final Label searchTermLbl = new Label();
	private final RadioButton searchTitle = new RadioButton("Title");
	private final RadioButton searchKeyword = new RadioButton("Keyword");
	private final ToggleGroup searchTypeGrp = new ToggleGroup();

	public RadioButton getSearchTitle() {
		return searchTitle;
	}

	public RadioButton getSearchKeyword() {
		return searchKeyword;
	}

	public Label getSearchTermLbl() {
		return searchTermLbl;
	}

	public TextArea getSearchResults() {
		return searchResults;
	}

	public TextField getSearchField() {
		return searchField;
	}

	public Button getSearchBtn() {
		return searchBtn;
	}

	public SearchView(final SearchController controller) {
		this.controller = controller;

		initView();

		setAlignment(Pos.CENTER);
		setPadding(new Insets(16, 32, 16, 32));
	}

	private void initView() {
		searchField.setOnAction(controller);
		searchBtn.setOnAction(controller);
		searchTitle.setOnAction(controller);
		searchKeyword.setOnAction(controller);

		searchResultsLbl.setWrapText(true);
		searchResultsLbl.setPadding(new Insets(16, 8, 16, 8));

		searchTitle.setToggleGroup(searchTypeGrp);
		searchKeyword.setToggleGroup(searchTypeGrp);

		searchTitle.setSelected(true);
		searchTitle.setPadding(new Insets(0, 0, 0, 32));

		searchKeyword.setPadding(new Insets(0, 16, 0, 16));

		Region padRegion = new Region();
		HBox.setHgrow(padRegion, Priority.ALWAYS);

		searchTermLbl.setPadding(new Insets(16, 8, 16, 8));
		searchTermLbl.setStyle("-fx-font-weight: bold");

		searchResults.setPrefRowCount(MainView.PREF_TXTAREA_ROWS);
		searchFldLbl.setPadding(new Insets(0, 8, 0, 8));
		searchPanel.setPadding(new Insets(16, 8, 16, 8));

		searchPanel.getChildren().addAll(searchFldLbl, searchField, searchTitle,
				searchKeyword, padRegion, searchBtn);
		getChildren().addAll(searchResultsLbl, searchTermLbl, searchResults, searchPanel);
	}
}
