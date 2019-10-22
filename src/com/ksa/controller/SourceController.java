package com.ksa.controller;

import com.ksa.XMLDataLoader;
import com.ksa.model.MainModel;
import com.ksa.model.SourceModel;
import com.ksa.model.entity.Database;
import com.ksa.view.SourceView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class SourceController implements EventHandler {

	private final Stage mainStage;
	private final SourceView view = new SourceView(this);
	private static final XMLDataLoader dataLoader = new XMLDataLoader();
	private static File sourceFile;

	public Stage getMainStage() {
		return mainStage;
	}

	public SourceView getView() {
		return view;
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
			sourceFile = fileChooser.showOpenDialog(mainStage);

			Database movieDatabase = new Database();

			XMLDataLoader dataLoader = new XMLDataLoader();
			try {
				movieDatabase = dataLoader.parseAsMovie(sourceFile);
			} catch (JAXBException e) {
				System.out.println("JAXB error. " + e);
			}

			System.out.println(movieDatabase.getClass().toString());
			String test = "test";

		} else if (source.equals(view.getLoadBtn())) {
			StringBuilder builder = new StringBuilder();

			if (sourceFile != null) {
				try (Stream<String> fileStream = Files.lines(Paths.get(sourceFile.getPath()))) {
					fileStream.forEach(s -> builder.append(s).append(System.lineSeparator()));
				} catch (IOException ioEx) {
					// TODO: Add logger
					ioEx.printStackTrace();
				}

				MainModel.setDatabaseContent(builder.toString());

				view.getXmlSource().setText(MainModel.getDatabaseContent());
			}
		}
	}
}
