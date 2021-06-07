package verduras;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que indica los datos que debe contener una verdura.
 */
public class Verdura implements Serializable {
    private String nombre;
    private int precio;
    private Tipos tipo;

    /**
     * Constructor de una verdura
     * @param nombre
     * @param precio
     * @param tipo
     */
    public Verdura(String nombre, int precio, Tipos tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    /**
     * Obtiene el nombre de la hortaliza
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene cuanto cuesta
     * @return precio
     */
    public Integer getPrecio() {
        return precio;
    }

    /**
     * Calcula el precio con un int, pero lo pasa a céntimos y euros.
     * @return precio con euros y céntimos
     */
    public String getPrecioEnCentimosYEuros() {
    int euros = precio / 100;
    int centimos = precio % 100;
        return euros +","+centimos;
}

    /**
     * Compara objetos
     * @param o
     * @return si es igual a otro objeto u diferente
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Verdura verdura = (Verdura) o;
        return precio == verdura.precio &&
                Objects.equals(nombre, verdura.nombre) &&
                tipo == verdura.tipo;
    }

    /**
     * Nos devuelve información completa
     * @return nombre con precio.
     */
    public String getInfo() {
        return nombre + " - " + getPrecioEnCentimosYEuros();
    }
    /**
     * Genera un hash
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio, tipo);
    }

    /**
     * Devuelve el tipo de hortaliza
     * @return tipo
     */
    public Tipos getTipo() {
        return tipo;
    }

    /**
     * Te muestra la hortaliza en cuestión
     * @return
     */
    public ImageIcon getFoto() {
        return obtieneFoto();
    }

    /**
     * Coge el nombre de la foto
     * @return foto
     */
    private String getNombreCorrectamenteFoto() {

        return nombre.replaceAll("-", "") + ".jpg";
    }

    /**
     * Devuelve la imagen una vez la encuentra en su carpeta.
     * @return la imagen
     */
    private ImageIcon obtieneFoto() {
        File rutaImagenJuego = new File("Ftos" + File.separator + getNombreCorrectamenteFoto());
        ImageIcon foto = new ImageIcon(rutaImagenJuego.getPath());

        boolean fotoEncontrada = foto.getIconHeight() > -1;
        if (fotoEncontrada) {
            foto = cambiaTamanyoFoto(foto);
        } else {
            foto = new ImageIcon("Fotos" + File.separator + "verduragenerica.png");
        }
        return foto;
    }

    /**
     * Modifica el tamaño de la foto
     * @param foto
     * @return iamgen modificada
     */
    private ImageIcon cambiaTamanyoFoto(ImageIcon foto) {
        Image img = foto.getImage();
        Image imagenTamanyoModif = img.getScaledInstance(50, 50, Image.SCALE_REPLICATE);
        return new ImageIcon(imagenTamanyoModif);
    }

}
