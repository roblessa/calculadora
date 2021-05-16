
package view;

import dao.RelatorioDAO;
import javax.swing.JOptionPane;
import model.Calculadora;


public class Principal {

   
    public static void main(String[] args) {
        
        float valor = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor que será investido."));

        
        Calculadora calc = new Calculadora();
        int resultado = calc.calcularVisualizacao(value);
        int resultado2 = calc.calcularCliques(resultado);
        int resultado3 = calc.shares(resultado2);
        int resultado4 = calc.qtdVisualizado(resultado3, resultado);
        int resultado5 = calc.totalViews(resultado4);

        
        Relatorio novoRelatorio = new Relatorio();
        RelatorioDAO relatorioDao = new RelatorioDAO();
        novoRelatorio.setmaximoViews(resultado4);
        novoRelatorio.setmaximoCliques(resultado2);
        novoRelatorio.setmaximoShares(resultado3);
        novoRelatorio.settotalInvestido(resultado);
        relatorioDao.create(novoRelatorio);

    }
}
    

