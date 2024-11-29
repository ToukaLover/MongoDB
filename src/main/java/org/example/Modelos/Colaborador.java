package org.example.Modelos;

import org.bson.Document;

public class Colaborador {

    private String nombre;
    private String rol;

    @Override
    public String toString() {
        return "Colaborador{" +
                "nombre='" + nombre + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }

    public Colaborador(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public Document toDocument(){
        return new Document("nombre",nombre)
                .append("rol",rol);
    }

    public static Colaborador fromDocument(Document document){
        return new Colaborador(
                document.getString("nombre"),
                document.getString("rol")
        );
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
