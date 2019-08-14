package Model;

import java.util.ArrayList;

public class Competencia {
    private String data;
    private float gastos;
    private float saldo;
    public ArrayList<Competencia> ListaCompetencia = new ArrayList();

    public Competencia() {
    }

    public Competencia(String data, float gastos, float saldo) {
        this.data = data;
        this.gastos = gastos;
        this.saldo = saldo;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getGastos() {
        return gastos;
    }

    public void setGastos(float gastos) {
        this.gastos = gastos;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
