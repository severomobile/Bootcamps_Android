package Clases;

/**
 * La clase Usuario representa a un usuario,
 * extendiendo la funcionalidad de una EntidadBilletera con información personal del usuario.
 */
public class Usuario extends EntidadBilletera {

    private String nombre;
    private String email;
    private String contrasena;

    /**
     * Construye un nuevo Usuario con información personal.
     *
     * @param nombre El nombre completo del usuario.
     * @param email La dirección de correo electrónico del usuario.
     * @param contrasena La contraseña del usuario.
     */
    public Usuario(String nombre, String email, String contrasena) {
        super(); // Llama al constructor de EntidadBilletera, que genera un ID único
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
    }

    /**
     * Devuelve el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el correo electrónico del usuario.
     *
     * @return El email del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email El nuevo correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la nueva contraseña del usuario.
     *
     * @param contrasena La nueva contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}