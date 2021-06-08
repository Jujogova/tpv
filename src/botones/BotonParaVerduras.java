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

/**
 * Clase para los botones de vrduras
 */
public class BotonParaVerduras implements Serializable {
    private final JButton boton;
    private final Verdura verdura;

    /**
     * Constructor
     * @param panelTiquet
     * @param verdura
     */
    public BotonParaVerduras(PanelTiquet panelTiquet, Verdura verdura) {
        this.verdura = verdura;
        this.boton = new JButton(verdura.getFoto());
        this.boton.setIcon(verdura.getFoto());
        this.boton.addActionListener(e -> {
            Log.log(Level.INFO, verdura.getNombre() + " añadida al carrito.");

            panelTiquet.generaPanelDelTiquet();
        });
    }

    /**
     * Retorna el boton de verduras
     * @return boton
     */
    public JButton getBoton() {
        return boton;
    }

    /**
     * Retorna la verdura
     * @return verdura
     */
    public Verdura getVerdura() {
        return verdura;
    }

    /**
     Compara objetos
     * @param o
     * @return si es igual  la verdura
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BotonParaVerduras that = (BotonParaVerduras) o;
        return verdura.equals(that.verdura);
    }
    /**
     * Genera un hash
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(verdura);
    }
}
