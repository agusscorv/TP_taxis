package negocio;

import java.io.Serializable;
import java.util.List;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
    private String user;
    private String contrasena;
    private String nombre;


    public ClienteDTO() {
    	super();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
