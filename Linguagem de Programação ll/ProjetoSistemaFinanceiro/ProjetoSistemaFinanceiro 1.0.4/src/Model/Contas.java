package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Contas extends Competencia {
    private String descricao;
    private double valor;
    private String dataHora;
    private String pago;
    Boolean cadastrado = false;
    public ArrayList<Contas>ListaContas = new ArrayList();
    String competencia;
    
    public Contas() {
    }

    public Contas(String descricao, float valor, String dataHora, String competencia, String pago) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataHora = dataHora;
        this.competencia = competencia;
        this.pago = pago;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    
    
    public String getDataHora() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
	Date date = new Date(); 
	return dateFormat.format(date); 
    }

    public Boolean getCadastrado() {
        return cadastrado;
    }

    public void setCadastrado(Boolean cadastrado) {
        this.cadastrado = cadastrado;
    }
    
    
    
}
