package com.ksa;

import com.ksa.controller.SourceController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KSAMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        SourceController controller = new SourceController(primaryStage);

        primaryStage.setTitle("Keyword Snippet Analyser");
        primaryStage.setScene(new Scene(controller.getView(), 960, 640));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
