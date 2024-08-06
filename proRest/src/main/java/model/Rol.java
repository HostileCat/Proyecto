package model;

/**
 * Clase que representa un rol de usuario.
 */
public class Rol {
    private int idRol;
    private String nombreRol;

    /**
     * Obtiene el ID del rol.
     * @return El ID del rol.
     */
    public int getIdRol() {
        return idRol;
    }

    /**
     * Establece el ID del rol.
     * @param idRol El nuevo ID del rol.
     */
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    /**
     * Obtiene el nombre del rol.
     * @return El nombre del rol.
     */
    public String getNombreRol() {
        return nombreRol;
    }

    /**
     * Establece el nombre del rol.
     * @param nombreRol El nuevo nombre del rol.
     */
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
