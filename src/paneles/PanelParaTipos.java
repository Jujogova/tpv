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
    private final Map<Tipos, Set<BotonParaTipos>> listaTiposDeVerduras;

    public PanelParaTipos(PanelVerduras panelVerduras) {
    this.listaTiposDeVerduras = new HashMap<>();
    this.panel = new JPanel(new GridLayout(0,1));
    this. panelVerduras = panelVerduras;
    this.botonParaTipos = new HashSet<>();
    generaMapaDeTipos();
    anyadeVerduraEnUnaListaConSuTipo();
    }
     public JPanel getPanel() {
        return panel;
    }
    public Map<Tipos, Set<BotonParaTipos>> getListaTiposDeVerduras(){
        return listaTiposDeVerduras;
    }

    private void generaMapaDeTipos(){
        for (Tipos tipo : Tipos.values()){
            listaTiposDeVerduras.put(tipo, new HashSet<>());
        }
    }
    public void anyadeVerduraEnUnaListaConSuTipo(Verdura verdura) {
        listaTiposDeVerduras.get(verdura.getTipo()).add(new BotonParaVerduras(verdura));

    }
}
