import logic.BuscadorDeUsuarios;
import logic.ListaUsuarios;
import logic.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioTest {
    @Test
    public void testUsuario(){
        ListaUsuarios lista = new ListaUsuarios();
        lista.anadirUsuario("Pedro", "pedro", "pedro");
        BuscadorDeUsuarios buscador = new BuscadorDeUsuarios(lista);

        assertEquals("pedro", lista.getLista().get(0).getContra());
        assertEquals("pedro", lista.getLista().get(0).getUsuario());
        assertEquals("Pedro", lista.getLista().get(0).getNombre());

        assertTrue(buscador.existe("pedro", "pedro"));
    }
}
