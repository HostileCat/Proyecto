package model;

/**
 * Clase que representa un usuario en el sistema.
 */
public class Usuario {
    private int id;
    private String nombreUsuario;
    private String correoElectronico;
    private String contrasena;
    private int rol;
    private int estado;
    private String nombreRol;

    /**
     * Obtiene el ID del usuario.
     * @return El ID del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     * @param id El ID del usuario.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de usuario.
     * @return El nombre de usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre de usuario.
     * @param nombreUsuario El nombre de usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return El correo electrónico del usuario.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param correoElectronico El correo electrónico del usuario.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return La contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     * @param contrasena La contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el rol del usuario.
     * @return El ID del rol del usuario.
     */
    public int getRol() {
        return rol;
    }

    /**
     * Establece el rol del usuario.
     * @param rol El ID del rol del usuario.
     */
    public void setRol(int rol) {
        this.rol = rol;
    }

    /**
     * Obtiene el estado del usuario.
     * @return El estado del usuario.
     */
    public int getEstado() {
        return estado;
    }

    /**
     * Establece el estado del usuario.
     * @param estado El estado del usuario.
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el nombre del rol del usuario.
     * @return El nombre del rol del usuario.
     */
    public String getNombreRol() {
        return nombreRol;
    }

    /**
     * Establece el nombre del rol del usuario.
     * @param nombreRol El nombre del rol del usuario.
     */
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}

