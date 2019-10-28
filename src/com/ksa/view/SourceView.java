package com.ksa.view;

import com.ksa.controller.SourceController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class SourceView extends VBox {

	private static final String LBL_XMLSOURCE = "To begin, please use the 'Browse' button to "
			+ "locate a valid XML file. Once the file has been selected, press 'Load' to display "
			+ "the XML contents of the file in the text area.";

	private final SourceController controller;

	private Label xmlSourceLbl = new Label(LBL_XMLSOURCE);
	private Label currentFileLbl = new Label();
	private HBox buttonBox = new HBox();
	private TextArea xmlSource = new TextArea();
	private Button browseBtn = new Button("Browse...");
	private Button loadBtn = new Button("Load XML");

	public TextArea getXmlSource() {
		return xmlSource;
	}

	public Button getBrowseBtn() {
		return browseBtn;
	}

	public Button getLoadBtn() {
		return loadBtn;
	}

	public Label getXmlSourceLbl() {
		return xmlSourceLbl;
	}

	public Label getCurrentFileLbl() {
		return currentFileLbl;
	}

	public SourceView(final SourceController controller) {
		this.controller = controller;

		initView();

		setAlignment(Pos.CENTER);
		setPadding(new Insets(16, 32, 16, 32));
	}

	private void initView() {
		browseBtn.setOnAction(controller);
		loadBtn.setOnAction(controller);

		currentFileLbl.setPadding(new Insets(0, 16, 0, 16));

		Region padRegion = new Region();
		HBox.setHgrow(padRegion, Priority.ALWAYS);

		buttonBox.setPadding(new Insets(16, 8, 16, 8));
		buttonBox.getChildren().addAll(browseBtn, currentFileLbl, padRegion, loadBtn);

		HBox.setHgrow(buttonBox, Priority.ALWAYS);

		xmlSource.setPrefRowCount(16);
		xmlSource.setEditable(false);

		xmlSourceLbl.setWrapText(true);
		xmlSourceLbl.setPadding(new Insets(16, 8, 16, 8));

		getChildren().addAll(xmlSourceLbl, xmlSource, buttonBox);
	}
}
