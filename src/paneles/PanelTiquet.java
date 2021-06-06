package paneles;

import verduras.Recibo;
import verduras.Verdura;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class PanelTiquet implements Serializable {
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
        this.panelRecibo.add(panelVerduras);
        generaPanelDelTiquet();
    }

    private void generaPanelDelTiquet() {
        this.totalDelTiquet = new JLabel("Usted se está gastando por el momento: 0€");
        totalDelTiquet.setFont(new Font("Courier New", Font.ITALIC, 26));
        panelDelTiquet.add(totalDelTiquet);
        JButton boton = new JButton("Recibo");
        boton.addActionListener( e-> {
            int respuesta = JOptionPane.showConfirmDialog(panelRecibo,"¿Desea recibo?", "Imprimición", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
            }

        });
        panelDelTiquet.add(boton);

    }
    private void actualizaCosteTotalRecibo() {
        totalDelTiquet.setText("Recibo a pagar: " + recibo.getReciboTotal());
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

    public void pulsado(Verdura verdura) {
        recibo.anyadirRecibo(verdura);
        panelVerduras.removeAll();
        panelVerduras.repaint();
        panelVerduras.revalidate();
    }
    private void generarInformacionRecibo() {
        for (Verdura verd : recibo.getListaVerduraPinchadas()) {
            int cantidad = recibo.getVerdurasAlmacenadas(verd);
            String subtotal = recibo.getTotalTotalisimo(verd);

            JLabel label = new JLabel("x" + cantidad + " " + verd.getInfo() + " - Total: " + subtotal);
            label.setFont(new Font("Courier New", Font.PLAIN, 20));
            JButton button = new JButton("\uD83D\uDDD1");
            button.addActionListener( e-> {
                panelVerduras.remove(label);
                panelVerduras.remove(button);
                recibo.quitarDelCarro(verd);
                actualizaCosteTotalRecibo();
                panelVerduras.revalidate();
                panelVerduras.repaint();
            });
            panelVerduras.add(label);
            panelVerduras.add(button);
        }
    }

}

