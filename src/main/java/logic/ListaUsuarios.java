package logic;

import java.util.ArrayList;

public class ListaUsuarios {
    ArrayList<Usuario> listaDeUsuarios = new ArrayList<>(); //este array contiene todos los usuarios q voy creando

    public void anadirUsuario(String nom, String us, String con){ //creo y añado el usuario a la lista
        Usuario usuario = new Usuario(nom, us, con);
        listaDeUsuarios.add(usuario);
    }

    public ArrayList<Usuario> getLista(){
        return listaDeUsuarios;
    } //return de la lista

}
