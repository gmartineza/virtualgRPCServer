package logic;

import java.util.ArrayList;

public class CreacionDeUsuarios {
    ListaUsuarios lista = new ListaUsuarios();

    public CreacionDeUsuarios(){
        lista.anadirUsuario("root", "root", "root");
        lista.anadirUsuario("admin", "admin", "admin");
        lista.anadirUsuario("Gabriel", "gabi", "gabicapo");
        lista.anadirUsuario("Felix", "felix", "felix123");
    }

    public ListaUsuarios getListaUsuarios(){
        return lista;
    }
}
