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
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Criar e salvar o modelo
        Modelo modelo = new Modelo("Corola", "Toyota");
        modeloDAO.salvar(modelo);

        // Criar o automóvel
        Automovel automovel = new Automovel("SVY2091", 2019, "Preto", modelo);

        // Criar o usuário e associar o automóvel
        Usuario cliente = new Usuario("João", "94316-5091", Tipo.CLIENTE, Arrays.asList(automovel));
        automovel.setUsuario(cliente);

        // Salvar o usuário (o automóvel será salvo automaticamente por Cascade.ALL)
        usuarioDAO.salvar(cliente);

        System.out.println("Modelo inserido: " + modelo);
        System.out.println("Automovel inserido: " + automovel);
        System.out.println("Usuario inserido: " + cliente);

        // Buscar todos os registros
        List<Modelo> modelos = modeloDAO.buscarTodos();
        System.out.println("\nTodos os Modelos:");
        for(Modelo m : modelos){
            System.out.println(m);
        }

        AutomovelDAO automovelDAO = new AutomovelDAO();
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

        // Buscar por ID
        Modelo modeloBuscado = modeloDAO.buscarPorId(1);
        System.out.println("\nModelos com o ID 1: " + modeloBuscado);

        Automovel automovelBuscado = automovelDAO.buscarPorId(1);
        System.out.println("\nAutomovel com o ID 1: " + automovelBuscado);

        Usuario usuarioBuscado = usuarioDAO.buscarPorId(1);
        System.out.println("\nUsuario com o ID 1: " + usuarioBuscado);

        // Fechar conexões
        modeloDAO.fechar();
        automovelDAO.fechar();
        usuarioDAO.fechar();
    }
}
