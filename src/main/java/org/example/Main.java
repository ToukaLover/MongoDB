package org.example;

import org.example.ClasesDAO.ProgramaDAO;
import org.example.Modelos.Audiencia;
import org.example.Modelos.Colaborador;
import org.example.Modelos.Horario;
import org.example.Modelos.Programa;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Horario horario1 = new Horario("Lunes", LocalTime.of(12, 20));

        Audiencia audiencia1 = new Audiencia(LocalDate.of(2024, 12, 12), 200);

        List<Audiencia> audiencias = new ArrayList<>();

        audiencias.add(audiencia1);

        Colaborador colaborador1 = new Colaborador("Antonio","Estudiantes");

        List<Colaborador> colaboradores = new ArrayList<>();

        colaboradores.add(colaborador1);

        Programa programa1 = new Programa(1, "yqs","yqs", horario1,audiencias,colaboradores );

        ProgramaDAO programaDAO = new ProgramaDAO();

//        programaDAO.insertar(programa1);

        Programa programa = programaDAO.buscarPorID(1);

        System.out.println(programa.toString());



    }
}
