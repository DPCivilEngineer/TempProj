
package com.example.beleczka;

import com.example.beleczka.statka.Statyka;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Beleczka extends Application {

    private Statyka statyka;

    public Beleczka () {}

    public Beleczka(Statyka statyka) { this.statyka = statyka;

    }
    public Pane beleczkaPanel;

    double L ;
    double val2 ;
    double val3 ;
    double val4;
    double val5;
    double val6 ;

    double val2_2 ;
    double val3_3;
    double val4_4 ;
    double val5_5 ;

    public Label beleczkaOpis1;
    private Label beleczkaLabel2;
    private Label beleczkaLabel3;
    private Label beleczkaLabel4;
    private Label beleczkaLabel5;
    private Label Label6;

    private Label Label2_2;
    private Label Label3_3;
    private Label Label4_4;
    private Label Label5_5;

    private TextField beleczkaTextField1 = null;
    private TextField beleczkaTextField2 = null;
    private TextField beleczkaTextField3 = null;
    private TextField beleczkaTextField4 = null;
    private TextField beleczkaTextField5 = null;
    private TextField beleczkaTextField6 = null;

    private TextField beleczkaTextField2_2 = null;
    private TextField beleczkaTextField3_3 = null;
    private TextField beleczkaTextField4_4 = null;
    private TextField beleczkaTextField5_5 = null;
    private Label beleczkaImage1;
    private Button beleczkaOblicz;

    private Image beleczkaImage;

    //............................................................................................
    VBox beleczkaVbox = new VBox();
    VBox statykaLayout = new VBox();

    //...................................................................................................
    public VBox beleczkaMainVBox = new VBox();
    public VBox beleczkaMainLayoutOut = new VBox();

    //..........................................................................................
    public Scene beleczkaScene;

    private Stage primaryStage;



    public Pane getPanel1() {
        return beleczkaPanel;
    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        primaryStage.setOnCloseRequest(event -> {

            Platform.exit();
        });
        primaryStage.setTitle("Beleczka");

        beleczkaScene = new Scene(getBeleczkaMainVBox(primaryStage),800, 600);

        primaryStage.setScene(beleczkaScene);
        primaryStage.show();

    }

    private boolean validateGroup1Data() {
        try {
            double L = Double.parseDouble((beleczkaTextField1.getText()));
            double val2 = Double.parseDouble(beleczkaTextField2.getText());
            double val3 = Double.parseDouble(beleczkaTextField3.getText());
            double val4 = Double.parseDouble(beleczkaTextField4.getText());
            double val5 = Double.parseDouble(beleczkaTextField5.getText());
            double val6 = Double.parseDouble(beleczkaTextField6.getText());

            if (L >= 0.0 && L <= 15.0 &&
                    val2 >= 0.0 && val2 <= L &&
                    val3 >= 0.0 && val3 <= L &&
                    val4 >= 0.0 && val4 <= L &&
                    val5 >= 0.0 && val5 <= L &&
                    val6 >= 0.0 && val6 <= L &&
                    val5 < val6) {

                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean validateGroup2Data() {
        try {
            double val2_2 = Double.parseDouble(beleczkaTextField2_2.getText());
            double val3_3 = Double.parseDouble(beleczkaTextField3_3.getText());
            double val4_4 = Double.parseDouble(beleczkaTextField4_4.getText());
            double val5_5 = Double.parseDouble(beleczkaTextField5_5.getText());


            if (val2_2 >= -100.0 && val2_2 <= 100.0 &&
                    val3_3 >= -100.0 && val3_3 <= 100.0 &&
                    val4_4 >= -100.0 && val4_4 <= 100.0 &&
                    val5_5 >= -100.0 && val5_5 <= 100.0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public void saveValues() {
        L = Double.parseDouble(beleczkaTextField1.getText());
        val2 = Double.parseDouble(beleczkaTextField2.getText());
        val3 = Double.parseDouble(beleczkaTextField3.getText());
        val4 = Double.parseDouble(beleczkaTextField4.getText());
        val5 = Double.parseDouble(beleczkaTextField5.getText());
        val6 = Double.parseDouble(beleczkaTextField6.getText());

        val2_2 = Double.parseDouble(beleczkaTextField2_2.getText());
        val3_3 = Double.parseDouble(beleczkaTextField3_3.getText());
        val4_4 = Double.parseDouble(beleczkaTextField4_4.getText());
        val5_5 = Double.parseDouble(beleczkaTextField5_5.getText());
    }
    public void values() {
        System.out.println(L);
        System.out.println("get L " + getBeleczkaTextField1());
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Błąd");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void switchToStatykaPanel(Stage primaryStage) {

        Statyka statykaClass = new Statyka(this);

        statykaClass.getStatykaMainVBox(primaryStage);

        statykaLayout.getChildren().add(statykaClass.getStatMainLayout());

        Scene scene = new Scene(statykaLayout, 900, 650);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public double getBeleczkaTextField1() {
        return  L;
    }

    public double getBeleczkaTextField2() {
        return val2;
    }

    public double getBeleczkaTextField3() {
        return val3;
    }

    public double getBeleczkaTextField4() {
        return val4;
    }

    public double getBeleczkaTextField5() {
        return val5;
    }

    public double getBeleczkaTextField6() {
        return val6;
    }

    public double getBeleczkaTextField2_2() {
        return val2_2;
    }

    public double getBeleczkaTextField3_3() {
        return  val3_3;
    }

    public double getBeleczkaTextField4_4() {
        return val4_4;
    }

    public double getBeleczkaTextField5_5() {
        return val5_5;
    }

    public VBox getBeleczkaMainVBox(Stage primaryStage) {
        this.primaryStage = primaryStage;
        GridPane grid = new GridPane();
        grid.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);

        GridPane gridImage = new GridPane();
        gridImage.setAlignment(Pos.CENTER);
        gridImage.setHgap(10);
        gridImage.setVgap(10);

        beleczkaOpis1 = new Label("Enter the length L [m]");
        beleczkaTextField1 = new TextField();

        beleczkaLabel2 = new Label("Enter the value x1 [m]");
        beleczkaTextField2 = new TextField();

        beleczkaLabel3 = new Label("Enter the value x2 [m]");
        beleczkaTextField3 = new TextField();

        beleczkaLabel4 = new Label("Enter the value x3 [m]");
        beleczkaTextField4 = new TextField();

        beleczkaLabel5 = new Label("Enter the value x4 [m]");
        beleczkaTextField5 = new TextField();

        Label6 = new Label("Enter the value x5 [m]");
        beleczkaTextField6 = new TextField();
//.....................................................................................................
        Label2_2 = new Label("Enter the value Mz [KNm]");
        beleczkaTextField2_2 = new TextField();

        Label3_3 = new Label("Enter the value Hx [KN]");
        beleczkaTextField3_3 = new TextField();

        Label4_4 = new Label("Enter the value Vy [KN]");
        beleczkaTextField4_4 = new TextField();

        Label5_5 = new Label("Enter the valueć qy [KN/m]");
        beleczkaTextField5_5 = new TextField();

        beleczkaOblicz = new Button("Calculate");

        beleczkaOpis1.setPrefWidth(150);
        beleczkaOpis1.setPrefHeight(30);
        grid.add(beleczkaOpis1, 1, 1);

        beleczkaTextField1.setPrefWidth(50);
        beleczkaTextField1.setPrefHeight(30);
        grid.add(beleczkaTextField1, 2, 1);


        beleczkaTextField2.setPrefWidth(50);
        beleczkaTextField2.setPrefHeight(30);
        grid.add(beleczkaLabel2, 1, 2);
        grid.add(beleczkaTextField2, 2, 2);


        beleczkaTextField3.setPrefWidth(50);
        beleczkaTextField3.setPrefHeight(30);
        grid.add(beleczkaLabel3, 1, 3);
        grid.add(beleczkaTextField3, 2, 3);


        beleczkaTextField4.setPrefWidth(50);
        beleczkaTextField4.setPrefHeight(30);
        grid.add(beleczkaLabel4, 1, 4);
        grid.add(beleczkaTextField4, 2, 4);


        beleczkaTextField5.setPrefWidth(50);
        beleczkaTextField5.setPrefHeight(30);
        grid.add(beleczkaLabel5, 1, 5);
        grid.add(beleczkaTextField5, 2, 5);


        beleczkaTextField6.setPrefWidth(50);
        beleczkaTextField6.setPrefHeight(30);
        grid.add(Label6, 1, 6);
        grid.add(beleczkaTextField6, 2, 6);

//................................................................................................................
        beleczkaTextField2_2.setPrefWidth(50);
        beleczkaTextField2_2.setPrefHeight(30);
        grid.add(Label2_2, 6, 2);
        grid.add(beleczkaTextField2_2, 7, 2);

        beleczkaTextField3_3.setPrefWidth(50);
        beleczkaTextField3_3.setPrefHeight(30);
        grid.add(Label3_3, 6, 3);
        grid.add(beleczkaTextField3_3, 7, 3);

        beleczkaTextField4_4.setPrefWidth(50);
        beleczkaTextField4_4.setPrefHeight(30);
        grid.add(Label4_4, 6, 4);
        grid.add(beleczkaTextField4_4, 7, 4);

        beleczkaTextField5_5.setPrefWidth(50);
        beleczkaTextField5_5.setPrefHeight(30);
        grid.add(Label5_5, 6, 5);
        grid.add(beleczkaTextField5_5, 7, 5);

        beleczkaOblicz.setPrefWidth(200);
        beleczkaOblicz.setPrefHeight(30);
        grid.add(beleczkaOblicz, 10, 4);

        beleczkaOblicz.setOnAction(event -> {

            if (!validateGroup1Data()) {
                showAlert("The entered data in the length range is invalid");
            } else if (!validateGroup2Data()) {
                showAlert("The entered data in the load range is invalid");
            } else {
                saveValues();
                switchToStatykaPanel(primaryStage);
            }
            values();
        });

        String imagePath = "/belka.png";

        beleczkaImage = new Image(getClass().getResourceAsStream(imagePath));

        ImageView imageView = new ImageView( beleczkaImage);

        imageView.setFitWidth(600);
        imageView.setFitHeight(400);
        gridImage.add(imageView, 1, 1);

        imageView.setImage(beleczkaImage);

        beleczkaVbox.getChildren().addAll(grid);
        beleczkaVbox.getChildren().addAll(gridImage);

        beleczkaMainLayoutOut = beleczkaVbox;

        return beleczkaMainLayoutOut;
    }
}






