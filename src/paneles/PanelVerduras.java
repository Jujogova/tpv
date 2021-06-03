package paneles;

import botones.BotonParaVerduras;
import verduras.Verdura;

import javax.swing.*;
import java.awt.*;
import java.util.Set;
import java.util.TreeSet;

public class PanelVerduras {
    private Set<BotonParaVerduras> listaVerduricas;
    private final JPanel panelVerdura;

    public PanelVerduras(PanelTiquet panelTiquet) {
        this.listaVerduricas = new TreeSet<>();
        this.panelVerdura = new JPanel(new GridLayout(0,5));
    }
    public JPanel getPanelVerdura(){
        return panelVerdura;
    }

    public String getListaVerduricas(){
        String salida = " ";
        for (BotonParaVerduras botonVerdura : listaVerduricas ) {
            salida += botonVerdura.getVerdura().getNombre() + "\n";
        }
        return salida;
        }
        public void anyadeVerdura(Verdura verdura) {
        listaVerduricas.add(new BotonParaVerduras(verdura));
        panelVerdura.add(new BotonParaVerduras(verdura).getBoton());
    }
    public void actualizaListaDeBotones(){
        for (BotonParaVerduras botonParaVerduras : listaVerduricas) {
            panelVerdura.add(botonParaVerduras.getBoton());
        }
    }

}

