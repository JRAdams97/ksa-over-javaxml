package com.ksa.controller;

import com.ksa.XMLDataLoader;
import com.ksa.model.MainModel;
import com.ksa.model.SourceModel;
import com.ksa.model.entity.Database;
import com.ksa.view.SourceView;
import com.ksa.model.SourceModel;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * This controller handles events and user actions that execute on the 'Source'
 * page of the application. It contains a reference to the application
 * {@link Stage} and a {@code dataLoader} instance for parsing XML file
 * content. References the MVC pattern by aggregating an associated
 * {@code view} ({@link SourceView}) and {@code model} ({@link SourceModel})
 *
 * @author jradams97
 * @author tianlu102238612
 * @version 0.2
 */
public class SourceController implements EventHandler {

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//  Fields
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Reference to application stage.
	 */
	private final Stage mainStage;

	/**
	 * Associated view. Provided a controller instance on initialisation.
	 */
	private final SourceView view = new SourceView(this);

	/**
	 * Associated model. Provided a controller instance on initialisation.
	 */
	private final SourceModel model = new SourceModel(this);

	/**
	 * Data handling class used to oversee parsing of XML information and
	 * validate entity structure.
	 */
	private static final XMLDataLoader dataLoader = new XMLDataLoader();

	/**
	 * File obtained through {@link FileChooser#showOpenDialog(Window)}
	 * action. Shared through different event triggers
	 */
	private File sourceFile;

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//  Accessors and Mutators
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public Stage getMainStage() {
		return mainStage;
	}

	SourceView getView() {
		return view;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//  Constructor(s)
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Class constructor. References the main stage of the application
	 *
	 * @param mainStage  Global stage used for all application classes.
	 */
	SourceController(final Stage mainStage) {
		this.mainStage = mainStage;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//  Methods
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Overridden implementation of {@link EventHandler#handle(Event)} that
	 * determines actions to perform when user actions are performed.
	 * {@code browseBtn} is handled to prompt for an input file. The selected
	 * source file is then parsed as a Java entity (POJO) and stored in a
	 * global model ({@link MainModel}) for easy access on other scenes.
	 * {@code loadBtn} is handled to take the obtained {@code sourceFile},
	 * stream its contents into the global model, and display it in the
	 * text area ({@code xmlSourceFld})
	 *
	 * @param event  Obtained from the {@link javafx.event.EventDispatcher}.
	 *               Defines a "notification" when a specific action occurs.
	 * @see Stream
	 */
	@Override
	public void handle(final Event event) {
		final Object source = event.getSource();

		if (source.equals(view.getBrowseBtn())) {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Valid XML File");
			sourceFile = fileChooser.showOpenDialog(mainStage);

			Database movieDatabase = new Database();

			try {
				movieDatabase = dataLoader.parseAsMovie(sourceFile);
			} catch (JAXBException e) {
				// TODO: Add logger
				System.out.println("JAXB error. " + e);
			} catch (Exception e) {
				e.printStackTrace();
			}

			MainModel.setDatabaseEntity(movieDatabase);

		} else if (source.equals(view.getLoadBtn())) {
			StringBuilder builder = new StringBuilder();

			if (sourceFile != null) {
				try (Stream<String> fileStream = Files.lines(Paths.get(sourceFile.getPath()))) {
					fileStream.forEach(s -> builder.append(s).append(System.lineSeparator()));
				} catch (IOException ioEx) {
					// TODO: Add logger
					ioEx.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

				MainModel.setDatabaseContent(builder.toString());

				view.getXmlSource().setText(MainModel.getDatabaseContent());
			}
		}
	}
}
