package logic;

public class Usuario {
    //el usuario va a tener un nombre, un ususario y una contraseña.
    private String nombre;
    private String usuario;
    private String contra;

    public Usuario (String nom, String us, String con){
        setUsuario(us);
        setContra(con);
        setNombre(nom);
    }


    //getters y setters de encapsulación
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
