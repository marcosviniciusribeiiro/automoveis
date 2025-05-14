package org.ltpo.models;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "automovel")
public class Automovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String placa;

    private int ano;

    private String cor;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

    public Automovel(String placa, int ano, String cor) {
        this.id = id;
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    @Override
    public String toString (){
        return "Automovel{ id= " + id +
                ", modelo= '" + modelo +
                "', placa= '" + placa +
                "', ano= " + ano +
                ", cor= '" + cor +
                "'}";
    }
}