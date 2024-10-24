package com.microservicios.demo.modelos;

public class Auto {

    public String modelo;
    public int userId;
    
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public Auto(String modelo, int userId) {
        this.modelo = modelo;
        this.userId = userId;
    }

    public Auto() {
    }

    
}
