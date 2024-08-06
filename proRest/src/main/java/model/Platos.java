package model;

/**
 * Clase que representa un plato.
 */
public class Platos {
    private int id;
    private String nombrePlato;
    private String descripcionPlato;
    private int precioPlato;
    private String imagenPlato;
    private int idCategoria;
    private String nombreCategoria;
    private boolean estado;

   
    /**
     * Obtiene el estado del plato.
     * @return El estado del plato (true si está habilitado, false si está inhabilitado).
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Establece el estado del plato.
     * @param estado El nuevo estado del plato (true para habilitado, false para inhabilitado).
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el ID del plato.
     * @return El ID del plato.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del plato.
     * @param id El nuevo ID del plato.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del plato.
     * @return El nombre del plato.
     */
    public String getNombrePlato() {
        return nombrePlato;
    }

    /**
     * Establece el nombre del plato.
     * @param nombrePlato El nuevo nombre del plato.
     */
    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    /**
     * Obtiene el ID de la categoría a la que pertenece el plato.
     * @return El ID de la categoría del plato.
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * Establece el ID de la categoría del plato.
     * @param idCategoria El nuevo ID de la categoría del plato.
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * Obtiene la descripción del plato.
     * @return La descripción del plato.
     */
    public String getDescripcionPlato() {
        return descripcionPlato;
    }

    /**
     * Establece la descripción del plato.
     * @param descripcionPlato La nueva descripción del plato.
     */
    public void setDescripcionPlato(String descripcionPlato) {
        this.descripcionPlato = descripcionPlato;
    }

    /**
     * Obtiene el precio del plato.
     * @return El precio del plato.
     */
    public int getPrecioPlato() {
        return precioPlato;
    }

    /**
     * Establece el precio del plato.
     * @param precioPlato El nuevo precio del plato.
     */
    public void setPrecioPlato(int precioPlato) {
        this.precioPlato = precioPlato;
    }

    /**
     * Obtiene el nombre de la imagen del plato.
     * @return El nombre de la imagen del plato.
     */
    public String getImagenPlato() {
        return imagenPlato;
    }

    /**
     * Establece el nombre de la imagen del plato.
     * @param imagenPlato El nombre URL de la imagen del plato.
     */
    public void setImagenPlato(String imagenPlato) {
        this.imagenPlato = imagenPlato;
    }

    /**
     * Obtiene el nombre de la categoría del plato.
     * @return El nombre de la categoría del plato.
     */
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    /**
     * Establece el nombre de la categoría del plato.
     * @param nombreCategoria El nuevo nombre de la categoría del plato.
     */
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
}