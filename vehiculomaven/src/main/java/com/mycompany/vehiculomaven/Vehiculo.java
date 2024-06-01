/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vehiculomaven;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

/**
 *
 * @author nuria
 */
@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //esto nos genera valores automaticos para  id
    private int id;
    private String tipo;
    private String marca;
    private int potencia;
    
    @Column(name = "fechaCompra")
    private String fechaCompra;

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public int getPotencia() {
        return potencia;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }
    
}
