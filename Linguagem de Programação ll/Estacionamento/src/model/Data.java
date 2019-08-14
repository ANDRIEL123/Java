package model;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class Data {
    public String data;
    private int horas;
    private int minutos;
    private int segundos;

    public Data() {
        this.data = getData();
        this.horas = getHora();
        this.minutos = getMinuto();
        this.segundos = getSegundos();
    }

    public String getData() {
        Date d = new Date();
        String dataFormatada = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
        
        return dataFormatada;
    }


    public int getHora() {
        Calendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinuto() {
        Calendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.MINUTE);
    }

    public int getSegundos() {
        Calendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.SECOND);
    } 
    
    public String formataHora(int dado) {
        if (dado < 10) {
            return "0" + Integer.toString(dado);
        }
        return Integer.toString(dado);
    }

    @Override
    public String toString() {
        return "Data{" + "data=" + data + ", horas=" + horas + ", minutos=" + minutos + ", segundos=" + segundos + '}';
    }
    
    
}
