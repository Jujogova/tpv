package paneles;

import botones.BotonParaVerduras;
import verduras.Verdura;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class PanelVerduras implements Serializable {
    private PanelTiquet panelTiquet;
    private final JPanel panelVerdura;
        public PanelVerduras(PanelTiquet panelTiquet) {
            this.panelVerdura = new JPanel(new FlowLayout(FlowLayout.CENTER));
            this.panelTiquet = panelTiquet;
        }

        public JPanel getPanelVerdura() {
            return panelVerdura;
        }

        public void anyadeVerdura(Verdura verdura) {
            BotonParaVerduras bpv = new BotonParaVerduras(verdura);
            bpv.getBoton().setPreferredSize(new Dimension(150,150));
            bpv.getBoton().addActionListener(e -> {panelTiquet.pulsado(verdura);
                    }
            );
            panelVerdura.add(bpv.getBoton());
        }

        public void actualizaListaDeBotones(Set<Verdura> listaVerduricas) {
            panelVerdura.removeAll();
            for (Verdura verdura : listaVerduricas) {
                anyadeVerdura(verdura);
            }
            panelVerdura.revalidate();
            panelVerdura.repaint();
        }
    }

