package com.application.bateriaejerciciosuno.view;

import com.application.bateriaejerciciosuno.AppMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;

public class ShowRevistaView {

    @Getter
    private static final Stage showStateStage = new Stage();

    public static void runRevistaFormView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("showRevista.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            showStateStage.setTitle("Gestion de revistas y boletines");
            showStateStage.setScene(scene);
            showStateStage.show();
        } catch (IOException e) {
            System.out.println("[Error] No se pudo cargar la vista de revistaFormView");
        }
    }

}
