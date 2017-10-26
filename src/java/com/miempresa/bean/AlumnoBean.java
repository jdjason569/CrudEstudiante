/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.bean;

import com.miempresa.logic.LogicaAlumno;
import com.miempresa.model.Alumno;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author jason
 */
@ManagedBean(name = "alumnoBean")
@ViewScoped
public class AlumnoBean {

    private Alumno alumno;
    private ArrayList<Alumno> listaAlumnos;
    private Alumno alumnoSeleccionado;
    private Alumno alumnoEditado;
    private final LogicaAlumno logicaAlumno;
    private String mostrarBotones;
    

    /**
     * Creates a new instance of AlumnoBean
     *
     * @throws java.sql.SQLException
     */
    public AlumnoBean() throws SQLException {
        alumno = new Alumno();
        alumnoSeleccionado = new Alumno();
        alumnoEditado = new Alumno();
        logicaAlumno = new LogicaAlumno();
        listaAlumnos = new ArrayList<>();
        mostrarBotones = "true";
        cargarAlumnos();
    }

    public Alumno getAlumnoEditado() {
        return alumnoEditado;
    }

    public void setAlumnoEditado(Alumno alumnoEditado) {
        this.alumnoEditado = alumnoEditado;
    }

    public String getMostrarBotones() {
        return mostrarBotones;
    }

    public void setMostrarBotones(String mostrarBotones) {
        this.mostrarBotones = mostrarBotones;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public Alumno getAlumnoSeleccionado() {
        return alumnoSeleccionado;
    }

    public void setAlumnoSeleccionado(Alumno alumnoSeleccionado) {
        this.alumnoSeleccionado = alumnoSeleccionado;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void cargarAlumnos() throws SQLException {
        listaAlumnos.clear();
        listaAlumnos.addAll(logicaAlumno.cargarAlumnos());
    }

    public void onRowSelect() {
        if (alumnoEditado != null) {
            mostrarBotones = "false";
        }
    }

    public void crearAlumno() throws SQLException {
        logicaAlumno.crearAlumno(alumno);
        cargarAlumnos();
    }

    public void editarAlumno() throws SQLException {
        logicaAlumno.editarAlumno(alumnoSeleccionado);
        cargarAlumnos();
        mostrarBotones = "true";
    }

    public void eliminarAlumno() throws SQLException {
        logicaAlumno.eliminarAlumno(alumnoEditado);
        cargarAlumnos();
        mostrarBotones = "true";
    }

}
