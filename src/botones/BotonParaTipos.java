package botones;

import verduras.Tipos;

import javax.swing.*;
import java.util.Objects;

public class BotonParaTipos {
    /**
     * Atributos de la clase que contiene para los tipos.
     * Mostrará el tipo de verdura.
     */
    Tipos tipo;
    JButton boton;

    /**
     * Constructor de tipos
     * @param tipo
     */
    public BotonParaTipos(Tipos tipo) {
        this.tipo = tipo;
        this.boton = new JButton(tipo.getTiposDescripcion());
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
