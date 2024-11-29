package org.example.ClasesDAO;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.Conexion.Conexion;
import org.example.Modelos.Programa;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class ProgramaDAO implements org.example.DAO.ProgramaDAO {

    private MongoCollection<Document> collection;

    public ProgramaDAO() {
        this.collection = Conexion.getMongoDatabase().getCollection("Programas");
    }

    @Override
    public void insertar(Programa programa) {
        collection.insertOne(programa.toDocument());
    }

    @Override
    public Programa buscarPorID(int id) {

        Programa programa1 = null;

        Document query = new Document("id",id);

        for ( Document doc : collection.find(query)){
           programa1 = Programa.fromDocument(doc);
        }

        return programa1;
    }

    @Override
    public List<Programa> buscarTodos() {
        List<Programa> lista = new ArrayList<>();

        for (Document document : collection.find()){
            Programa programa = Programa.fromDocument(document);
            lista.add(programa);
        }

        return lista;
    }

    @Override
    public void actualizar(Programa programa) {

    }

    @Override
    public List<Programa> buscarPorCategoría(String categoria) {
        return List.of();
    }

    @Override
    public Programa programaConMayorAudiencia(String fecha) {
        return null;
    }

    @Override
    public double calcularAudienciaMedia(String id, String fechaInicio, String fechaFin) {
        return 0;
    }
}
