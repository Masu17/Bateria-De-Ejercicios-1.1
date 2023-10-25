package com.application.bateriaejerciciosuno.services;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class CheckService {

    static AtomicReference<String> returnedString = new AtomicReference<>("");

    public static String checkRevista(HashMap<String, String> args, String type) {
        returnedString.set("");

        args.forEach((key, value) -> {
            if (value.isEmpty()) {
                returnedString.set(returnedString + "\n [i] El campo: " + key + ", no puede estar vacío");
            }
        });

        if (type.equals("Revista") && returnedString.toString().isEmpty()) {
            checkRevista(args);
        } else if (type.equals("Boletin") && returnedString.toString().isEmpty()) {
            checkBoletin(args);
        }

        return returnedString.toString();
    }

    private static void checkBoletin(HashMap<String, String> args) {
        String actualIt = "Fecha";
        try {
            if (args.get("Fecha").matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
                String[] fecha = args.get("Fecha").split("/");
                if (Integer.parseInt(fecha[0]) > 31 || Integer.parseInt(fecha[1]) > 12) {
                    returnedString.set(returnedString + "\n [i] El campo: fecha, no puede ser mayor que 31 o 12");
                }
            } else {
                returnedString.set(returnedString + "\n [i] El campo: fecha, debe tener el formato dd/mm/yyyy");
            }
            checkGenerics(args);
        } catch (NumberFormatException e) {
            returnedString.set(returnedString + "\n [i] El campo:" + actualIt + ", debe ser un número");
        }
    }

    private static void checkRevista(HashMap<String, String> args) {
        String actualIt = "Email";
        try {
            if (!(args.get("Email").contains("@") && args.get("Email").contains("."))) {
                returnedString.set(returnedString + "\n [i] El campo: email, debe contener un @ y un .");
            }
            checkGenerics(args);
        } catch (NumberFormatException e) {
            returnedString.set(returnedString + "\n [i] El campo:" + actualIt + ", debe ser un número");
        }
    }

    private static void checkGenerics(HashMap<String, String> args) {
        String actualIt = "Precio";
        try {
            actualIt = "Precio";
            if (args.get("Precio").contains(",")) {
                returnedString.set(returnedString + "\n [i] El campo: precio, no puede contener comas");
            } else {
                Double.parseDouble(args.get("Precio"));
            }
            actualIt = "NumPaginas";
            if (Integer.parseInt(args.get("NumPaginas").toString()) < 0) {
                returnedString.set(returnedString + "\n [i] El campo: numPaginas, no puede ser menor que 0");
            }
        } catch (NumberFormatException e) {
            returnedString.set(returnedString + "\n [i] El campo:" + actualIt + ", debe ser un número");
        }
    }


}
