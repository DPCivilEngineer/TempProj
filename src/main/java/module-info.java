module com.example.beleczka {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;

    requires org.jfree.jfreechart;
    requires javafx.swing;

    opens com.example.beleczka to javafx.fxml;//
    exports com.example.beleczka;//


    opens com.example.MomentOfForce to javafx.graphics;//
    exports com.example.beleczka.statka;//
    //exports com.example.beleczka;
    exports com.example.MomentOfForce;

    //exports com.example.beleczka;
    opens com.example.beleczka.statka to javafx.fxml;
  //  exports com.example.beleczka;
}