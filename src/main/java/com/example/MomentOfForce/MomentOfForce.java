package com.example.MomentOfForce;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class MomentOfForce extends Application {

    private Stage primaryStage;
//.........................................................................................................................

    //................................................

    Label minInfoLabel = new Label();
    Label minXLabel = new Label();
    Label maxInfoLabel = new Label();
    Label maxXLabel = new Label();
    //.........................................

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

    }
    public Label getminInfoLabel() {

        return minInfoLabel ;

    }
    public Label getminXLabel() {

        return minXLabel ;

    }
    public Label getmaxInfoLabel() {

        return maxInfoLabel ;

    }
    public Label getmaxXLabel() {

        return maxXLabel ;

    }
    public static void main(String[] args) {
        launch(args);
    }
}
