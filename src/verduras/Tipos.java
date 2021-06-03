package verduras;

public enum Tipos {
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
    CORMOS("Cormo");

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
