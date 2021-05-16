package model;

import java.util.Date;

public class AnunciosModel {

    private int id_cliente;
    private String nomeAnuncio;
    private Date dataInicial;
    private Date dataTermino;
    private float investimentoDiario;

    public int getId_Cliente() {
        return id_cliente;
    }

    public void setId_Cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNomeAnuncio() {
        return nomeAnuncio;
    }

    public void setNomeAnuncio(String nomeAnuncio) {
        this.nomeAnuncio = nomeAnuncio;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public float getInvestimentoDiario() {
        return investimentoDiario;
    }

    public void setInvestimentoDiario(float investimentoDiario) {
        this.investimentoDiario = investimentoDiario;
    }

    


}
