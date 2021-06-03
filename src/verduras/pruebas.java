package verduras;

import paneles.PanelParaTipos;
import paneles.PanelTiquet;
import paneles.PanelVerduras;

import java.io.*;
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
                panelParaTipos.(verdura);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException aibe) {

            //TODO: Log del aibe
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        }
    }