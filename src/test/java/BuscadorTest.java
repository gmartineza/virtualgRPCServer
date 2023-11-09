import logic.BuscadorDeUsuarios;
import logic.ListaUsuarios;
import org.junit.Test;
import static org.junit.Assert.*;

public class BuscadorTest {
    @Test
    public void testBuscador(){
        ListaUsuarios lista = new ListaUsuarios();
        lista.anadirUsuario("Pedro", "pedro", "pedro");
        lista.anadirUsuario("Juan", "juan", "juan123");
        lista.anadirUsuario("Mario", "mario", "marito");
        BuscadorDeUsuarios buscador = new BuscadorDeUsuarios(lista);

        assertEquals("pedro", lista.getLista().get(0).getContra());
        assertEquals("pedro", lista.getLista().get(0).getUsuario());
        assertEquals("Pedro", lista.getLista().get(0).getNombre());

        assertEquals(buscador.existe("xdas", "pedro"), 0);
        assertEquals(buscador.existe("pedro", "daaaa"), 1);
        assertEquals(buscador.existe("pedro", "pedro"), 2);


    }

}
