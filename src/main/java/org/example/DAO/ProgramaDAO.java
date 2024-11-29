package org.example.DAO;

import org.example.Modelos.Programa;

import java.util.List;

public interface ProgramaDAO {

    void insertar(Programa programa);
    Programa buscarPorID(int id);
    List<Programa> buscarTodos();
    void actualizar(Programa programa);
    List<Programa> buscarPorCategoría(String categoria);
    Programa programaConMayorAudiencia(String fecha);
    double calcularAudienciaMedia(String id,String fechaInicio,String fechaFin);

}
