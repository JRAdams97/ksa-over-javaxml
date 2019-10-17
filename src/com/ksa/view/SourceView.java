package com.ksa.view;

import com.ksa.controller.SourceController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
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

		this.browseBtn.setOnAction(controller);
		this.loadBtn.setOnAction(controller);

		this.buttonBox.getChildren().addAll(browseBtn, loadBtn);
		this.getChildren().addAll(xmlSource, buttonBox);

		initView();
	}

	private void initView() {
		setAlignment(Pos.CENTER);
		setPadding(new Insets(16, 32, 16, 32));
	}
}
