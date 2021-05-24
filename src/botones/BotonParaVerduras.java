package botones;

import verduras.Tipos;
import verduras.Verdura;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BotonParaVerduras {
    private final JButton boton;
    private final Verdura verdura;

    public BotonParaVerduras(Verdura verdura){
        this.verdura = verdura;
        this.boton = new JButton();
        boton.setBorder(new EmptyBorder(5, 5, 5 ,5));
        boton.addActionListener(e-> {verdura.getNombre();
        });
    }

    public JButton getBoton() {
        return boton;
    }

    public Verdura getVerdura() {
        return verdura;
    }

    public static void main(String[] args) {
        Verdura verdura = new Verdura("Puerro", 153, Tipos.TALLOS);
        BotonParaVerduras button = new BotonParaVerduras(verdura);

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.add(button.getBoton());
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
