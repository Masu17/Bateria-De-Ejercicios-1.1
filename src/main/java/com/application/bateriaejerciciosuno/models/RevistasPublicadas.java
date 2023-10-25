package com.application.bateriaejerciciosuno.models;

import lombok.Getter;

public class RevistasPublicadas extends ArticulosPublicados{

    @Getter
    public String titulo;
    @Getter
    public String formato;
    @Getter
    public String correo;
    @Getter
    public String nombreAutor;
    @Getter
    public String editorial;

    public RevistasPublicadas(String titulo, String formato, String correo, String nombreAutor, String editorial, int NumeroDePaginas, double Precio) {
        this.titulo = titulo;
        this.formato = formato;
        this.correo = correo;
        this.nombreAutor = nombreAutor;
        this.editorial = editorial;
        this.NumeroDePaginas = NumeroDePaginas;
        this.Precio = Precio;
    }

    public RevistasPublicadas() {
    }

}
