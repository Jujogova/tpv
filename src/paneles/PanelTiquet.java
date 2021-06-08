package paneles;

import verduras.Recibo;
import verduras.Verdura;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Map;

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
        this.panelRecibo = new JPanel(new GridLayout(0,1));
        this.panelVerduras = new JPanel(new GridLayout(0, 1));
        this.panelDelTiquet = new JPanel();
        panelDelTiquet.setLayout(new BorderLayout());
        this.recibo = recibo;
        this.panelRecibo.add(panelDelTiquet);
        this.panelRecibo.add(panelVerduras);
        generaPanelDelTiquet();
    }

    /**
     * Genera el total de lo que está costando la compra y el panel de impresión.
     */
    public void generaPanelDelTiquet() {
        panelDelTiquet.removeAll();
        JPanel panel = new JPanel();
        BoxLayout bl = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        panel.setLayout(bl);
        for (Map.Entry<Verdura, Integer> v : recibo.getListaVerduraPinchadas().entrySet()) {
            JPanel tempPanel = new JPanel();
            tempPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel  jl =  new JLabel(v.getKey().getNombre() + " " +v.getValue() + " Total: " +v.getKey().getPrecioEnCentimosYEuros(v.getKey().getPrecio()*v.getValue()));
            jl.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
            tempPanel.add(jl);
            JButton jb = new JButton("X");
            jb.addActionListener(e-> {
                recibo.quitarDelCarro(v.getKey());
                generaPanelDelTiquet();
            });
            tempPanel.add(jb);
            panel.add(tempPanel);
        }
        panel.add(new JLabel("Total de la compra:" + recibo.precioTotalDeLaCompra() ));
        panelDelTiquet.add(panel, BorderLayout.PAGE_START);
        panelDelTiquet.repaint();
        panelDelTiquet.revalidate();
        panelDelTiquet.getParent().repaint();
        panelDelTiquet.getParent().revalidate();

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
    }

    /**
     * Genera la información del recibo ademas de poder borrar del carro de compra.
     */
    /*
    private void generarInformacionRecibo() {
        for (Verdura verd : recibo.getListaVerduraPinchadas()) {
            int cantidad = recibo.getVerdurasAlmacenadas(verd);
            String subtotal = recibo.getTotalTotalisimo(verd);
            JLabel label = new JLabel(verd.getNombre() + cantidad + " " + verd.getInfo() + " - Total: " + subtotal);
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

*/
}

