package verduras;

import java.io.Serializable;

public enum Tipos implements Serializable {
    /**
     * Nos muestra el tipo de verdura que es.
     */
    HOJA("Hoja"),
    RAIZ("Raiz"),
    FRUTO("Fruto"),
    BULBO("Bulbo"),
    TUBERCULO("Tuberculo"),
    SEMILLA("Semilla"),
    INFLORESCENCIA("Inflorescencia"),
    TALLO("Tallo"),
    CORMO("Cormo"),
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
