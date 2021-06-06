package verduras;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Recibo implements Serializable {
    private final static int LONGITUD_FORMATO=40;
    private int reciboTotal;
    private final LocalDateTime creacion;
    private final Map<Verdura, Integer> listaVerdurasPinchadas;

    public Recibo(){
        this.listaVerdurasPinchadas = new LinkedHashMap<>();
        this.creacion = LocalDateTime.now();
    }
    public List<Verdura> getListaVerduraPinchadas(){
        List<Verdura> salir = new ArrayList<>();
        salir.addAll(listaVerdurasPinchadas.keySet());
        return salir;
    }
    public String getReciboTotal(){
        return reciboTotal/100+","+reciboTotal %100+"€";
    }
    public String getTotalTotalisimo(Verdura verdura){
        int totalTotalisimo = verdura.getPrecio() * listaVerdurasPinchadas.get(verdura);
        return totalTotalisimo / 100 +", " +totalTotalisimo % 100 +"€";
    }

    public String getFecha(){
        String dia= creacion.getDayOfMonth()+ " - " +creacion.getMonthValue()+" - "+creacion.getYear();
        String hora = creacion.getHour()+":"+creacion.getMinute();
        return "El dia "+dia+ " a las " +hora+ " se ha creado su recibo.";
    }
    public void anyadirRecibo(Verdura verdura){
        Integer verduraEnCesta = listaVerdurasPinchadas.putIfAbsent(verdura, 1);
        if(verduraEnCesta != null ){
            int recibroEnProceso = listaVerdurasPinchadas.get(verdura);
            listaVerdurasPinchadas.put(verdura, recibroEnProceso + 1);
        }
        actualizaRecibo(verdura);
    }
    private void actualizaRecibo(Verdura verdura) {
        reciboTotal += verdura.getPrecio();
    }
    public int getVerdurasAlmacenadas(Verdura verdura){
        return listaVerdurasPinchadas.get(verdura);
    }
    public void quitarDelCarro(Verdura verdura){
        int cantidadCarro = listaVerdurasPinchadas.get(verdura);
        reciboTotal = reciboTotal-verdura.getPrecio() * cantidadCarro;
        listaVerdurasPinchadas.remove(verdura);
    }

}
