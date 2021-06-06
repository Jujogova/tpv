package paneles;

import botones.BotonParaTipos;
import botones.BotonParaVerduras;
import verduras.Tipos;
import verduras.Verdura;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.*;

public class PanelParaTipos implements Serializable {
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
        generaBotonesPanel();
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
    public void anyadeVerduraEnUnaListaConSuTipo(Verdura verdura) {
        listaTiposDeVerduras.get(verdura.getTipo()).add(verdura);
        listaTiposDeVerduras.get(Tipos.VERDULERIA).add(verdura);

    }
    private void generaBotonesPanel() {
        for (Map.Entry<Tipos, Set<Verdura>> mao : listaTiposDeVerduras.entrySet()){
            botonParaTipos.add(new BotonParaTipos(mao.getKey()));
        }
        for (BotonParaTipos bpt : botonParaTipos) {
            panel.add(bpt.getBoton());
            bpt.getBoton().addActionListener(e -> panelVerduras.actualizaListaDeBotones(listaTiposDeVerduras.get(bpt.getTipo())));
        }
        }
    }

