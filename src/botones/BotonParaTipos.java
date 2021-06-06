package botones;

import verduras.Tipos;

import javax.swing.*;
import java.io.Serializable;
import java.util.Objects;

public class BotonParaTipos implements Serializable {
    /**
     * Atributos de la clase que contiene para los tipos.
     * Mostrará el tipo de verdura.
     */
    private final Tipos tipo;
    private final JButton boton;

    /**
     * Constructor de tipos
     * @param tipo
     */
    public BotonParaTipos(Tipos tipo) {
        this.tipo = tipo;
        this.boton = new JButton(tipo.getTiposDescripcion());
    }

    public Tipos getTipo() {
        return tipo;
    }

    public JButton getBoton() {
        return boton;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BotonParaTipos that = (BotonParaTipos) o;
        return tipo == that.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }

}
