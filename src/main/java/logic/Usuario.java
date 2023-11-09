package logic;

public class Usuario {
    private String nombre;
    private String usuario;
    private String contra;

    public Usuario (String nom, String us, String con){
        setUsuario(us);
        setContra(con);
        setNombre(nom);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContra() {
        return contra;
    }

    public String getUsuario() {
        return usuario;
    }
}
