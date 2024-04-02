package Clases;

/**
 * La clase EntidadBilletera es una clase abstracta y
 * Proporciona un identificador único.
 */
public abstract class EntidadBilletera {
    private String id;

    /**
     * Constructor de la clase EntidadBilletera que genera un identificador único para la entidad.
     */
    public EntidadBilletera() {
        this.id = generarIdUnico();
    }

    /**
     * Obtiene el identificador único de la entidad.
     *
     * @return El identificador único de la entidad.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único de la entidad.
     *
     * @param id El identificador único a establecer.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Genera un identificador único utilizando el algoritmo UUID.
     *
     * @return El identificador único generado.
     */
    public static String generarIdUnico() {
        return java.util.UUID.randomUUID().toString();
    }
}

