package org.example.models;

public class CredencialesInicioSesion {
    private String usuario;
    private String clave;

    // Constructor sin argumentos requerido por Cucumber para transformación de DataTable
    public CredencialesInicioSesion() {}

    // Constructor con parámetros para instanciar las credenciales de forma programática
    public CredencialesInicioSesion(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getUsuario(){
        return usuario;
    }
    public String getClave(){
        return clave;
    }
}
