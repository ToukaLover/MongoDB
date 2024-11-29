package org.example.Modelos;

import org.bson.Document;

import javax.print.Doc;
import java.time.LocalTime;
import java.util.Locale;

public class Horario {

    private String dia;
    private LocalTime hora;

    public Document toDocument(){
        return new Document("dia",dia)
                .append("hora",hora);
    }

    @Override
    public String toString() {
        return "Horario{" +
                "dia='" + dia + '\'' +
                ", hora=" + hora +
                '}';
    }

    public static Horario fromDocument(Document document){

        return new Horario(
                document.getString("dia"),
                (LocalTime) document.get("hora")
        );

    }

    public Horario(String dia, LocalTime hora) {
        this.dia = dia;
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
