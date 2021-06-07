package paneles;

import verduras.Recibo;
import verduras.Verdura;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 *Clase para el panel del recibo
 */
public class PanelTiquet implements Serializable {
    private final JPanel panelRecibo;
    private final JPanel panelVerduras;
    private final JPanel panelDelTiquet;
    private JLabel totalDelTiquet;
    private final Recibo recibo;

    /**
     * Constructor del panel del tiquet
     * @param recibo
     */
    public PanelTiquet(Recibo recibo){
        this.panelRecibo = new JPanel(new GridLayout(2,1));
        this.panelVerduras = new JPanel(new GridLayout(0, 2));
        this.panelDelTiquet = new JPanel();
        this.recibo = recibo;
        this.panelRecibo.add(panelDelTiquet);
        this.panelRecibo.add(panelVerduras);
        generaPanelDelTiquet();
    }

    /**
     * Genera el total de lo que está costando la compra y el panel de impresión.
     */
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
/**
 * Cuando imprimes te dice lo que tienes que pagar
 */
    }
    private void actualizaCosteTotalRecibo() {
        totalDelTiquet.setText("Recibo a pagar: " + recibo.getReciboTotal());
    }

    /**
     * Obtiene el panel de verduras.
     * @return panelVerduras
     */
    public JPanel getPanelVerduras(){
        return panelVerduras;
    }

    /**
     * Obtiene el panel recibo
     * @return panelRecibo
     */
    public JPanel getPanelRecibo(){
        return panelRecibo;
    }

    /**
     * Obtiene el panel Del Tiquet
     * @return panelDelTiquet
     */
    public JPanel getPanelDelTiquet(){
        return panelDelTiquet;
    }

    /**
     * Cuando pulsas actualiza los paneles
     * @param verdura
     */
    public void pulsado(Verdura verdura) {
        recibo.anyadirRecibo(verdura);
        panelVerduras.removeAll();
        panelVerduras.repaint();
        panelVerduras.revalidate();
        actualizaCosteTotalRecibo();
    }

    /**
     * Genera la informacion del recibo ademas de poder borrar del carro de compra.
     */
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
                generarInformacionRecibo();
                panelVerduras.revalidate();
                panelVerduras.repaint();
            });
            panelVerduras.add(label);
            panelVerduras.add(button);
        }
    }

}

