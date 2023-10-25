package com.application.bateriaejerciciosuno.view;

import com.application.bateriaejerciciosuno.AppMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;

public class RevistaFormView {
    @Getter
    private static final Stage revistaFormStage = new Stage();

    public static void runRevistaFormView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("revistaFormView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            revistaFormStage.setTitle("Gestion de revistas y boletines");
            revistaFormStage.setScene(scene);
            revistaFormStage.show();
        } catch (IOException e) {
            System.out.println("[Error] No se pudo cargar la vista de revistaFormView");
        }
    }

}
