/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.logic;

import com.miempresa.db.AlumnoAD;
import com.miempresa.model.Alumno;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author jason
 */
public class LogicaAlumno {

    private AlumnoAD alumnoAD;

    public LogicaAlumno() {
        this.alumnoAD = new AlumnoAD();
    }
    

    public ArrayList<Alumno> cargarAlumnos() throws SQLException {
        ArrayList alumnos = new ArrayList();
        alumnos.addAll(alumnoAD.listar());
        return alumnos;
        
        
    }
    
    public String crearAlumno(Alumno alumno) throws SQLException{
        alumnoAD.insertar(alumno);
        return "ok";
    }
    
    public String editarAlumno(Alumno alumno) throws SQLException{
        alumnoAD.actualizar(alumno);
        return "OK";
    }
    
    public String eliminarAlumno(Alumno alumno) throws SQLException{
        alumnoAD.eliminar(alumno.getCod_alumno());
        return "ok";
    }

}
