package botones;

import verduras.Tipos;
import verduras.Verdura;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.Serializable;
import java.util.Objects;

public class BotonParaVerduras implements Serializable {
    private final JButton boton;
    private final Verdura verdura;

    public BotonParaVerduras(Verdura verdura) {
        this.verdura = verdura;
        this.boton = new JButton(verdura.getFoto());
    }

    public JButton getBoton() {
        return boton;
    }

    public Verdura getVerdura() {
        return verdura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BotonParaVerduras that = (BotonParaVerduras) o;
        return verdura.equals(that.verdura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(verdura);
    }
}
