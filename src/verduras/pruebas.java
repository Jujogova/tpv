package verduras;

import paneles.PanelParaTipos;
import paneles.PanelTiquet;
import paneles.PanelVerduras;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class pruebas {
    public static void main(String[] args) {
        File RFO = new File("Verduras.csv");
        PanelTiquet panelTiquet = new PanelTiquet();
        PanelVerduras panelVerduras = new PanelVerduras(panelTiquet);
        PanelParaTipos panelParaTipos = new PanelParaTipos(panelVerduras);
        try (BufferedReader bf = new BufferedReader(new FileReader(RFO))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                List<String> campos = Arrays.asList(linea.split(";"));
                Tipos tipos = Tipos.valueOf(campos.get(2));
                Verdura verdura = new Verdura(campos.get(0), Integer.parseInt(campos.get(1)), tipos);
                panelVerduras.anyadeVerdura(verdura);
            }
        }
    }
}