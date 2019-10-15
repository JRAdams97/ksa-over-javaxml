package com.ksa.controller;

import com.ksa.model.SourceModel;
import com.ksa.view.SourceView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class SourceController implements EventHandler {

	private final Stage mainStage;
	private final SourceView view = new SourceView(this);
	private final SourceModel model = new SourceModel(this);

	public Stage getMainStage() {
		return mainStage;
	}

	public SourceView getView() {
		return view;
	}

	public SourceModel getModel() {
		return model;
	}

	public SourceController(final Stage mainStage) {
		this.mainStage = mainStage;
	}

	@Override
	public void handle(final Event event) {
		final Object source = event.getSource();

		if (source.equals(view.getBrowseBtn())) {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Valid XML File");
			final File sourceFile = fileChooser.showOpenDialog(mainStage);
//		} else if (source.equals(view.getSearchMenuItem())) {
//			final SearchController searchController = new SearchController(mainStage);
//			final Scene swapScene = new Scene(searchController.getView().asParent());
//
//			mainStage.setScene(swapScene);
		} else if (source.equals(view.getLoadBtn())) {
			final SearchController searchController = new SearchController(mainStage);
			final Scene swapScene = new Scene(searchController.getView(),  960, 640);

			mainStage.setScene(swapScene);
		}
	}
}
