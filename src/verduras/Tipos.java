package verduras;

public enum Tipos {
    HOJAS("Hoja"),
    RAICES("Raiz"),
    FRTUOS("Fruto"),
    BULBOS("Bulbo"),
    TUBÉRCULOS("Tubérculo"),
    SEMILLAS("Semilla"),
    INFLORESCENCIAS("Inflorescencia"),
    TALLOS("Tallo"),
    CORMOS("Cormo");

    private String tiposDescripcion;

    Tipos(String tiposDescripcion){
        this.tiposDescripcion = tiposDescripcion;
    }

    public String getTiposDescripcion() {
        return tiposDescripcion;
    }

}
