package logic;

import java.util.ArrayList;

public class ListaUsuarios {
    ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();

    public void anadirUsuario(String nom, String us, String con){
        Usuario usuario = new Usuario(nom, us, con);
        listaDeUsuarios.add(usuario);
    }

    public ArrayList<Usuario> getLista(){
        return listaDeUsuarios;
    }

}
