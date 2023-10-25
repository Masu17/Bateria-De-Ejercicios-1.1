package com.application.bateriaejerciciosuno.utils;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.*;
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

    public static void createJOptionPane(String message, String title, int type){

        JOptionPane panelError = new JOptionPane(message, type);

        JDialog dialog = panelError.createDialog(null, title);
        dialog.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
            }
            @Override
            public void windowLostFocus(WindowEvent e) {
                dialog.dispose();
            }
        });
        dialog.setVisible(true);
    }

}