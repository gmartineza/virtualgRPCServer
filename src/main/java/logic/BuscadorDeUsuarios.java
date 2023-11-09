package logic;

import java.util.ArrayList;
import java.util.function.Predicate;


public class BuscadorDeUsuarios {
    ArrayList<Usuario> dondeBuscar;
    public BuscadorDeUsuarios(ListaUsuarios lista){
        dondeBuscar = lista.getLista();
    }

    public boolean existe(String us, String pass){
        System.out.println("buscando");
        Predicate<Usuario> usIgual = usuario -> usuario.getUsuario().equals(us);
        Predicate<Usuario> contraIgual = usuario -> usuario.getContra().equals(pass);
        boolean user = dondeBuscar.stream()
                .anyMatch(usIgual.and(contraIgual));
        return user;
    }
}
