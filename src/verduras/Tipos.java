package verduras;

import java.io.Serializable;

public enum Tipos implements Serializable {
    /**
     * Nos muestra el tipo de verdura que es.
     */
    HOJAS("Hoja"),
    RAICES("Raiz"),
    FRUTOS("Fruto"),
    BULBOS("Bulbo"),
    TUBERCULOS("Tuberculo"),
    SEMILLAS("Semilla"),
    INFLORESCENCIAS("Inflorescencia"),
    TALLOS("Tallo"),
    CORMOS("Cormo"),
    VERDULERIA("Verduleria entera");

    private String tiposDescripcion;

    /**
     * Constructor de tipos de hortalizas.
     * @param tiposDescripcion
     */
    Tipos(String tiposDescripcion){
        this.tiposDescripcion = tiposDescripcion;
    }

    /**
     * Devuelve el tipo de verdura
     * @return
     */
    public String getTiposDescripcion() {
        return tiposDescripcion;
    }

}
