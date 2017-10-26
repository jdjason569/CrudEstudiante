/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.db;

import com.miempresa.model.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jason
 */
public class AlumnoAD {

    Connection conexcion;

    public String insertar(Alumno alumno) throws SQLException {
        String respuesta = "no";
        PreparedStatement prepararSentencia = null;
        Conector conectar = new Conector();
        conectar.conectar();
        this.conexcion = conectar.getConexion();
        try {
            String sql = "insert into tabl_alumno(nombre_alumno,apellido_alumno,identificacion_alumno,genero_alumno,edad_alumno) "
                    + "values (?, ?, ?, ?, ?);";

            prepararSentencia = this.conexcion.prepareStatement(sql);
            prepararSentencia.setString(1, alumno.getNombre_alumno());
            prepararSentencia.setString(2, alumno.getApellido_alumno());
            prepararSentencia.setString(3, alumno.getIdentificacion_alumno());
            prepararSentencia.setString(4, alumno.getGenero_alumno());
            prepararSentencia.setInt(5, alumno.getEdad_alumno());
            prepararSentencia.executeUpdate();
            respuesta = "OK";
            conexcion.close();
            prepararSentencia.close();
        } catch (SQLException ex) {
            conexcion.close();
            prepararSentencia.close();
            System.out.println("error insertandola informacion " + ex);
        }
        return respuesta;
    }

    public void actualizar(Alumno alumno) throws SQLException {

        PreparedStatement prepararSentencia = null;
        Conector conectar = new Conector();
        conectar.conectar();
        this.conexcion = conectar.getConexion();
        try {
            String sql = "UPDATE tabl_alumno "
                    + "	SET nombre_alumno=?, apellido_alumno=?, "
                    + "identificacion_alumno=?, genero_alumno=?, edad_alumno=? "
                    + "	WHERE cod_alumno = ?";

            prepararSentencia = this.conexcion.prepareStatement(sql);
            prepararSentencia.setString(1, alumno.getNombre_alumno());
            prepararSentencia.setString(2, alumno.getApellido_alumno());
            prepararSentencia.setString(3, alumno.getIdentificacion_alumno());
            prepararSentencia.setString(4, alumno.getGenero_alumno());
            prepararSentencia.setInt(5, alumno.getEdad_alumno());
            prepararSentencia.setInt(6, alumno.getCod_alumno());
            prepararSentencia.executeUpdate();
            conexcion.close();
            prepararSentencia.close();
        } catch (SQLException ex) {
            conexcion.close();
            prepararSentencia.close();
            System.out.println("error actualizacndo la informacion " + ex);
        }

    }

    public void eliminar(Integer codigo) throws SQLException {
        PreparedStatement prepararSentencia = null;
        Conector conectar = new Conector();
        conectar.conectar();
        this.conexcion = conectar.getConexion();
        
        try {

            String borrar = "delete from tabl_alumno where cod_alumno = ?";
            prepararSentencia = this.conexcion.prepareStatement(borrar);
            prepararSentencia.setInt(1, codigo);
            prepararSentencia.executeUpdate();
            conexcion.close();
            prepararSentencia.close();
        } catch (SQLException ex) {
            conexcion.close();
            prepararSentencia.close();
            System.out.println("error eliminando la informacion " + ex);
        }

    }

    public ArrayList<Alumno> listar() throws SQLException {
        ArrayList alumnos = new ArrayList();
        java.sql.Statement st = null;
        try {
            // PreparedStatement prepararSentencia =null;
            Conector conectar = new Conector();
            conectar.conectar();

            this.conexcion = conectar.getConexion();
            st = conexcion.createStatement();

            String sql = "SELECT  * FROM tabl_alumno";

            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                Alumno alumno = new Alumno();
                alumno.setCod_alumno(result.getInt("cod_alumno"));
                alumno.setNombre_alumno(result.getString("nombre_alumno"));
                alumno.setApellido_alumno(result.getString("apellido_alumno"));
                alumno.setIdentificacion_alumno(result.getString("identificacion_alumno"));
                alumno.setGenero_alumno(result.getString("genero_alumno"));
                alumno.setEdad_alumno(result.getInt("edad_alumno"));
                alumnos.add(alumno);
            }
            st.close();
            conexcion.close();
        } catch (SQLException e) {
            st.close();
            conexcion.close();
            System.out.println("No se puede obtener los alumnos " + e);
        }
        return alumnos;
    }

}
