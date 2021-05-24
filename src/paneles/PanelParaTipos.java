package paneles;

import botones.BotonParaTipos;
import botones.BotonParaVerduras;
import verduras.Tipos;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PanelParaTipos {
    JPanel panel;
    Map<BotonParaTipos, List<BotonParaVerduras>> listadoVerduleria;

    public PanelParaTipos() {
        this.panel = new JPanel();
    }

    private void crearPanel(){
        for (Tipos tipo: Tipos.values()) {
            listadoVerduleria.put(new BotonParaTipos(tipo), new ArrayList<>());
        }
    }
}
