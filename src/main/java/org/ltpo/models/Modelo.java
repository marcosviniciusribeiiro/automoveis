package org.ltpo.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "modelo")
public  class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String marca;

    @OneToMany(mappedBy = "automovel",
    cascade = CascadeType.ALL)
    private List<Automovel> automoveis;

    public Modelo() {

    }

    public Modelo(String nome,String marca){
        this.marca = marca;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(List automoveis) {
        this.automoveis = automoveis;
    }


    @Override
    public String toString() {
        return "Modelo{id= " + id +
                ", nome= '" + nome +
                "', marca= '"
                + marca +
                "'}";
    }
}