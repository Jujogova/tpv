package paneles;

import botones.BotonParaTipos;
import botones.BotonParaVerduras;
import verduras.Tipos;
import verduras.Verdura;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PanelParaTipos {
    private final PanelVerduras panelVerduras;
    private final JPanel panel;
    private final Set<BotonParaTipos> botonParaTipos;
    private final Map<Tipos, Set<Verdura>> listaTiposDeVerduras;

    public PanelParaTipos(PanelVerduras panelVerduras) {
        this.listaTiposDeVerduras = new HashMap<>();
        this.panel = new JPanel(new GridLayout(0, 1));
        this.panelVerduras = panelVerduras;
        this.botonParaTipos = new HashSet<>();
        generaMapaDeTipos();
      
    }

    public JPanel getPanel() {
        return panel;
    }

    public Map<Tipos, Set<Verdura>> getListaTiposDeVerduras() {
        return listaTiposDeVerduras;
    }

    private void generaMapaDeTipos() {
        for (Tipos tipo : Tipos.values()) {
            listaTiposDeVerduras.put(tipo, new HashSet<>());
        }
    }


}
