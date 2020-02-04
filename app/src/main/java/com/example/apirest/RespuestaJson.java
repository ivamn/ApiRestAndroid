package com.example.apirest;

import java.io.Serializable;

public class RespuestaJson implements Serializable {
    private int respuesta;
    private String metodo;
    private String tabla;
    private String mensaje;
    private String sqlQuery;
    private String sqlError;

    public RespuestaJson(int respuesta, String metodo, String tabla, String mensaje, String sqlQuery, String sqlError) {
        this.respuesta = respuesta;
        this.metodo = metodo;
        this.tabla = tabla;
        this.mensaje = mensaje;
        this.sqlQuery = sqlQuery;
    }

    public RespuestaJson() {
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getSqlQuery() {
        return sqlQuery;
    }

    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public String getSqlError() {
        return sqlError;
    }

    public void setSqlError(String sqlError) {
        this.sqlError = sqlError;
    }
}
