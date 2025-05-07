package org.ltpo;

import org.ltpo.DAO.ModeloDAO;
import org.ltpo.models.Modelo;

import java.util.List;

public class Main {
    public static void main(String[] args){
        ModeloDAO modeloDAO = new ModeloDAO();

        //inserir novo modelo
        Modelo modelo = new Modelo("HB20","Hyundai");
        modeloDAO.salvar(modelo);
        System.out.println("Modelo inserido: "+modelo);

        //Buscar todos os modelos
        List<Modelo>modelos = modeloDAO.buscarTodos();
        System.out.println("\nTodos os Modelos:");
        for(Modelo m :modelos){
            System.out.println(m);
        }//Buscar um modelo por ID
        Modelo modeloBuscado = modeloDAO.buscarPorId(1);
        System.out.println("\nModelos com ID 1: " + modeloBuscado);

        //Fechar o EntityManger
        modeloDAO.fechar();

    }
}