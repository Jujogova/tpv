package paneles;

import botones.BotonParaTipos;
import botones.BotonParaVerduras;
import verduras.Tipos;
import verduras.Verdura;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.*;

/**
 * Panel para los tipos de verduras.
 */
public class PanelParaTipos implements Serializable {
    private final PanelVerduras panelVerduras;
    private final JPanel panel;
    private final Set<BotonParaTipos> botonParaTipos;
    private final Map<Tipos, Set<Verdura>> listaTiposDeVerduras;

    /**
     * Constructor de la clase
     * @param panelVerduras
     */
    public PanelParaTipos(PanelVerduras panelVerduras) {
        this.listaTiposDeVerduras = new HashMap<>();
        this.panel = new JPanel(new GridLayout(0, 1));
        this.panelVerduras = panelVerduras;
        this.botonParaTipos = new HashSet<>();
        generaMapaDeTipos();
        generaBotonesPanel();
    }

    /**
     * Obtiene el panel
     * @return panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Obtiene la lista de verduras
     * @return listaTiposDeVerduras
     */
    public Map<Tipos, Set<Verdura>> getListaTiposDeVerduras() {
        return listaTiposDeVerduras;
    }

    /**
     * Genera los mapas de tipos
     */
    private void generaMapaDeTipos() {
        for (Tipos tipo : Tipos.values()) {
            listaTiposDeVerduras.put(tipo, new HashSet<>());
        }
    }

    /**
     * Coge las verduras y las añade en su respectivo tipo
     * @param verdura
     */
    public void anyadeVerduraEnUnaListaConSuTipo(Verdura verdura) {
        listaTiposDeVerduras.get(verdura.getTipo()).add(verdura);
        listaTiposDeVerduras.get(Tipos.VERDULERIA).add(verdura);
    }

    /**
     * Genera los botones del panel con cada tipo
     */
    private void generaBotonesPanel() {
        for (Map.Entry<Tipos, Set<Verdura>> mao : listaTiposDeVerduras.entrySet()){
            botonParaTipos.add(new BotonParaTipos(mao.getKey()));
        }
        for (BotonParaTipos bpt : botonParaTipos) {
            panel.add(bpt.getBoton());
            bpt.getBoton().addActionListener(e -> panelVerduras.actualizaListaDeBotones(listaTiposDeVerduras.get(bpt.getTipo())));
        }
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PanelParaTipos that = (PanelParaTipos) o;
        return Objects.equals(listaTiposDeVerduras, that.listaTiposDeVerduras) && Objects.equals(botonParaTipos, that.botonParaTipos) && Objects.equals(panelVerduras, that.panelVerduras) && Objects.equals(panel, that.panel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaTiposDeVerduras, botonParaTipos, panelVerduras, panel);
    }

}

