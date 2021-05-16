
package model;


public class Calculadora {
    private static int numeroTotalPessoas = 30;

    
    public int calcularVisualizacao(int value) {
        int visualizacaoPessoas = (int) Math.floor(value * numeroTotalPessoas);
        return visualizacaoPessoas;
    }

    
    public int calcularCliques(int visualizacaoPessoas) {
        int numeroCliques = (int) Math.floor((visualizacaoPessoas * 12) / 100);
        return numeroCliques;
    }

    
    public int shares (int numeroCliques) {
        int numeroShares = (int) Math.floor((numeroCliques * 3) / 20);
        return numeroShares;
    }

    
    public int qtdVisualizado (int numeroShares, int visualizacaoPessoas) {
        visualizacaoPessoas += (int) Math.floor(numeroShares * 40);
        return visualizacaoPessoas;
    }

    
    public int totalViews (int visualizacaoPessoas) {
        int totalViews = (int) Math.pow(visualizacaoPessoas, 4);
        return totalViews;
    }
}

