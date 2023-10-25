package com.application.bateriaejerciciosuno.utils;

import java.util.ArrayList;

public class checkRevista {

    public static String checkTitulo(String titulo) {
        if (titulo.length() < 3) {
            return "El titulo debe tener al menos 3 caracteres";
        } else {
            return "";
        }
    }

}
