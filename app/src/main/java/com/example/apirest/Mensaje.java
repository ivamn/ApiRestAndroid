package com.example.apirest;

public class Mensaje {
    private String nick;
    private String mensaje;
    private String _id;


    public String getNick() {
        return nick;
    }

    public void setNick(String value) {
        this.nick = value;
    }


    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String value) {
        this.mensaje = value;
    }


    public String getID() {
        return _id;
    }

    public void setID(String value) {
        this._id = value;
    }
}
