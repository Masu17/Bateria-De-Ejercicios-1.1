module com.application.bateriaejerciciosuno {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.desktop;


    opens com.application.bateriaejerciciosuno to javafx.fxml;
    exports com.application.bateriaejerciciosuno;

    exports com.application.bateriaejerciciosuno.controllers;
    opens com.application.bateriaejerciciosuno.controllers to javafx.fxml;

}