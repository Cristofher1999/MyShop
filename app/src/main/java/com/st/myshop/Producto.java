package com.st.myshop;

public class Producto {

    private String ID;
    private String Nombre;
    private String Tipo;
    private String Precio;

    public Producto(){}
    public Producto(String id, String nombre, String tipo, String precio) {
        this.ID = id;
        this.Nombre = nombre;
        this.Tipo = tipo;
        this.Precio = precio;
    }

    public String getID() {
        return ID;
    }

    public void setRun(String id) {
        ID = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        this.Precio = precio;
    }


}
