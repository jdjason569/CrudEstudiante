/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.model;

/**
 *
 * @author jason
 * clase Alumno con sus metodos set y get
 */
public class Alumno {

    private int cod_alumno;
    private String nombre_alumno;
    private String apellido_alumno;
    private String identificacion_alumno;
    private String genero_alumno;
    private int edad_alumno;
    

    public Alumno() {
    }

    public int getCod_alumno() {
        return cod_alumno;
    }

    public void setCod_alumno(int cod_alumno) {
        this.cod_alumno = cod_alumno;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getApellido_alumno() {
        return apellido_alumno;
    }

    public void setApellido_alumno(String apellido_alumno) {
        this.apellido_alumno = apellido_alumno;
    }

    public String getIdentificacion_alumno() {
        return identificacion_alumno;
    }

    public void setIdentificacion_alumno(String identificacion_alumno) {
        this.identificacion_alumno = identificacion_alumno;
    }

    public String getGenero_alumno() {
        return genero_alumno;
    }

    public void setGenero_alumno(String genero_alumno) {
        this.genero_alumno = genero_alumno;
    }

    public int getEdad_alumno() {
        return edad_alumno;
    }

    public void setEdad_alumno(int edad_alumno) {
        this.edad_alumno = edad_alumno;
    }

}
