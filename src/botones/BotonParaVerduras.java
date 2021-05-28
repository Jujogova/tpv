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
}
