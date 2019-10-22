package com.ksa.controller;

import com.ksa.model.MainModel;
import com.ksa.model.SearchModel;
import com.ksa.view.SearchView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class SearchController implements EventHandler {

	private Stage mainStage;
	private final SearchView view = new SearchView(this);
	private final SearchModel model = new SearchModel(this);

	public Stage getMainStage() {
		return mainStage;
	}

	public SearchView getView() {
		return view;
	}

	public SearchModel getModel() {
		return model;
	}

	public SearchController(final Stage mainStage) {
		this.mainStage = mainStage;
	}

	@Override
	public void handle(final Event event) {
		Object source = event.getSource();

		if (source.equals(view.getSearchBtn())) {
			view.getSearchResults().setText(MainModel.getDatabaseContent());
		}
	}
}
