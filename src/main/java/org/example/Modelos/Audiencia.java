package org.example.Modelos;

import org.bson.Document;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.ZoneId;

public class Audiencia {

    private LocalDate fecha;

    private int espectadores;

    public Audiencia(LocalDate fecha, int espectadores) {
        this.fecha = fecha;
        this.espectadores = espectadores;
    }

    @Override
    public String toString() {
        return "Audiencia{" +
                "fecha=" + fecha +
                ", espectadores=" + espectadores +
                '}';
    }

    public Document toDocument(){
        return new Document("fecha",fecha)
                .append("espectadores",espectadores);
    }

    public static Audiencia fromDoucment(Document document){
        return new Audiencia(
                document.getDate("fecha").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                document.getInteger("espectadores")
        );
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getEspectadores() {
        return espectadores;
    }

    public void setEspectadores(int espectadores) {
        this.espectadores = espectadores;
    }
}




