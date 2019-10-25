package com.ksa;

import com.ksa.controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KSAMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        MainController controller = new MainController(primaryStage);

        primaryStage.setTitle("Keyword Snippet Analyser");
        primaryStage.setScene(new Scene(controller.getPrimaryView(), 640, 480));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
