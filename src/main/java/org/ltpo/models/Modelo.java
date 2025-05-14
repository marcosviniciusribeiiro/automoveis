package org.ltpo.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String marca;

    @OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL)
    private List<Automovel> automoveis;

    public Modelo() {}

    public Modelo(String nome, String marca) {
        this.nome = nome;
        this.marca = marca;
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

    public List<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(List<Automovel> automoveis) {
        this.automoveis = automoveis;
    }

    //Metodo auxiliar para manter consistência bidirecional
    public void addAutomovel(Automovel automovel) {
        this.automoveis.add(automovel);
        automovel.setModelo(this);
    }

    @Override
    public String toString() {
        return "Modelo{id= " + id +
                ", nome= '" + nome + '\'' +
                ", marca= '" + marca + '\'' +
                '}';
    }
}