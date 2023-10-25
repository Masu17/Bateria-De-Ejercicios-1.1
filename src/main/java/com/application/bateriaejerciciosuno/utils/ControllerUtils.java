package com.application.bateriaejerciciosuno.utils;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class ControllerUtils {

    public static HashMap<String, String> saveDataToMap(List<Control> controls) {

        HashMap<String, String> controlsMap = new HashMap<>();

        controls.forEach(control -> {
            if (control instanceof TextField) {
                controlsMap.put(control.getId().substring(0, control.getId().indexOf("TextField")), ((TextField) control).getText());
            } else if (control instanceof ChoiceBox<?>) {
                controlsMap.put(control.getId().substring(0, control.getId().indexOf("Container")), ((ChoiceBox<?>) control).getValue().toString());

            }

        });

        return controlsMap;
    }

}