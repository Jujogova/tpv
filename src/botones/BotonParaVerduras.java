package botones;

import paneles.PanelTiquet;
import verduras.Log;
import verduras.Tipos;
import verduras.Verdura;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Level;

public class BotonParaVerduras implements Serializable {
    private final JButton boton;
    private final Verdura verdura;

    public BotonParaVerduras(PanelTiquet panelTiquet, Verdura verdura) {
        this.verdura = verdura;
        this.boton = new JButton(verdura.getFoto());
        this.boton.addActionListener(e -> {
            Log.log(Level.INFO, verdura.getNombre() + " añadida al carrito.");
        });
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
