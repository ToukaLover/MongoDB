package org.example.Modelos;

import com.mongodb.event.ClusterListenerAdapter;
import org.bson.Document;

import javax.print.Doc;
import javax.sound.sampled.AudioFileFormat;
import java.util.List;

public class Programa {

    private int id;
    private String nombre;
    private String categoria;
    private Horario horario;
    private List<Audiencia> audiencia;
    private List<Colaborador> colaboradores;

    public Programa(int id, String nombre, String categoria, Horario horario, List<Audiencia> audiencia, List<Colaborador> colaboradores) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.horario = horario;
        this.audiencia = audiencia;
        this.colaboradores = colaboradores;
    }

    public Document toDocument(){
        return new Document("id",id)
                .append("nombre",nombre)
                .append("categoria",categoria)
                .append("horario",horario.toDocument())
                .append("audiencia",convertirAudiencia())
                .append("colaboradores",convertirColaboradores());

    }

    public List<Document> convertirAudiencia(){
        return audiencia.stream().map(Audiencia::toDocument).toList();
    }

    public List<Document> convertirColaboradores(){
        return colaboradores.stream().map(Colaborador::toDocument).toList();
    }

    public static Programa fromDocument(Document document){

        List<Colaborador> colaboradores2 = ((List<Document>) document.get("colaboradores")).stream().map(Colaborador::fromDocument).toList();

        List<Audiencia> audiencia2 = ((List<Document>) document.get("audiencia")).stream().map(Audiencia::fromDoucment).toList();

        Document document1 = (Document) document.get("horario");

        Horario horario1 = Horario.fromDocument(document1);

        return new Programa(
                document.getInteger("id"),
                document.getString("nombre"),
                document.getString("categoria"),
                horario1,
                audiencia2,
                colaboradores2
        );
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public Horario getHorario() {
        return horario;
    }

    public List<Audiencia> getAudiencia() {
        return audiencia;
    }

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public void setAudiencia(List<Audiencia> audiencia) {
        this.audiencia = audiencia;
    }

    public void setColaboradores(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    @Override
    public String toString() {
        return "Programa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", horario=" + horario +
                ", audiencia=" + audiencia +
                ", colaboradores=" + colaboradores +
                '}';
    }
}
