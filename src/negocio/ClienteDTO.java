package dto;

import java.util.List;

public class ClienteDTO {
    
    private String user;
    private String contrasena;
    private String nombre;


    public ClienteDTO() {}


    public ClienteDTO(String user, String contrasena, String nombre) {
        this.user = user;
        this.contrasena = contrasena;
        this.nombre = nombre;
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
