package paneles;

import botones.BotonParaVerduras;
import verduras.Verdura;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 * Clase que crea panel de Verduras
 */
public class PanelVerduras implements Serializable {
    private PanelTiquet panelTiquet;
    private final JPanel panelVerdura;

    /**
     * Constructor del panel
     * @param panelTiquet
     */
        public PanelVerduras(PanelTiquet panelTiquet) {
            this.panelVerdura = new JPanel(new GridLayout(8,2));
            this.panelTiquet = panelTiquet;
        }

    /**
     * Obtiene el panel Verdura
     * @return panelVerdura
     */
        public JPanel getPanelVerdura() {
            return panelVerdura;
        }

    /**
     * Cuando clickas añade la verdura al recibo
     * @param verdura
     */
        public void anyadeVerdura(Verdura verdura) {
            BotonParaVerduras bpv = new BotonParaVerduras(panelTiquet, verdura);
            bpv.getBoton().setPreferredSize(new Dimension(150,150));
            bpv.getBoton().addActionListener(e -> {
                panelTiquet.pulsado(verdura);
                    }
            );
            panelVerdura.add(bpv.getBoton());
        }

    /**
     *  Actualiza los botones del panel de las verduras.
     *  Borra los anteriores y añade nuevos.
     * @param listaVerduricas
     */
        public void actualizaListaDeBotones(Set<Verdura> listaVerduricas) {
            panelVerdura.removeAll();
            for (Verdura verdura : listaVerduricas) {
                anyadeVerdura(verdura);
            }
            panelVerdura.revalidate();
            panelVerdura.repaint();
        }
    }

