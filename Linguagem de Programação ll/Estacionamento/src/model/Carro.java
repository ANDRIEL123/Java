package model;

import java.util.ArrayList;

public class Carro {
    private String placa;
    private String modelo;
    public Data data;
    public ArrayList<Carro> ListaDeCarros = new ArrayList();
    
    public Carro() {
    }

    public Carro(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.data = new Data();
    }
    
    public void addLista(Carro carro) {
        ListaDeCarros.add(carro);
    }
    
    public void removeLista(Carro carro) {
        ListaDeCarros.remove(carro);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Carro{" + "placa=" + placa + ", modelo=" + modelo + ", data=" + data + '}';
    }

    
    
}
