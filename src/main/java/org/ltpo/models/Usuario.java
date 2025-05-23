package org.ltpo.models;

import jakarta.persistence.*;
import org.ltpo.enuns.Tipo;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private Tipo tipo;

    @OneToMany(mappedBy = "usuario",
    cascade = CascadeType.ALL)
    private List<Automovel> automoveis;


    public Usuario () {}

    public Usuario (String nome, String telefone, Tipo tipo, List<Automovel> automoveis){
        this.nome = nome;
        this.telefone = telefone;
        this.tipo = tipo;
        this.automoveis = automoveis;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(List<Automovel> automoveis) {
        this.automoveis = automoveis;
    }

    @Override
    public String toString() {
        return "Usuario{ id= " + id +
                ", nome= '" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", tipo=" + tipo +
                ", automoveis=" + automoveis +
                '}';
    }
}
