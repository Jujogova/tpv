package paneles;

import verduras.Verdura;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PanelTiquet {
    private final Map<Verdura, Integer> procesoDeTicket;
    private final JPanel panelTiquet;
    private final JTextArea datosDelTiquet;
    private final JButton botonTiquet;

    public PanelTiquet(){
        this.procesoDeTicket = new HashMap<>();
        this.panelTiquet=new JPanel( new GridLayout(1,5));
        this.datosDelTiquet=new JTextArea(20,20);
        this.datosDelTiquet.setEditable(true);
        this.botonTiquet=new JButton();
        panelTiquet.add(datosDelTiquet);
        panelTiquet.add(botonTiquet);
    }

    public JPanel getPanelTiquet() {
        return panelTiquet;
    }

    public JTextArea getDatosDelTiquet() {
        return datosDelTiquet;
    }

    public JButton getBotonTiquet() {
        return botonTiquet;
    }
    public void aniadirInformacion(Verdura verdura) {
        procesoDeTicket.put(verdura, verdura.getPrecio());
    }
}

