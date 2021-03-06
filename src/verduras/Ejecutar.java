package verduras;

import paneles.PanelParaTipos;
import paneles.PanelTiquet;
import paneles.PanelVerduras;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class Ejecutar {
    public static void main(String[] args) {
        File ficLecturaObjetos = new File("Verduras.csv");
        Recibo recibo = new Recibo();
        PanelTiquet panelRecibo = new PanelTiquet(recibo);

        PanelVerduras panelVerduras = new PanelVerduras(panelRecibo);
        PanelParaTipos panelParaTipos = new PanelParaTipos(panelVerduras);

        try (BufferedReader bf = new BufferedReader(new FileReader(ficLecturaObjetos))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                List<String> campos = Arrays.asList(linea.split("-"));
                Tipos tipos = Tipos.valueOf(campos.get(2));
                Verdura verdura = new Verdura(campos.get(0), Integer.parseInt(campos.get(1)), tipos);
                panelVerduras.anyadeVerdura(verdura);
                panelParaTipos.anyadeVerduraEnUnaListaConSuTipo(verdura);
            }
        } catch (FileNotFoundException e) {
            Log.log(Level.SEVERE, "Fichero inexistente.");
        } catch (ArrayIndexOutOfBoundsException aibe) {
            Log.log(Level.WARNING, "Verdura fuera de temporada.");
        } catch (IllegalArgumentException iae) {
            Log.log(Level.WARNING, "Argumento inválido");
        } catch (IOException e) {
            Log.log(Level.WARNING, "Algo malo ha pasado.");
        }


        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        frame.add(panelParaTipos.getPanel(), BorderLayout.WEST);
        frame.add(panelVerduras.getPanelVerdura(), BorderLayout.EAST);
        frame.add(panelRecibo.getPanelDelTiquet(), BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
