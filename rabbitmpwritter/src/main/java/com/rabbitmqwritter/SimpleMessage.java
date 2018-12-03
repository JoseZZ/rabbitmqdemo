package com.rabbitmqwritter;

import java.io.Serializable;

/**
 * Created by Jose Gonzalez on 23/11/2018.
 */
public class SimpleMessage implements Serializable{

    private String autor;
    private String mensaje;

    public SimpleMessage() {
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
