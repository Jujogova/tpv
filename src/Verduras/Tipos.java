package Verduras;

public enum Tipos {
    HOJAS("Hoja"),
    RAÍCES("Raíz"),
    FRTUOI("Fruto"),
    BULBOS("Bulbo"),
    TUBÉRCULOS("Tubérculo"),
    SEMILLAS("Semilla"),
    INFLORESCENCIAS("Inflorescencia"),
    TALLOS("Tallo"),
    CORMOS("Cormo");

    private String tiposDescripcion;

    Tipos(String tiposDescripcion){
        this.tiposDescripcion=tiposDescripcion;
    }
}
