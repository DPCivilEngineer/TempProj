package com.example.beleczka.statka;

import com.example.MomentOfForce.MomentOfForce;
import com.example.beleczka.Beleczka;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingNode;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.text.DecimalFormat;

public class Statyka extends Application {


    private Beleczka beleczka;

    public Statyka() {
    }

    public Statyka(Beleczka beleczka) {
        this.beleczka = beleczka;
    }
    public Label statykaOpis1;
    public Label statykaVAyLabel;
    public Label statykaVByLabel;
    public Label statykaHBxLabel;

    public Label statykaReakcjaVAy;
    public Label statykaReakcjaVBy;
    public Label statykaReakcjaHBx;

    public Button statykaReakcjeButton;

    private Button statykaMomentOfFunction;
    private Button statykaVForceOfFunction;
    private Button statykaHForceOfFunction;

    private Button statykaCofnij;
    //..........................................................................................................
    //private Label valueLabel;

    private Label valueOfL;
    private Label valueOfx1;
    private Label valueOfx2;
    private Label valueOfx3;
    private Label valueOfx4;
    private Label valueOfx5;

    private Label valueOfMz;
    private Label valueOfHx;
    private Label valueOfVy;
    private Label valueOfqy;

    private Image statykaImage;

    Button calculateButtonMOF = new Button("Calculate Min/Max for M(x)");
    Button calculateButtonVF = new Button("Calculate Min/Max for T(x)");
    Button calculateButtonHF = new Button("Calculate Min/Max for H(x)");

    Label minInfoLabelMOF = new Label();
    Label minXLabelMOF = new Label();
    Label maxInfoLabelMOF = new Label();
    Label maxXLabelMOF = new Label();

    Label minInfoLabelVF = new Label();
    Label minXLabelVF = new Label();
    Label maxInfoLabelVF = new Label();
    Label maxXLabelVF = new Label();

    Label minInfoLabelHF = new Label();
    Label minXLabelHF = new Label();
    Label maxInfoLabelHF = new Label();
    Label maxXLabelHF = new Label();

    //........................................................................................................................
    //BorderPane root = new BorderPane();
    public VBox StatykaMainVBox = new VBox();
    public VBox statykaMainLayoutOut = new VBox();
    public Scene statykaScene;

    //MomentOfForce momentOfForce = new MomentOfForce();
    //VBox MFOVBox = new VBox();
    VBox beleczkaLayout = new VBox();

    //......................................................................................................
    public double getMofL() {
        double MofL = beleczka.getBeleczkaTextField1();
        return MofL;
    }
    public double getMofx1() {
        double Mofx1 = beleczka.getBeleczkaTextField2();
        return Mofx1;
    }
    public double getMofx2() {
        double Mofx2 = beleczka.getBeleczkaTextField3();
        return Mofx2;
    }
    public double getMofx3() {
        double Mofx3 = beleczka.getBeleczkaTextField4();
        return Mofx3;
    }
    public double getMofx4() {
        double Mofx4 = beleczka.getBeleczkaTextField5();
        return Mofx4;
    }
    public double getMofx5 () {
        double Mofx5 = beleczka.getBeleczkaTextField6();
        return Mofx5;
    }
    public double getMoMz () {
        double MofMz = beleczka.getBeleczkaTextField2_2();
        return MofMz;
    }
    public double getMofHx () {
        double MofHx = beleczka.getBeleczkaTextField3_3();
        return MofHx;
    }
    public double getMofVy () {
        double MofVy = beleczka.getBeleczkaTextField4_4();
        return MofVy;
    }
    public double getMofqy () {
        double Mofqy = beleczka.getBeleczkaTextField5_5();
        return Mofqy;
    }
    //.....................................................................................................................
    public Stage primaryStage;
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
        });

        primaryStage.setTitle("Statics");

        getStatykaMainVBox(primaryStage);
        statykaScene = new Scene(getStatykaMainVBox(primaryStage), 800, 600);
        primaryStage.setScene(statykaScene);
        primaryStage.show();
    }
    //***************** StatykaStart_1 *****************
    public void calculateReakcje() {

        double statL = getMofL();
        double statx1 = getMofx1();
        double statx2 = getMofx2();
        double statx3 = getMofx3();
        double statx4 = getMofx4();
        double statx5 = getMofx5();

        double statMz = getMoMz();
        double statHx = getMofHx();
        double statVy = getMofVy();
        double statqy = getMofqy();

        double statQ = statqy * (statx5 - statx4);
        double statqOnL = statQ / statL;

        double statReakcja_VAy1 = statqOnL * (statx4 + (statx5 - statx4) * 0.5);
        double statReakcja_VAy2 = (statVy * statx3) / statL;
        double statReakcja_VAy3 = -(statMz / statL);
        double statRreakcja_VAy = statReakcja_VAy1 + statReakcja_VAy2 + statReakcja_VAy3;

        double statReakcja_VBy1 = -statReakcja_VAy1 + statQ;
        double statReakcja_VBy2 = -statReakcja_VAy2 + statVy;
        double statReakcja_VBy3 = -statReakcja_VAy3;
        double statReakcja_VBy = statReakcja_VBy1 + statReakcja_VBy2 + statReakcja_VBy3;

        double statReakcja_HBx = statHx;

        DecimalFormat df = new DecimalFormat("#0.0000");
        statykaReakcjaVAy.setText(df.format(statRreakcja_VAy));
        statykaReakcjaVBy.setText(df.format(statReakcja_VBy));
        statykaReakcjaHBx.setText(df.format(statReakcja_HBx));
    }
    //***************** StatykaKoniec_1 *****************

    //***************** BeleczkaStart_1 *****************
    public VBox getStatMainLayout() {
        return StatykaMainVBox;
    }
    //***************** BeleczkaKoniec_1 *****************

    //***************** StatykaStart_2 *****************
    public VBox getStatykaMainVBox(Stage primaryStage) {
        this.primaryStage = primaryStage;

        GridPane gridTitle = new GridPane();
        gridTitle.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        gridTitle.setHgap(15);
        gridTitle.setVgap(15);

        GridPane gridSetValues = new GridPane();
        gridSetValues.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        gridSetValues.setHgap(10);
        gridSetValues.setVgap(20);

        GridPane gridButtons = new GridPane();
        gridButtons.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        gridButtons.setHgap(15);
        gridButtons.setVgap(15);

        GridPane gridImages = new GridPane();
        gridImages.setAlignment(Pos.TOP_CENTER);
        gridImages.setHgap(15);
        gridImages.setVgap(15);

        statykaOpis1 = new Label("Support reaction values");

        statykaVAyLabel = new Label("Value of reaction VAy [kN] =");
        statykaReakcjaVAy = new Label("-     ");

        statykaVByLabel = new Label("Value of reaction VBy [kN] =");
        statykaReakcjaVBy = new Label("-     ");
//.......................................................................................
        valueOfL = new Label("L = " +getMofL() + "[m]");
        valueOfx1 = new Label("X1 = " + getMofx1() + "[m]");
        valueOfx2 = new Label("X2 = " + getMofx2() + "[m]");
        valueOfx3 = new Label("X3 = " + getMofx3() + "[m]");
        valueOfx4 = new Label("X4 = " + getMofx4() + "[m]");
        valueOfx5 = new Label("X5 = " + getMofx5() + "[m]");

        valueOfMz = new Label("Mz = " + getMoMz() + "[KNm]");
        valueOfHx = new Label("Hx = " + getMofHx() + "[KN]");
        valueOfVy = new Label("Vy = " + getMofVy() + "[KN]");
        valueOfqy = new Label("qy = " + getMofqy() + "[KN/m]");
//.............................................................................
        statykaHBxLabel = new Label("Value of reaction HBx [kN] =");
        statykaReakcjaHBx = new Label("-     ");

        statykaReakcjeButton = new Button("Calculate reactions");
        statykaReakcjeButton.setPrefWidth(120); // Ustaw szerokość na 200 pikseli
        statykaReakcjeButton.setPrefHeight(30);
        statykaReakcjeButton.setOnAction(event ->{

            beleczka.getBeleczkaTextField1();
            calculateReakcje();
            valuesStat();
        });

        statykaMomentOfFunction = new Button("Moments of forces");
        statykaMomentOfFunction.setPrefWidth(120); // Ustaw szerokość na 200 pikseli
        statykaMomentOfFunction.setPrefHeight(30);
        statykaMomentOfFunction.setOnAction(event ->{
            switchToMomentOfForce();
        });

        statykaVForceOfFunction = new Button("Shear forces");
        statykaVForceOfFunction.setPrefWidth(120); // Ustaw szerokość na 200 pikseli
        statykaVForceOfFunction.setPrefHeight(30);
        statykaVForceOfFunction.setOnAction(event ->{
            switchToVerticalOfForce();

        });

        statykaHForceOfFunction = new Button("Axial forces");
        statykaHForceOfFunction.setPrefWidth(120); // Ustaw szerokość na 200 pikseli
        statykaHForceOfFunction.setPrefHeight(30);
        statykaHForceOfFunction.setOnAction(event ->{
            switchToHorizontallOfForce();

        });

        statykaCofnij = new Button("Back");
        statykaCofnij.setPrefWidth(120); // Ustaw szerokość na 200 pikseli
        statykaCofnij.setPrefHeight(30);
        statykaCofnij.setOnAction(event ->{
            switchToBeleczkaPanel(primaryStage);
        });




        gridTitle.add(statykaOpis1, 1, 1);

        gridSetValues.add(statykaVAyLabel, 1, 2);
        gridSetValues.add(statykaReakcjaVAy, 2, 2);
        gridSetValues.add(statykaVByLabel, 1, 3);
        gridSetValues.add(statykaReakcjaVBy, 2, 3);
        gridSetValues.add(statykaHBxLabel, 1, 4);
        gridSetValues.add(statykaReakcjaHBx, 2, 4);

        gridSetValues.add(valueOfL,10,2);
        gridSetValues.add(valueOfx1,10,3);
        gridSetValues.add(valueOfx2,10,4);

        gridSetValues.add(valueOfx3,11,2);
        gridSetValues.add(valueOfx4,11,3);
        gridSetValues.add(valueOfx5,11,4);

        gridSetValues.add(valueOfMz,12,2);
        gridSetValues.add(valueOfHx,12,3);
        gridSetValues.add(valueOfVy,12,4);

        gridSetValues.add(valueOfqy,13,2);

        gridButtons.add(statykaReakcjeButton, 1, 1);

        gridButtons.add(statykaMomentOfFunction,3 , 2);
        gridButtons.add(statykaVForceOfFunction, 6, 2);
        gridButtons.add(statykaHForceOfFunction, 9, 2);
        gridButtons.add(statykaCofnij, 12, 2);

        String imagePath = "belka.png";
        statykaImage = new Image(imagePath);
        ImageView imageView = new ImageView( statykaImage);

        imageView.setFitWidth(600);
        imageView.setFitHeight(400);
        gridImages.add(imageView, 1, 1);
        imageView.setImage(statykaImage);

        StatykaMainVBox.getChildren().add(gridTitle);
        StatykaMainVBox.getChildren().add(gridSetValues);
        StatykaMainVBox.getChildren().add(gridButtons);
        StatykaMainVBox.getChildren().add(gridImages);

        statykaMainLayoutOut = StatykaMainVBox;

        return statykaMainLayoutOut;

    }
    //***************** StatykaKoniec_2 **************


    //***************** TEST **************
    public void valuesStat() {
        System.out.println(beleczka.getBeleczkaTextField1());
    }
    //***************** TEST **************
    //***************** StatykaToMOFStart_1 **************
    public void switchToMomentOfForce() {

        Label valueLabel = new Label();
        Slider slider = new Slider();

        double L = getMofL();
        double x1 = getMofx1();
        double x2 = getMofx2();
        double x3 = getMofx3();
        double x4 = getMofx4();
        double x5 = getMofx5();

        double Mz = getMoMz();
        double Hx = getMofHx();
        double Vy = getMofVy();
        double qy = getMofqy();

        double reakcja_VAy1;
        double reakcja_VAy2;
        double reakcja_VAy3;

        double reakcja_VBy1;
        double reakcja_VBy2;
        double reakcja_VBy3;

        double reakcja_Hx;

        double Q = qy * (x5 - x4);
        double qOnL = Q / L;

        reakcja_VBy1 = qOnL * (x4 + (x5 - x4) * 0.5);
        reakcja_VBy2 = (Vy * x3) / L;
        reakcja_VBy3 = -(Mz / L);

        reakcja_VAy1 = (-reakcja_VBy1 + Q);
        reakcja_VAy2 = (-reakcja_VBy2 + Vy);
        reakcja_VAy3 = (-reakcja_VBy3);

        reakcja_Hx = (Hx);

        BorderPane root = new BorderPane();
        Stage primaryStage = new Stage();

        VBox vbox1 = new VBox();

        // Button calculateButton = new Button("Policz Min/Max dla M(x)");

        SwingNode swingNode = new SwingNode();

        MomentOfForce momentOfForce1 = new MomentOfForce();
        getCombinedChartMOF();
        getCombinedChartMOF().getXYPlot().getRangeAxis().setInverted(true);

        swingNode.setContent(new ChartPanel(getCombinedChartMOF()));

        slider = new Slider(0, 10, 0); // Przedział od 0 do 10, początkowa wartość ustawiona na 0
        slider.setBlockIncrement(0.1);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double x = newValue.doubleValue();


            double MofMzL = (x <= x1) ? reakcja_VAy3 * x : 0; // Funkcja liniowa od momentu lewa strona
            double MofMzR = (x > x1 && x <= L) ? reakcja_VAy3 * x - Mz : 0; // Funkcja liniowa od momentu prawa strona

            double MofVyL = (x <= x3) ? reakcja_VAy2 * x : 0;
            double MofVyR = (x > x3 && x <= L) ? reakcja_VAy2 * x - Vy * (x - x3) : 0;

            double MofqyL = (x <= x4) ? reakcja_VAy1 * x : 0;
            double MofqyR = (x > x4 && x <= x5) ? reakcja_VAy1 * x - qy * (x - x4) * (x - x4) * 0.5 : 0;
            double MofqyEnd = (x > x5 && x <= L) ? reakcja_VAy1 * x - qy * (x5 - x4) * ((x5 - x4) * 0.5 + (x - x5)) : 0;

            double MofMz = MofMzL + MofMzR + MofVyL + MofVyR + MofqyL + MofqyR + MofqyEnd;
            valueLabel.setText("M(x) = " + String.format("%.2f", MofMz) + " x = " + String.format("%.2f", x)); // Formatowanie wartości Y do dwóch miejsc po przecinku

        });

        TextField xInput = new TextField();
        xInput = new TextField();
        xInput.setPromptText("Enter the value of x [m] to read the value of the moment"); // Tekst podpowiedzi w polu tekstowym

        // Dodawanie listenera do pola tekstowego, aby odczytać wartość Y po wprowadzeniu X
        TextField finalXInput = xInput;
        xInput.setOnAction(e -> {
            try {
                double x = Double.parseDouble(finalXInput.getText());
                double MofMzL = (x <= x1) ? reakcja_VAy3 * x : 0; // Funkcja liniowa od momentu lewa strona
                double MofMzR = (x > x1 && x <= L) ? reakcja_VAy3 * x - Mz : 0; // Funkcja liniowa od momentu prawa strona

                double MofVyL = (x <= x3) ? reakcja_VAy2 * x : 0;
                double MofVyR = (x > x3 && x <= L) ? reakcja_VAy2 * x - Vy * (x - x3) : 0;

                double MofqyL = (x <= x4) ? reakcja_VAy1 * x : 0;
                double MofqyR = (x > x4 && x <= x5) ? reakcja_VAy1 * x - qy * (x - x4) * (x - x4) * 0.5 : 0;
                double MofqyEnd = (x > x5 && x <= L) ? reakcja_VAy1 * x - qy * (x5 - x4) * ((x5 - x4) * 0.5 + (x - x5)) : 0;

                double MofMz = MofMzL + MofMzR + MofVyL + MofVyR + MofqyL + MofqyR + MofqyEnd;
                valueLabel.setText("M(x) = " + String.format("%.2f", MofMz));
            } catch (NumberFormatException ex) {
                valueLabel.setText("Invalid input"); // Wyświetlenie informacji o błędnym formacie danych
            }
        });



        momentOfForce1.getminInfoLabel();
        momentOfForce1.getminXLabel();
        momentOfForce1.getmaxInfoLabel();
        momentOfForce1.getmaxXLabel();

        vbox1.getChildren().addAll(

                slider,
                // momentOfForce1.getxInput(),
                xInput,
                valueLabel,
                getCalculateButtonMOF(),
                // getCalculateButton() = ChartFactory.createXYLineChart();
                //getcalculateButton,
                minInfoLabelMOF,
                minXLabelMOF,
                maxInfoLabelMOF,
                maxXLabelMOF,

                momentOfForce1.getminInfoLabel(),
                momentOfForce1.getminXLabel(),
                momentOfForce1.getmaxInfoLabel(),
                momentOfForce1.getmaxXLabel()
        );

        root.setCenter(swingNode);
        root.setBottom(vbox1);

        Scene scene = new Scene(root, 800, 600);

        // Ustawienie i wyświetlenie sceny
        primaryStage.setTitle("Moments of forces diagram");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //***************** StatykaToMOFStart_1 **************
    //***************** StatykaToVFStart_1 **************
    public void switchToVerticalOfForce() {

        Label valueLabel = new Label();
        Slider slider = new Slider();

        double L = getMofL();
        double x1 = getMofx1();
        double x2 = getMofx2();
        double x3 = getMofx3();
        double x4 = getMofx4();
        double x5 = getMofx5();

        double Mz = getMoMz();
        double Hx = getMofHx();
        double Vy = getMofVy();
        double qy = getMofqy();

        double reakcja_VAy1;
        double reakcja_VAy2;
        double reakcja_VAy3;

        double reakcja_VBy1;
        double reakcja_VBy2;
        double reakcja_VBy3;

        double reakcja_Hx;

        double Q = qy * (x5 - x4);
        double qOnL = Q / L;

        reakcja_VBy1 = qOnL * (x4 + (x5 - x4) * 0.5);
        reakcja_VBy2 = (Vy * x3) / L;
        reakcja_VBy3 = -(Mz / L);

        reakcja_VAy1 = (-reakcja_VBy1 + Q);
        reakcja_VAy2 = (-reakcja_VBy2 + Vy);
        reakcja_VAy3 = (-reakcja_VBy3);

        reakcja_Hx = (Hx);

        BorderPane root = new BorderPane();
        Stage primaryStage = new Stage();

        VBox vbox1 = new VBox();

        // Button calculateButton = new Button("Policz Min/Max dla T(x)");
        SwingNode swingNode = new SwingNode();

        MomentOfForce momentOfForce1 = new MomentOfForce();
        getCombinedChartVF();
        getCombinedChartVF().getXYPlot().getRangeAxis().setInverted(true);

        swingNode.setContent(new ChartPanel(getCombinedChartVF()));

        slider = new Slider(0, 10, 0); // Przedział od 0 do 10, początkowa wartość ustawiona na 0
        slider.setBlockIncrement(0.1);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double x = newValue.doubleValue();

            double VofMzL = (x <= L) ? reakcja_VAy3 : 0; // Funkcja liniowa od momentu lewa strona

            double VofVyL = (x <= x3) ? reakcja_VAy2  : 0;
            double VofVyR = (x > x3 && x <= L) ? reakcja_VAy2 - Vy : 0;

            double VofqyL = (x <= x4) ? reakcja_VAy1 : 0;
            double VofqyR = (x > x4 && x <= x5) ? reakcja_VAy1 - qy * (x - x4) : 0;
            double VofqyEnd = (x > x5 && x <= L) ? reakcja_VAy1 - qy * (x5 - x4): 0;

            double VofMz = VofMzL +  +VofVyL + VofVyR + VofqyL + VofqyR + VofqyEnd;
            valueLabel.setText("T(x) = " + String.format("%.2f", VofMz) +  " x = " + String.format("%.2f", x)); // Formatowanie wartości Y do dwóch miejsc po przecinku

        });

        TextField xInput = new TextField();
        xInput = new TextField();
        xInput.setPromptText("Enter the value of x [m] to read the value of the shear force"); // Tekst podpowiedzi w polu tekstowym

        // Dodawanie listenera do pola tekstowego, aby odczytać wartość Y po wprowadzeniu X
        TextField finalXInput = xInput;
        xInput.setOnAction(e -> {
            try {
                double x = Double.parseDouble(finalXInput.getText());
                double VofMzL = (x <= L) ? reakcja_VAy3 : 0; // Funkcja liniowa od momentu lewa strona

                double VofVyL = (x <= x3) ? reakcja_VAy2  : 0;
                double VofVyR = (x > x3 && x <= L) ? reakcja_VAy2 - Vy : 0;

                double VofqyL = (x <= x4) ? reakcja_VAy1 : 0;
                double VofqyR = (x > x4 && x <= x5) ? reakcja_VAy1 - qy * (x - x4) : 0;
                double VofqyEnd = (x > x5 && x <= L) ? reakcja_VAy1 - qy * (x5 - x4): 0;
                double VofMz = VofMzL +  +VofVyL + VofVyR + VofqyL + VofqyR + VofqyEnd;
                valueLabel.setText("T(x) = " + String.format("%.2f", VofMz));
            } catch (NumberFormatException ex) {
                valueLabel.setText("Invalid input"); // Wyświetlenie informacji o błędnym formacie danych
            }
        });



        momentOfForce1.getminInfoLabel();
        momentOfForce1.getminXLabel();
        momentOfForce1.getmaxInfoLabel();
        momentOfForce1.getmaxXLabel();

        vbox1.getChildren().addAll(

                slider,
                // momentOfForce1.getxInput(),
                xInput,
                valueLabel,
                getCalculateButtonVF(),
                // getCalculateButton() = ChartFactory.createXYLineChart();
                //getcalculateButton,
                minInfoLabelVF,
                minXLabelVF,
                maxInfoLabelVF,
                maxXLabelVF,

                momentOfForce1.getminInfoLabel(),
                momentOfForce1.getminXLabel(),
                momentOfForce1.getmaxInfoLabel(),
                momentOfForce1.getmaxXLabel()
        );

        root.setCenter(swingNode);
        root.setBottom(vbox1);

        Scene scene = new Scene(root, 800, 600);

        // Ustawienie i wyświetlenie sceny
        primaryStage.setTitle("Shear force diagram");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //***************** StatykaToVFKoniec_1 **************
    public void switchToHorizontallOfForce() {

        Label valueLabel = new Label();
        Slider slider = new Slider();

        double L = getMofL();
        double x1 = getMofx1();
        double x2 = getMofx2();
        double x3 = getMofx3();
        double x4 = getMofx4();
        double x5 = getMofx5();

        double Mz = getMoMz();
        double Hx = getMofHx();
        double Vy = getMofVy();
        double qy = getMofqy();

        double reakcja_VAy1;
        double reakcja_VAy2;
        double reakcja_VAy3;

        double reakcja_VBy1;
        double reakcja_VBy2;
        double reakcja_VBy3;

        double reakcja_Hx;

        double Q = qy * (x5 - x4);
        double qOnL = Q / L;

        reakcja_VBy1 = qOnL * (x4 + (x5 - x4) * 0.5);
        reakcja_VBy2 = (Vy * x3) / L;
        reakcja_VBy3 = -(Mz / L);

        reakcja_VAy1 = (-reakcja_VBy1 + Q);
        reakcja_VAy2 = (-reakcja_VBy2 + Vy);
        reakcja_VAy3 = (-reakcja_VBy3);

        reakcja_Hx = (Hx);

        BorderPane root = new BorderPane();
        Stage primaryStage = new Stage();

        VBox vbox1 = new VBox();

        //   Button calculateButton = new Button("Policz Min/Max dla H(x)");
        SwingNode swingNode = new SwingNode();


        MomentOfForce momentOfForce1 = new MomentOfForce();
        getCombinedChartHF();
        getCombinedChartHF().getXYPlot().getRangeAxis().setInverted(true);

        swingNode.setContent(new ChartPanel(getCombinedChartHF()));

        slider = new Slider(0, 10, 0); // Przedział od 0 do 10, początkowa wartość ustawiona na 0
        slider.setBlockIncrement(0.1);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double x = newValue.doubleValue();

            double HForceZero = (x <= x2 ) ? 0 : 0; // Funkcja liniowa od momentu lewa strona
            double HForce = (x > x2 && x <= L) ? Hx  : 0;

            double HofAll = -HForceZero - HForce;
            valueLabel.setText("H(x) = " + String.format("%.2f", HofAll) + " x = " + String.format("%.2f", x)); // Formatowanie wartości Y do dwóch miejsc po przecinku

        });

        TextField xInput = new TextField();
        xInput = new TextField();
        xInput.setPromptText("Enter the value of x [m] to read the value of the axial force"); // Tekst podpowiedzi w polu tekstowym

        // Dodawanie listenera do pola tekstowego, aby odczytać wartość Y po wprowadzeniu X
        TextField finalXInput = xInput;
        xInput.setOnAction(e -> {
            try {
                double x = Double.parseDouble(finalXInput.getText());
                double HForceZero = (x <= x2 ) ? 0 : 0; // Funkcja liniowa od momentu lewa strona
                double HForce = (x > x2 && x <= L) ? Hx  : 0;

                double HofAll = -HForceZero - HForce;
                valueLabel.setText("H(x) = " + String.format("%.2f", HofAll));
            } catch (NumberFormatException ex) {
                valueLabel.setText("Invalid input"); // Wyświetlenie informacji o błędnym formacie danych
            }
        });

        momentOfForce1.getminInfoLabel();
        momentOfForce1.getminXLabel();
        momentOfForce1.getmaxInfoLabel();
        momentOfForce1.getmaxXLabel();

        vbox1.getChildren().addAll(
                slider,
                xInput,
                valueLabel,
                getCalculateButtonHF(),
                minInfoLabelHF,
                minXLabelHF,
                maxInfoLabelHF,
                maxXLabelHF,

                momentOfForce1.getminInfoLabel(),
                momentOfForce1.getminXLabel(),
                momentOfForce1.getmaxInfoLabel(),
                momentOfForce1.getmaxXLabel()
        );

        root.setCenter(swingNode);
        root.setBottom(vbox1);

        Scene scene = new Scene(root, 800, 600);

        // Ustawienie i wyświetlenie sceny
        primaryStage.setTitle("Axial force diagram");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //***************** StatykaToBeleczkaStart_1 **************
    public void switchToBeleczkaPanel(Stage primaryStage) {


        Beleczka beleczkaClass = new Beleczka(this);
        beleczkaLayout.getChildren().add(beleczkaClass.getBeleczkaMainVBox(primaryStage));

        Scene scene = new Scene(beleczkaLayout, 900, 650);
        primaryStage.setScene(scene);

        primaryStage.show();
        System.out.print("Is Button working ??");
    }
    //***************** StatykaToBeleczkaKoniec_1 **************

    //***************** MomentOfForceStart_1 **************
    public Button getCalculateButtonMOF() {

        calculateButtonMOF.setOnAction(e -> {

            double L = getMofL();
            double x1 = getMofx1();
            double x2 = getMofx2();
            double x3 = getMofx3();
            double x4 = getMofx4();
            double x5 = getMofx5();

            double Mz = getMoMz();
            double Hx = getMofHx();
            double Vy = getMofVy();
            double qy = getMofqy();

            double reakcja_VAy1;
            double reakcja_VAy2;
            double reakcja_VAy3;

            double reakcja_VBy1;
            double reakcja_VBy2;
            double reakcja_VBy3;

            double reakcja_Hx;


            double Q = qy * (x5 - x4);
            double qOnL = Q / L;


            reakcja_VBy1 = qOnL * (x4 + (x5 - x4) * 0.5);
            reakcja_VBy2 = (Vy * x3) / L;
            reakcja_VBy3 = -(Mz / L);

            reakcja_VAy1 = (-reakcja_VBy1 + Q);
            reakcja_VAy2 = (-reakcja_VBy2 + Vy);
            reakcja_VAy3 = (-reakcja_VBy3);

            reakcja_Hx = (Hx);


            double minX = 0;
            double maxX = 0;
            double minY = Double.MAX_VALUE;
            double maxY = Double.MIN_VALUE;

            for (double x = 0; x <= 10; x += 0.01) {

                double MofMzL = (x <= x1) ? reakcja_VAy3 * x : 0; // Funkcja liniowa od momentu lewa strona
                double MofMzR = (x > x1 && x <= L) ? reakcja_VAy3 * x - Mz : 0; // Funkcja liniowa od momentu prawa strona

                double MofVyL = (x <= x3) ? reakcja_VAy2 * x : 0;
                double MofVyR = (x > x3 && x <= L) ? reakcja_VAy2 * x - Vy * (x - x3) : 0;

                double MofqyL = (x <= x4) ? reakcja_VAy1 * x : 0;
                double MofqyR = (x > x4 && x <= x5) ? reakcja_VAy1 * x - qy * (x - x4) * (x - x4) * 0.5 : 0;
                double MofqyEnd = (x > x5 && x <= L) ? reakcja_VAy1 * x - qy * (x5 - x4) * ((x5 - x4) * 0.5 + (x - x5)) : 0;

                double MofMz = MofMzL + MofMzR + MofVyL + MofVyR + MofqyL + MofqyR + MofqyEnd;

                if (MofMz < minY) {
                    minY = MofMz;
                    minX = x;
                }

                if (MofMz > maxY) {
                    maxY = MofMz;
                    maxX = x;
                }
            }
            minInfoLabelMOF.setText("Min M(x): " + String.format("%.2f", minY));
            minXLabelMOF.setText("for x: " + String.format("%.2f", minX));
            maxInfoLabelMOF.setText("Max M(x): " + String.format("%.2f", maxY));
            maxXLabelMOF.setText("for x: " + String.format("%.2f", maxX));
        });

        return calculateButtonMOF;
    }
    //***************** MomentOfForceKoniec_1 **************

    //***************** MomentOfForceStart_2 **************
    public JFreeChart getCombinedChartMOF() {
        XYSeries momentOfForce = new XYSeries("Moment of force");

        double L = getMofL();
        double x1 = getMofx1();
        double x2 = getMofx2();
        double x3 = getMofx3();
        double x4 = getMofx4();
        double x5 = getMofx5();

        double Mz = getMoMz();
        double Hx = getMofHx();
        double Vy = getMofVy();
        double qy = getMofqy();


        double reakcja_VAy1;
        double reakcja_VAy2;
        double reakcja_VAy3;

        double reakcja_VBy1;
        double reakcja_VBy2;
        double reakcja_VBy3;

        double reakcja_Hx;


        double Q = qy * (x5 - x4);
        double qOnL = Q / L;

        reakcja_VBy1 = qOnL * (x4 + (x5 - x4) * 0.5);
        reakcja_VBy2 = (Vy * x3) / L;
        reakcja_VBy3 = -(Mz / L);

        reakcja_VAy1 = (-reakcja_VBy1 + Q);
        reakcja_VAy2 = (-reakcja_VBy2 + Vy);
        reakcja_VAy3 = (-reakcja_VBy3);

        reakcja_Hx = (Hx);
// ......................Linia prosta belki.........................
        XYSeries zeroLine = new XYSeries("beam");
        zeroLine.add(0.0, 0.0);  // Początek linii
        zeroLine.add(L, 0.0);    // Koniec linii

        // ................linia lewej podpory...............
        XYSeries LeftSupport1 = new XYSeries("");
        LeftSupport1.add(0.0, 0.0);  // Początek linii
        LeftSupport1.add(0.2*L*0.1, 1*L*0.1);
        LeftSupport1.add(-0.2*L*0.1, 1*L*0.1);

        XYSeries LeftSupport2 = new XYSeries(".");
        LeftSupport2.add(0.201*L*0.1, 1.01*L*0.1);
        LeftSupport2.add(-0.201*L*0.1, 1.01*L*0.1);

        XYSeries LeftSupport3 = new XYSeries("  ");
        LeftSupport3.add(0.201*L*0.1, 1.301*L*0.1);
        LeftSupport3.add(-0.201*L*0.1, 1.301*L*0.1);

// ................linia prawej podpory...............
        XYSeries RightSupport1 = new XYSeries("    ");
        RightSupport1.add(L, 0.0);  // Początek linii
        RightSupport1.add(L+0.2*L*0.1, 1*L*0.1);
        RightSupport1.add(L-0.2*L*0.1, 1*L*0.1);

        XYSeries RightSupport2 = new XYSeries("     ");
        RightSupport2.add(L+0.201*L*0.1, 1.01*L*0.1);
        RightSupport2.add(L-0.201*L*0.1, 1.01*L*0.1);
// ................linia tabeli...............
        XYSeries tableRight = new XYSeries("        ");
        tableRight.add(-3, -3);
        tableRight.add(-3, 3);

        XYSeries tableLeft = new XYSeries("                 ");
        tableLeft.add(L+3, -3);
        tableLeft.add(L+3, -3);

        XYSeries tableTop = new XYSeries("                    ");
        tableTop.add(-3,3);
        tableTop.add(L+3,3);

        XYSeries tableBottom = new XYSeries("                       ");
        tableBottom.add(-3, -3);
        tableBottom.add(L+3, -3);










        for (double x = 0; x <= L; x += 0.01) {
            double MofMzL = (x <= x1) ? reakcja_VAy3 * x : 0; // Funkcja liniowa od momentu lewa strona
            double MofMzR = (x > x1 && x <= L) ? reakcja_VAy3 * x - Mz : 0; // Funkcja liniowa od momentu prawa strona

            double MofVyL = (x <= x3) ? reakcja_VAy2 * x : 0;
            double MofVyR = (x > x3 && x <= L) ? reakcja_VAy2 * x - Vy * (x - x3) : 0;

            double MofqyL = (x <= x4) ? reakcja_VAy1 * x : 0;
            double MofqyR = (x > x4 && x <= x5) ? reakcja_VAy1 * x - qy * (x - x4) * (x - x4) * 0.5 : 0;
            double MofqyEnd = (x > x5 && x <= L) ? reakcja_VAy1 * x - qy * (x5 - x4) * ((x5 - x4) * 0.5 + (x - x5)) : 0;

            double MofMz = MofMzL + MofMzR + MofVyL + MofVyR + MofqyL + MofqyR + MofqyEnd;
            momentOfForce.add(x, MofMz);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();

        dataset.addSeries(momentOfForce);
        dataset.addSeries(zeroLine);dataset.addSeries(LeftSupport1);
        dataset.addSeries(LeftSupport2);
        dataset.addSeries(LeftSupport3);
        dataset.addSeries(RightSupport1);
        dataset.addSeries(RightSupport2);

        dataset.addSeries(tableRight);
        dataset.addSeries(tableLeft);
        dataset.addSeries(tableTop);
        dataset.addSeries(tableBottom);

        JFreeChart combinedChart = ChartFactory.createXYLineChart(
                "Moment diagram M(x)",
                "L [m]",
                "M(x) [kNm]",
                dataset,
                PlotOrientation.VERTICAL,

                true,
                true,
                false
        );

        XYPlot plot = combinedChart.getXYPlot();

        // Ustawianie koloru i grubości linii dla serii "belka"
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        int zeroLineIndex = dataset.indexOf(zeroLine);
        renderer.setSeriesPaint(zeroLineIndex, Color.BLUE);
        renderer.setSeriesStroke(zeroLineIndex, new BasicStroke(4.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f
        renderer.setSeriesShapesVisible(zeroLineIndex, false);

        // Ustawianie koloru i stylu linii dla serii "momentOfForce"
        int momentOfForceIndex = dataset.indexOf(momentOfForce);
        renderer.setSeriesPaint(momentOfForceIndex, Color.RED);
        renderer.setSeriesStroke(momentOfForceIndex, new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(momentOfForceIndex, false); // Wyłączenie rysowania kształtów punktów

        int Leftsupport1 = dataset.indexOf(LeftSupport1);
        renderer.setSeriesPaint(Leftsupport1, Color.BLACK);
        renderer.setSeriesStroke(Leftsupport1, new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(Leftsupport1, false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(Leftsupport1, false);

        int Leftsupport2 = dataset.indexOf(LeftSupport2);
        renderer.setSeriesPaint(Leftsupport2, Color.BLACK);
        renderer.setSeriesStroke(Leftsupport2, new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(Leftsupport2, false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(Leftsupport2, false);

        int Leftsupport3 = dataset.indexOf(LeftSupport3);
        renderer.setSeriesPaint(Leftsupport3, Color.BLACK);
        renderer.setSeriesStroke(Leftsupport3, new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(Leftsupport3, false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(Leftsupport3, false);

        int RighttSupport1 = dataset.indexOf(RightSupport1);
        renderer.setSeriesPaint(RighttSupport1, Color.BLACK);
        renderer.setSeriesStroke(RighttSupport1, new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(RighttSupport1, false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(RighttSupport1, false);

        int RighttSupport2 = dataset.indexOf(RightSupport2);
        renderer.setSeriesPaint(RighttSupport2 , Color.BLACK);
        renderer.setSeriesStroke(RighttSupport2 , new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(RighttSupport2 , false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(RighttSupport2, false);

        int tableeRight = dataset.indexOf(tableRight);
        renderer.setSeriesPaint(tableeRight, Color.WHITE);
        renderer.setSeriesStroke(tableeRight, new BasicStroke(0.10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(tableeRight, false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(tableeRight, false);

        int tableeLeft = dataset.indexOf(tableLeft);
        renderer.setSeriesPaint(tableeLeft, Color.WHITE);
        renderer.setSeriesStroke(tableeLeft, new BasicStroke(0.10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(tableeLeft, false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(tableeLeft, false);

        int tableeTop = dataset.indexOf(tableTop);
        renderer.setSeriesPaint(tableeTop, Color.WHITE);
        renderer.setSeriesStroke(tableeTop, new BasicStroke(0.10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(tableeTop, false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(tableeTop, false);

        int tableeBottom = dataset.indexOf(tableBottom);
        renderer.setSeriesPaint(tableeBottom, Color.WHITE);
        renderer.setSeriesStroke(tableeBottom, new BasicStroke(0.10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(tableeBottom, false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(tableeBottom, false);

        plot.setRenderer(renderer);
        plot.getRangeAxis().setInverted(true);

        return combinedChart;


    }
//***************** MomentOfForceKoniec_2 **************

    public Button getCalculateButtonVF() {

        calculateButtonVF.setOnAction(e -> {

            double L = getMofL();
            double x1 = getMofx1();
            double x2 = getMofx2();
            double x3 = getMofx3();
            double x4 = getMofx4();
            double x5 = getMofx5();

            double Mz = getMoMz();
            double Hx = getMofHx();
            double Vy = getMofVy();
            double qy = getMofqy();

            double reakcja_VAy1;
            double reakcja_VAy2;
            double reakcja_VAy3;

            double reakcja_VBy1;
            double reakcja_VBy2;
            double reakcja_VBy3;

            double reakcja_Hx;


            double Q = qy * (x5 - x4);
            double qOnL = Q / L;


            reakcja_VBy1 = qOnL * (x4 + (x5 - x4) * 0.5);
            reakcja_VBy2 = (Vy * x3) / L;
            reakcja_VBy3 = -(Mz / L);

            reakcja_VAy1 = (-reakcja_VBy1 + Q);
            reakcja_VAy2 = (-reakcja_VBy2 + Vy);
            reakcja_VAy3 = (-reakcja_VBy3);

            reakcja_Hx = (Hx);


            double minX = 0;
            double maxX = 0;
            double minY = Double.MAX_VALUE;
            double maxY = Double.MIN_VALUE;

            for (double x = 0; x <= 10; x += 0.01) {

                double VofMzL = (x <= L) ? reakcja_VAy3 : 0; // Funkcja liniowa od momentu lewa strona

                double VofVyL = (x <= x3) ? reakcja_VAy2  : 0;
                double VofVyR = (x > x3 && x <= L) ? reakcja_VAy2 - Vy : 0;

                double VofqyL = (x <= x4) ? reakcja_VAy1 : 0;
                double VofqyR = (x > x4 && x <= x5) ? reakcja_VAy1 - qy * (x - x4) : 0;
                double VofqyEnd = (x > x5 && x <= L) ? reakcja_VAy1 - qy * (x5 - x4): 0;

                double VofMz = VofMzL + VofVyL + VofVyR + VofqyL + VofqyR + VofqyEnd;

                if (VofMz < minY) {
                    minY = VofMz;
                    minX = x;
                }

                if (VofMz > maxY) {
                    maxY = VofMz;
                    maxX = x;
                }
            }
            minInfoLabelVF.setText("Min T(x): " + String.format("%.2f", minY));
            minXLabelVF.setText("for x: " + String.format("%.2f", minX));
            maxInfoLabelVF.setText("Max T(x): " + String.format("%.2f", maxY));
            maxXLabelVF.setText("for x: " + String.format("%.2f", maxX));
        });

        return calculateButtonVF;
    }

    public JFreeChart getCombinedChartVF() {
        XYSeries verticalOfForce = new XYSeries("Shear forces");

        double L = getMofL();
        double x1 = getMofx1();
        double x2 = getMofx2();
        double x3 = getMofx3();
        double x4 = getMofx4();
        double x5 = getMofx5();

        double Mz = getMoMz();
        double Hx = getMofHx();
        double Vy = getMofVy();
        double qy = getMofqy();


        double reakcja_VAy1;
        double reakcja_VAy2;
        double reakcja_VAy3;

        double reakcja_VBy1;
        double reakcja_VBy2;
        double reakcja_VBy3;

        double reakcja_Hx;


        double Q = qy * (x5 - x4);
        double qOnL = Q / L;

        reakcja_VBy1 = qOnL * (x4 + (x5 - x4) * 0.5);
        reakcja_VBy2 = (Vy * x3) / L;
        reakcja_VBy3 = -(Mz / L);

        reakcja_VAy1 = (-reakcja_VBy1 + Q);
        reakcja_VAy2 = (-reakcja_VBy2 + Vy);
        reakcja_VAy3 = (-reakcja_VBy3);

        reakcja_Hx = (Hx);


        reakcja_Hx = (Hx);
        reakcja_VBy1 = qOnL * (x4 + (x5 - x4) * 0.5);
        reakcja_VBy2 = (Vy * x3) / L;
        reakcja_VBy3 = -(Mz / L);

        reakcja_VAy1 = (-reakcja_VBy1 + Q);
        reakcja_VAy2 = (-reakcja_VBy2 + Vy);
        reakcja_VAy3 = (-reakcja_VBy3);


        // ......................Linia prosta belki.........................
        XYSeries zeroLineV = new XYSeries("beam ");
        zeroLineV.add(0.0, 0.0);  // Początek linii
        zeroLineV.add(L, 0.0);    // Koniec linii

        // ................linia lewej podpory...............
        XYSeries LeftVSupport1 = new XYSeries("");
        LeftVSupport1.add(0.0, 0.0);  // Początek linii
        LeftVSupport1.add(0.2*L*0.1, 0.5*L*0.1);
        LeftVSupport1.add(-0.2*L*0.1, 0.5*L*0.1);

        XYSeries LeftVSupport2 = new XYSeries(".");
        LeftVSupport2.add(0.201*L*0.1, 0.501*L*0.1);
        LeftVSupport2.add(-0.201*L*0.1, 0.501*L*0.1);

        XYSeries LeftVSupport3 = new XYSeries("  ");
        LeftVSupport3.add(0.201*L*0.1, 0.801*L*0.1);
        LeftVSupport3.add(-0.201*L*0.1, 0.801*L*0.1);

// ................linia prawej podpory...............
        XYSeries RightVSupport1 = new XYSeries(".    ");
        RightVSupport1.add(L, 0.0);  // Początek linii
        RightVSupport1.add(L+0.2*L*0.1, 0.5*L*0.1);
        RightVSupport1.add(L-0.2*L*0.1, 0.5*L*0.1);

        XYSeries RightVSupport2 = new XYSeries(".     ");
        RightVSupport2.add(L+0.201*L*0.1, 0.501*L*0.1);
        RightVSupport2.add(L-0.201*L*0.1, 0.501*L*0.1);
// ................linia tabeli...............
        XYSeries tableVRight = new XYSeries(".        ");
        tableVRight.add(-3, -3);
        tableVRight.add(-3, 3);

        XYSeries tableVLeft = new XYSeries(".                 ");
        tableVLeft.add(L+3, -3);
        tableVLeft.add(L+3, -3);

        XYSeries tableVTop = new XYSeries(".                    ");
        tableVTop.add(-3,3);
        tableVTop.add(L+3,3);

        XYSeries tableVBottom = new XYSeries(".                       ");
        tableVBottom.add(-3, -3);
        tableVBottom.add(L+3, -3);

        for (double x = 0; x <= L; x += 0.01) {
            double VofMzL = (x <= L) ? reakcja_VAy3 : 0; // Funkcja liniowa od momentu lewa strona
            // double MofMzR = (x > x1 && x <= L) ? reakcja_VAy3 * x - Mz : 0; // Funkcja liniowa od momentu prawa strona

            double VofVyL = (x <= x3) ? reakcja_VAy2  : 0;
            double VofVyR = (x > x3 && x <= L) ? reakcja_VAy2 - Vy : 0;

            double VofqyL = (x <= x4) ? reakcja_VAy1 : 0;
            double VofqyR = (x > x4 && x <= x5) ? reakcja_VAy1 - qy * (x - x4) : 0;
            double VofqyEnd = (x > x5 && x <= L) ? reakcja_VAy1 - qy * (x5 - x4): 0;

            double VofMz = VofMzL + VofVyL + VofVyR + VofqyL + VofqyR + VofqyEnd; verticalOfForce.add(x, VofMz);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();

        dataset.addSeries(verticalOfForce);
        dataset.addSeries(zeroLineV);
        dataset.addSeries(LeftVSupport1);
        dataset.addSeries(LeftVSupport2);
        dataset.addSeries(LeftVSupport3);
        dataset.addSeries(RightVSupport1);
        dataset.addSeries(RightVSupport2);

        dataset.addSeries(tableVRight);
        dataset.addSeries(tableVLeft);
        dataset.addSeries(tableVTop);
        dataset.addSeries(tableVBottom);

        JFreeChart combinedVChartV = ChartFactory.createXYLineChart(
                "Shear force diagram T(x)",
                "L [m]",
                "T(x) [kN]",
                dataset,
                PlotOrientation.VERTICAL,

                true,
                true,
                false
        );
        XYPlot plotV = combinedVChartV.getXYPlot();

        XYLineAndShapeRenderer rendererV = new XYLineAndShapeRenderer();
        int zeroLineIndex = dataset.indexOf(zeroLineV);
        rendererV.setSeriesPaint(zeroLineIndex, Color.BLUE);
        rendererV.setSeriesStroke(zeroLineIndex, new BasicStroke(4.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f
        rendererV.setSeriesShapesVisible(zeroLineIndex, false);

        // Ustawianie koloru i stylu linii dla serii "momentOfForce"
        int momentOfForceIndex = dataset.indexOf(verticalOfForce);
        rendererV.setSeriesPaint(momentOfForceIndex, Color.RED);
        rendererV.setSeriesStroke(momentOfForceIndex, new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        rendererV.setSeriesShapesVisible(momentOfForceIndex, false); // Wyłączenie rysowania kształtów punktów

        int LeftVsupport1 = dataset.indexOf(LeftVSupport1);
        rendererV.setSeriesPaint(LeftVsupport1, Color.BLACK);
        rendererV.setSeriesStroke(LeftVsupport1, new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        rendererV.setSeriesShapesVisible(LeftVsupport1, false); // Wyłączenie rysowania kształtów punktów
        rendererV.setSeriesVisibleInLegend(LeftVsupport1, false);

        int LeftVsupport2 = dataset.indexOf(LeftVSupport2);
        rendererV.setSeriesPaint(LeftVsupport2, Color.BLACK);
        rendererV.setSeriesStroke(LeftVsupport2, new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        rendererV.setSeriesShapesVisible(LeftVsupport2, false); // Wyłączenie rysowania kształtów punktów
        rendererV.setSeriesVisibleInLegend(LeftVsupport2, false);

        int LeftVsupport3 = dataset.indexOf(LeftVSupport3);
        rendererV.setSeriesPaint(LeftVsupport3, Color.BLACK);
        rendererV.setSeriesStroke(LeftVsupport3, new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        rendererV.setSeriesShapesVisible(LeftVsupport3, false); // Wyłączenie rysowania kształtów punktów
        rendererV.setSeriesVisibleInLegend(LeftVsupport3, false);

        int RighttVSupport1 = dataset.indexOf(RightVSupport1);
        rendererV.setSeriesPaint(RighttVSupport1, Color.BLACK);
        rendererV.setSeriesStroke(RighttVSupport1, new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        rendererV.setSeriesShapesVisible(RighttVSupport1, false); // Wyłączenie rysowania kształtów punktów
        rendererV.setSeriesVisibleInLegend(RighttVSupport1, false);

        int RighttVSupport2 = dataset.indexOf(RightVSupport2);
        rendererV.setSeriesPaint(RighttVSupport2, Color.BLACK);
        rendererV.setSeriesStroke(RighttVSupport2, new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        rendererV.setSeriesShapesVisible(RighttVSupport2, false); // Wyłączenie rysowania kształtów punktów
        rendererV.setSeriesVisibleInLegend(RighttVSupport2, false);

        int tableeVRight = dataset.indexOf(tableVRight);
        rendererV.setSeriesPaint(tableeVRight, Color.WHITE);
        rendererV.setSeriesStroke(tableeVRight, new BasicStroke(0.10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        rendererV.setSeriesShapesVisible(tableeVRight, false); // Wyłączenie rysowania kształtów punktów
        rendererV.setSeriesVisibleInLegend(tableeVRight, false);

        int tableeVLeft = dataset.indexOf(tableVLeft);
        rendererV.setSeriesPaint(tableeVLeft, Color.WHITE);
        rendererV.setSeriesStroke(tableeVLeft, new BasicStroke(0.10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        rendererV.setSeriesShapesVisible(tableeVLeft, false); // Wyłączenie rysowania kształtów punktów
        rendererV.setSeriesVisibleInLegend(tableeVLeft, false);

        int tableeVTop = dataset.indexOf(tableVTop);
        rendererV.setSeriesPaint(tableeVTop, Color.WHITE);
        rendererV.setSeriesStroke(tableeVTop, new BasicStroke(0.10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        rendererV.setSeriesShapesVisible(tableeVTop, false); // Wyłączenie rysowania kształtów punktów
        rendererV.setSeriesVisibleInLegend(tableeVTop, false);

        int tableeVBottom = dataset.indexOf(tableVBottom);
        rendererV.setSeriesPaint(tableeVBottom, Color.WHITE);
        rendererV.setSeriesStroke(tableeVBottom, new BasicStroke(0.10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        rendererV.setSeriesShapesVisible(tableeVBottom, false); // Wyłączenie rysowania kształtów punktów
        rendererV.setSeriesVisibleInLegend(tableeVBottom, false);

        plotV.setRenderer(rendererV);
        plotV.getRangeAxis().setInverted(true);

        combinedVChartV.getXYPlot().getRangeAxis().setInverted(true);
        return combinedVChartV;

    }

    public Button getCalculateButtonHF() {

        calculateButtonHF.setOnAction(e -> {

            double L = getMofL();
            double x1 = getMofx1();
            double x2 = getMofx2();
            double x3 = getMofx3();
            double x4 = getMofx4();
            double x5 = getMofx5();

            double Mz = getMoMz();
            double Hx = getMofHx();
            double Vy = getMofVy();
            double qy = getMofqy();

            double reakcja_VAy1;
            double reakcja_VAy2;
            double reakcja_VAy3;

            double reakcja_VBy1;
            double reakcja_VBy2;
            double reakcja_VBy3;

            double reakcja_Hx;


            double Q = qy * (x5 - x4);
            double qOnL = Q / L;


            reakcja_VBy1 = qOnL * (x4 + (x5 - x4) * 0.5);
            reakcja_VBy2 = (Vy * x3) / L;
            reakcja_VBy3 = -(Mz / L);

            reakcja_VAy1 = (-reakcja_VBy1 + Q);
            reakcja_VAy2 = (-reakcja_VBy2 + Vy);
            reakcja_VAy3 = (-reakcja_VBy3);

            reakcja_Hx = (Hx);


            double minX = 0;
            double maxX = 0;
            double minY = Double.MAX_VALUE;
            double maxY = Double.MIN_VALUE;

            for (double x = 0; x <= 10; x += 0.01) {

                double HForceZero = (x <= x2 ) ? 0 : 0; // Funkcja liniowa od momentu lewa strona
                double HForce = (x > x2 && x <= L) ? Hx  : 0;

                double HofAll = -HForceZero + -HForce;

                if (HofAll < minY) {
                    minY = HofAll;
                    minX = x;
                }

                if (HofAll > maxY) {
                    maxY = HofAll;
                    maxX = x;
                }
            }
            minInfoLabelHF.setText("Min H(x): " + String.format("%.2f", minY));
            minXLabelHF.setText("for x: " + String.format("%.2f", minX));
            maxInfoLabelHF.setText("Max H(x): " + String.format("%.2f", maxY));
            maxXLabelHF.setText("for x: " + String.format("%.2f", maxX));
        });

        return calculateButtonHF;
    }

    public JFreeChart getCombinedChartHF() {
        XYSeries horizontalOfForce = new XYSeries("Axial forces");

        double L = getMofL();
        double x1 = getMofx1();
        double x2 = getMofx2();
        double x3 = getMofx3();
        double x4 = getMofx4();
        double x5 = getMofx5();

        double Mz = getMoMz();
        double Hx = getMofHx();
        double Vy = getMofVy();
        double qy = getMofqy();


        double reakcja_VAy1;
        double reakcja_VAy2;
        double reakcja_VAy3;

        double reakcja_VBy1;
        double reakcja_VBy2;
        double reakcja_VBy3;

        double reakcja_Hx;


        double Q = qy * (x5 - x4);
        double qOnL = Q / L;

        reakcja_VBy1 = qOnL * (x4 + (x5 - x4) * 0.5);
        reakcja_VBy2 = (Vy * x3) / L;
        reakcja_VBy3 = -(Mz / L);

        reakcja_VAy1 = (-reakcja_VBy1 + Q);
        reakcja_VAy2 = (-reakcja_VBy2 + Vy);
        reakcja_VAy3 = (-reakcja_VBy3);

        reakcja_Hx = (Hx);
        XYSeries zeroLine = new XYSeries("beam");
        zeroLine.add(0.0, 0.0);  // Początek linii
        zeroLine.add(L, 0.0);    // Koniec linii

        // ................linia lewej podpory...............
        XYSeries LeftSupport1 = new XYSeries("");
        LeftSupport1.add(0.0, 0.0);  // Początek linii
        LeftSupport1.add(0.2*L*0.1, 0.5*L*0.1);
        LeftSupport1.add(-0.2*L*0.1, 0.5*L*0.1);

        XYSeries LeftSupport2 = new XYSeries(".");
        LeftSupport2.add(0.201*L*0.1, 0.501*L*0.1);
        LeftSupport2.add(-0.201*L*0.1, 0.501*L*0.1);

        XYSeries LeftSupport3 = new XYSeries("  ");
        LeftSupport3.add(0.201*L*0.1, 0.801*L*0.1);
        LeftSupport3.add(-0.201*L*0.1, 0.801*L*0.1);

// ................linia prawej podpory...............
        XYSeries RightSupport1 = new XYSeries("    ");
        RightSupport1.add(L, 0.0);  // Początek linii
        RightSupport1.add(L+0.2*L*0.1, 0.5*L*0.1);
        RightSupport1.add(L-0.2*L*0.1, 0.5*L*0.1);

        XYSeries RightSupport2 = new XYSeries("     ");
        RightSupport2.add(L+0.201*L*0.1, 0.501*L*0.1);
        RightSupport2.add(L-0.201*L*0.1, 0.501*L*0.1);
// ................linia tabeli...............
        XYSeries tableRight = new XYSeries("        ");
        tableRight.add(-3, -3);
        tableRight.add(-3, 3);

        XYSeries tableLeft = new XYSeries("                 ");
        tableLeft.add(L+3, -3);
        tableLeft.add(L+3, -3);

        XYSeries tableTop = new XYSeries("                    ");
        tableTop.add(-3,3);
        tableTop.add(L+3,3);

        XYSeries tableBottom = new XYSeries("                       ");
        tableBottom.add(-3, -3);
        tableBottom.add(L+3, -3);

        for (double x = 0; x <= L; x += 0.01) {
            double HForceZero = (x <= x2 ) ? 0 : 0; // Funkcja liniowa od momentu lewa strona
            double HForce = (x > x2 && x <= L) ? Hx  : 0;

            double HofAll = -HForceZero  -HForce; horizontalOfForce.add(x, HofAll);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(horizontalOfForce);
        dataset.addSeries(zeroLine);
        dataset.addSeries(LeftSupport1);
        dataset.addSeries(LeftSupport2);
        dataset.addSeries(LeftSupport3);
        dataset.addSeries(RightSupport1);
        dataset.addSeries(RightSupport2);

        dataset.addSeries(tableRight);
        dataset.addSeries(tableLeft);
        dataset.addSeries(tableTop);
        dataset.addSeries(tableBottom);


        JFreeChart combinedChart = ChartFactory.createXYLineChart(
                "Axial force diagram H(x)",
                "L [m]",
                "H(x) [kN]",
                dataset,
                PlotOrientation.VERTICAL,

                true,
                true,
                false
        );
        XYPlot plot = combinedChart.getXYPlot();

        // Ustawianie koloru i grubości linii dla serii "belka"
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        int zeroLineIndex = dataset.indexOf(zeroLine);
        renderer.setSeriesPaint(zeroLineIndex, Color.BLUE);
        renderer.setSeriesStroke(zeroLineIndex, new BasicStroke(4.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f
        renderer.setSeriesShapesVisible(zeroLineIndex, false);


        int momentOfForceIndex = dataset.indexOf(horizontalOfForce);
        renderer.setSeriesPaint(momentOfForceIndex, Color.RED);
        renderer.setSeriesStroke(momentOfForceIndex, new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(momentOfForceIndex, false); // Wyłączenie rysowania kształtów punktów

        int Leftsupport1 = dataset.indexOf(LeftSupport1);
        renderer.setSeriesPaint(Leftsupport1, Color.BLACK);
        renderer.setSeriesStroke(Leftsupport1, new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(Leftsupport1, false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(Leftsupport1, false);

        int Leftsupport2 = dataset.indexOf(LeftSupport2);
        renderer.setSeriesPaint(Leftsupport2, Color.BLACK);
        renderer.setSeriesStroke(Leftsupport2, new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(Leftsupport2, false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(Leftsupport2, false);

        int Leftsupport3 = dataset.indexOf(LeftSupport3);
        renderer.setSeriesPaint(Leftsupport3, Color.BLACK);
        renderer.setSeriesStroke(Leftsupport3, new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(Leftsupport3, false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(Leftsupport3, false);

        int RighttSupport1 = dataset.indexOf(RightSupport1);
        renderer.setSeriesPaint(RighttSupport1, Color.BLACK);
        renderer.setSeriesStroke(RighttSupport1, new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(RighttSupport1, false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(RighttSupport1, false);

        int RighttSupport2 = dataset.indexOf(RightSupport2);
        renderer.setSeriesPaint(RighttSupport2 , Color.BLACK);
        renderer.setSeriesStroke(RighttSupport2 , new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(RighttSupport2 , false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(RighttSupport2, false);

        int tableeRight = dataset.indexOf(tableRight);
        renderer.setSeriesPaint(tableeRight, Color.WHITE);
        renderer.setSeriesStroke(tableeRight, new BasicStroke(0.10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(tableeRight, false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(tableeRight, false);

        int tableeLeft = dataset.indexOf(tableLeft);
        renderer.setSeriesPaint(tableeLeft, Color.WHITE);
        renderer.setSeriesStroke(tableeLeft, new BasicStroke(0.10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(tableeLeft, false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(tableeLeft, false);

        int tableeTop = dataset.indexOf(tableTop);
        renderer.setSeriesPaint(tableeTop, Color.WHITE);
        renderer.setSeriesStroke(tableeTop, new BasicStroke(0.10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(tableeTop, false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(tableeTop, false);

        int tableeBottom = dataset.indexOf(tableBottom);
        renderer.setSeriesPaint(tableeBottom, Color.WHITE);
        renderer.setSeriesStroke(tableeBottom, new BasicStroke(0.10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Grubość linii: 2.0f, zaokrąglone końce i połączenia
        renderer.setSeriesShapesVisible(tableeBottom, false); // Wyłączenie rysowania kształtów punktów
        renderer.setSeriesVisibleInLegend(tableeBottom, false);

        plot.setRenderer(renderer);
        plot.getRangeAxis().setInverted(true);
        return combinedChart;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

