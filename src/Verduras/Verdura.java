package Verduras;

import java.io.Serializable;
import java.util.Objects;

public class Verdura implements Serializable {
    private String nombre;
    private int precio;
    private Tipos tipo;

    public Verdura(String nombre, int precio, Tipos tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrecio() {
        int euros= precio/100;
        int centimos = precio % 100;
        return euros + "," + centimos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Verdura verdura = (Verdura) o;
        return precio == verdura.precio &&
                Objects.equals(nombre, verdura.nombre) &&
                tipo == verdura.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio, tipo);
    }

    public Tipos getTipo() {
        return tipo;
    }
    private String getNombreCorrectamente() {
        return nombre.replaceAll(" ","_");
    }

    public static void main(String[] args) {
        Verdura P = new Verdura("Apio", 66, Tipos.HOJAS);
        System.out.println(P.getNombreCorrectamente());
    }
}
