package paneles;

import verduras.Recibo;
import verduras.Verdura;

import javax.swing.*;
import java.awt.*;

public class PanelTiquet {
    private final JPanel panelRecibo;
    private final JPanel panelVerduras;
    private final JPanel panelDelTiquet;
    private JLabel totalDelTiquet;
    private final Recibo recibo;

    public PanelTiquet(Recibo recibo){
        this.panelRecibo = new JPanel(new GridLayout(2,1));
        this.panelVerduras = new JPanel(new GridLayout(0, 2));
        this.panelDelTiquet = new JPanel();
        this.recibo = recibo;
        this.panelRecibo.add(panelDelTiquet);
        this.panelRecibo.add(panelDelTiquet);
    }
    public JPanel getPanelVerduras(){
        return panelVerduras;
    }
    public JPanel getPanelRecibo(){
        return panelRecibo;
    }
    public JPanel getPanelDelTiquet(){
        return panelDelTiquet;
    }
    public JLabel getTotalDelTiquet(){
        return totalDelTiquet;
    }
    public Recibo getRecibo(){
        return recibo;
    }

}

