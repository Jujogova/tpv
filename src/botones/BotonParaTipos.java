package botones;

import verduras.Tipos;

import javax.swing.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Clase para que aparezcan los botones de los tipos
 */
public class BotonParaTipos implements Serializable {
    /**
     * Atributos de la clase que contiene para los tipos.
     * Mostrará el tipo de verdura.
     */
    private final Tipos tipo;
    private final JButton boton;

    /**
     * Constructor de los botones para tipos
     * @param tipo
     */
    public BotonParaTipos(Tipos tipo) {
        this.tipo = tipo;
        this.boton = new JButton(tipo.getTiposDescripcion());
    }

    /**
     * Obtiene  el tipo
     * @return tipo
     */
    public Tipos getTipo() {
        return tipo;
    }

    /**
     * Obtiene el boton
     * @return boton
     */
    public JButton getBoton() {
        return boton;
    }

    /**
     Compara objetos
     * @param o
     * @return si es igual  el tipo
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BotonParaTipos that = (BotonParaTipos) o;
        return tipo == that.tipo;
    }
    /**
     * Genera el hash
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }

}
