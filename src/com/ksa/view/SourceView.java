package com.ksa.view;

import com.ksa.controller.SourceController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class SourceView extends VBox {

	private final SourceController controller;

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

	public SourceView(final SourceController controller) {
		this.controller = controller;

		initView();

		setAlignment(Pos.CENTER);
		setPadding(new Insets(16, 32, 16, 32));
	}

	private void initView() {
		browseBtn.setOnAction(controller);
		loadBtn.setOnAction(controller);

		buttonBox.setMinWidth(getWidth());

		browseBtn.setAlignment(Pos.BASELINE_LEFT);
		loadBtn.setAlignment(Pos.BASELINE_RIGHT);

		buttonBox.getChildren().addAll(browseBtn, loadBtn);

		Label xmlSourceLbl = new Label("To begin, please browse and locate a valid XML file. You "
				+ "can then press the Load button to display the contents of the file in the text "
				+ "area.");



		xmlSourceLbl.setPadding(new Insets(16, 8, 16, 8));
		xmlSourceLbl.setWrapText(true);

		getChildren().addAll(xmlSourceLbl, xmlSource, buttonBox);

		xmlSource.setPrefRowCount(16);

		buttonBox.setPadding(new Insets(16, 8, 16, 8));
	}
}
