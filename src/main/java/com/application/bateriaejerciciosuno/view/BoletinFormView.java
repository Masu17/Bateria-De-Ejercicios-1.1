package com.application.bateriaejerciciosuno.view;

import com.application.bateriaejerciciosuno.AppMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;

public class BoletinFormView {
    @Getter
    private static final Stage boletinFormStage = new Stage();

    public static void runBoletinFormView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("boletinFormView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            boletinFormStage.setTitle("Gestion de revistas y boletines");
            boletinFormStage.setScene(scene);
            boletinFormStage.show();
        } catch (IOException e) {
            System.out.println("[Error] No se pudo cargar la vista de revistaFormView");
        }
    }
}
