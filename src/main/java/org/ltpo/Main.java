package org.ltpo;

import org.ltpo.DAO.AutomovelDAO;
import org.ltpo.DAO.ModeloDAO;
import org.ltpo.DAO.UsuarioDAO;
import org.ltpo.enuns.Tipo;
import org.ltpo.models.Automovel;
import org.ltpo.models.Modelo;
import org.ltpo.models.Usuario;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        ModeloDAO modeloDAO = new ModeloDAO();
        AutomovelDAO automovelDAO = new AutomovelDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        //inserir novo Modelo, Automovel, Usuario
        Modelo modelo = new Modelo("HB20","Hyundai");
        Automovel hb20 = new Automovel("AWC6930", 2012, "Prata", modelo);

        Usuario cliente = new Usuario("João", "94316-5091", Tipo.CLIENTE, Arrays.asList(hb20) );

        modeloDAO.salvar(modelo);
        automovelDAO.salvar((hb20));
        usuarioDAO.salvar(cliente);

        System.out.println("Modelo inserido: " + modelo);
        System.out.println("Automovel inserido: " + hb20);
        System.out.println("Usuario inserido: " + cliente);

        //Buscar todos os Modelos, Automoveis e Usuarios
        List<Modelo> modelos = modeloDAO.buscarTodos();
        System.out.println("\nTodos os Modelos:");
        for(Modelo m :modelos){
            System.out.println(m);
        }

        List<Automovel> automoveis = automovelDAO.buscarTodos();
        System.out.println("\nTodos os Automoveis:");
        for(Automovel a : automoveis){
            System.out.println(a);
          }

        List<Usuario> usuarios = usuarioDAO.buscarTodos();
        System.out.println("\nTodos os Usuarios:");
        for(Usuario u : usuarios){
            System.out.println(u);
        }


        //Buscar um Modelo, Automovel e Usuario pelo ID
        Modelo modeloBuscado = modeloDAO.buscarPorId(1);
        System.out.println("\nModelos com o ID 1: " + modeloBuscado);

        Automovel automovelBuscado = automovelDAO.buscarPorId(1);
        System.out.println("\nAutomovel com o ID 1: " + automovelBuscado);

        Usuario usuarioBuscado = usuarioDAO.buscarPorId(1);
        System.out.println("\nUsuario com o ID 1: " + usuarioBuscado);

        //Fechar o EntityManger
        modeloDAO.fechar();
        automovelDAO.fechar();
        usuarioDAO.fechar();

    }
}