package com.application.bateriaejerciciosuno.models;

public class BoletinPublicado extends ArticulosPublicados{

    private String nombre;
    private String fecha;

    public BoletinPublicado(String nombre, String fecha, int NumeroDePaginas, double Precio) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.NumeroDePaginas = NumeroDePaginas;
        this.Precio = Precio;
    }

    public BoletinPublicado() {
    }

}
