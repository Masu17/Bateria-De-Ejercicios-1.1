package com.application.bateriaejerciciosuno.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CheckService {

    static AtomicReference<String> returnedString = new AtomicReference<>("");

    public static String checkRevista(HashMap<String, String> args, String type) {

        args.forEach((key, value) -> {
            if (value.isEmpty()) {
                returnedString.set(returnedString + "\n [i] El campo: " + key + ", no puede estar vacío");
            }
        });

        if (type.equals("Revista") && returnedString.toString().isEmpty()){
            checkRevista(args);
        }

        return returnedString.toString();
    }

    private static void checkRevista(HashMap<String,String> args){
        try {
            if (!(args.get("Email").contains("@") && args.get("email").contains("."))) {
                returnedString.set(returnedString + "\n [i] El campo: email, debe contener un @ y un .");
            }
            if (args.get("Precio").contains(",")) {
                returnedString.set(returnedString + "\n [i] El campo: precio, no puede contener comas");
            }
            if (Integer.parseInt(args.get("NumPaginas").toString()) < 0) {
                returnedString.set(returnedString + "\n [i] El campo: numPaginas, no puede ser menor que 0");
            }
        }catch (InputMismatchException e){
            returnedString.set(returnedString + "\n [i] El campo: numPaginas, debe ser un número");
        }
    }


}
