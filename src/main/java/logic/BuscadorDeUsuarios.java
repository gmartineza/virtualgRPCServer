package logic;

import java.util.ArrayList;
import java.util.function.Predicate;

public class BuscadorDeUsuarios {
    private ArrayList<Usuario> dondeBuscar;

    public BuscadorDeUsuarios(ListaUsuarios lista) {
        dondeBuscar = lista.getLista();
    }

    public int existe(String us, String pass) {
        Predicate<Usuario> usIgual = usuario -> usuario.getUsuario().equals(us); //lambda de usuario
        Predicate<Usuario> contraIgual = usuario -> usuario.getContra().equals(pass); //lambda de contra

        // filtro de usuario igual
        boolean userExists = dondeBuscar.stream().anyMatch(usIgual);
        // filtro de contraseña igual
        boolean passwordExists = dondeBuscar.stream().anyMatch(contraIgual);

        if (userExists) {
            if (passwordExists) {
                // Existe us y pass
                return 2;
            } else {
                // Exste us pero la contra es incorrecta
                return 1;
            }
        } else {
            // No existe el us
            return 0;
        }
    }
}