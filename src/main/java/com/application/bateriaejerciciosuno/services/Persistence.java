package com.application.bateriaejerciciosuno.services;

import com.application.bateriaejerciciosuno.models.ArticulosPublicados;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Persistence {

    @Getter
    private static List<ArticulosPublicados> persistenceList = new ArrayList<>();

    public static void add(ArticulosPublicados articulo) {
        persistenceList.add(articulo);
    }

    public static ArticulosPublicados get(int index) {
        return persistenceList.get(index);
    }


}
