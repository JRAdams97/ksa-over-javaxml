package com.ksa;

import com.ksa.controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KSAMain extends Application {

    public static final Integer STAGE_WIDTH = 800;
    public static final Integer STAGE_HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) {
        MainController controller = new MainController(primaryStage);

        primaryStage.setTitle("Keyword Snippet Analyser");
        primaryStage.setScene(new Scene(controller.getPrimaryView(), STAGE_WIDTH, STAGE_HEIGHT));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
