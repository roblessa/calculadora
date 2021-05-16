package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.AnunciosDAO;
import dao.RelatorioDAO;
import model.AnunciosModel;
import model.RelatorioModel;

public class CadastroAnuncios {
	
	private JFrame frmAnuncio;
	private JTextField textNome;
	private JTextField textPesquisa;
	private JTextField relatorio;

	private JTable tableListaAnuncios;
	private int id;

	public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
		public void run() {
                    try {
                        CadastroAnuncios window = new CadastroAnuncios();
                        window.frmAnuncio.setVisible(true);
                    } catch (Exception e) {
			e.printStackTrace();
                    }
		}
            });
        }

	
	public CadastroAnuncios() {
            initialize();
            readTtable();
	}
	
	public void readTtable(){
            DefaultTableModel modelo = (DefaultTableModel) tableListaAnuncios.getModel();
            tableListaAnuncios.setRowSorter(new TableRowSorter(modelo));
		
            AnunciosDAO anuncio = new AnunciosDAO();
		
            for(AnunciosModel p: anuncio.read()) {
		modelo.addRow(new Object[] {
				
                    p.getId_Cliente(),	
                    p.getNomeAnuncio(),
                    p.getDataInicial(),
                    p.getDataTermino(),
                    p.getInvestimentoDiario()
		});
            }
		
	}
	
	public void readTtableFroNome(AnunciosModel nome){
		DefaultTableModel modelo = (DefaultTableModel) tableListaAnuncios.getModel();
		tableListaAnuncios.setRowSorter(new TableRowSorter(modelo));
		
		AnunciosDAO anuncio = new AnunciosDAO();
		
		for(AnunciosModel p: anuncio.readFroNomeAnuncio(nome)) {
                    modelo.addRow(new Object[] {
			p.getId_Cliente(),	
                        p.getNomeAnuncio(),
                        p.getDataInicial(),
                        p.getDataTermino(),
                        p.getInvestimentoDiario()
                    });
		}
            }
	
	
	
	private void initialize() {
            frmAnuncio = new JFrame();
            frmAnuncio.setTitle("Lista de Anuncios");
            frmAnuncio.setBounds(100, 100, 861, 510);
            frmAnuncio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frmAnuncio.getContentPane().setLayout(null);
		
            JButton btnCreat = new JButton("Adicionar");
            btnCreat.setBackground(new Color(153, 255, 153));
            btnCreat.addActionListener(new ActionListener() {
			
                public void actionPerformed(ActionEvent e) {
                    AnunciosModel AnunciosModel = new AnunciosModel();
                    AnunciosDAO AnunciosDao = new AnunciosDAO();
				
                    if(textNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "É preciso preencher o campo nome!");
                    }
				
                    // Seta os valores no modelo
                    AnunciosModel.setNomeAnuncio(textNome.getText());
                    AnunciosModel.setRelatorio(textRelatorio.getText()); 
				
                    // Cria no Banco
                    AnunciosDao.create(AnunciosModel);
				
                    ((DefaultTableModel) tableListaAnuncios.getModel()).setRowCount(0);
                    readTtable();
                    }
		}
            );
		
            btnCreat.setBounds(47, 362, 89, 23);
            frmAnuncio.getContentPane().add(btnCreat);
		
            textNome = new JTextField();
            textNome.setBounds(119, 84, 183, 20);
            frmAnuncio.getContentPane().add(textNome);
            textNome.setColumns(10);
		
            JLabel lblNewLabel = new JLabel("Nome Anuncio");
            lblNewLabel.setBounds(47, 87, 46, 14);
            frmAnuncio.getContentPane().add(lblNewLabel);
		
            JButton btnAtualizar = new JButton("Atualizar");
            btnAtualizar.addActionListener(new ActionListener() {
			
		

                public void actionPerformed(ActionEvent e) {
				
                    AnunciosModel AnunciosModel = new AnunciosModel();
                    AnunciosDAO AnunciosDao = new AnunciosDAO();
				
                    if(id == 0) {	
			JOptionPane.showMessageDialog(null, "É preciso selecionar um registro!");	
                    }else if(textNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "É preciso preencher o campo nome!");
				
                    }else {
                        AnunciosModel.setId_Cliente(id);
			AnunciosModel.setNomeAnuncio(textNome.getText());
			
					
			AnunciosDao.update(AnunciosModel);
					
					
			((DefaultTableModel) tableListaAnuncios.getModel()).setRowCount(0);
					readTtable();
                    }
		}
            });
            btnAtualizar.setBackground(new Color(255, 255, 153));
            btnAtualizar.setBounds(386, 362, 89, 23);
            frmAnuncio.getContentPane().add(btnAtualizar);
		
            JButton btnDeletar = new JButton("Deletar");
            btnDeletar.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
                    AnunciosModel CafeModel = new AnunciosModel();
                    AnunciosDAO CafeDao = new AnunciosDAO();
							
                    if(id == 0) {
			JOptionPane.showMessageDialog(null, "� preciso selecionar um registro!");
                    }else {
			AnunciosModel.setId_Cliente(id_cliente);
                        AnunciosModel.setNomeAnuncio(textNome.getText());
									
			AnunciosDAO.delete(AnunciosModel);
					
			((DefaultTableModel) tableListaAnuncios.getModel()).setRowCount(0);
			readTtable();
                    }
				
		}
            });
            btnDeletar.setBackground(new Color(255, 153, 153));
            btnDeletar.setBounds(720, 362, 89, 23);
            frmAnuncio.getContentPane().add(btnDeletar);
		
		
		
            JLabel lblNewLabel_2 = new JLabel("Pesquisa");
            lblNewLabel_2.setBounds(437, 11, 63, 14);
            frmAnuncio.getContentPane().add(lblNewLabel_2);
		
            textPesquisa = new JTextField();
            textPesquisa.setBounds(537, 8, 162, 20);
            frmAnuncio.getContentPane().add(textPesquisa);
            textPesquisa.setColumns(10);
		
            JButton btnPesquisa = new JButton("Pesquisa");
            btnPesquisa.addActionListener(new ActionListener() {
		
                public void actionPerformed(ActionEvent e) {
                    AnunciosModel AnunciosModel = new AnunciosModel();
                    AnunciosDAO AnunciosDao = new AnunciosDAO();
				
                    AnunciosModel.setNomeAnuncio(textPesquisa.getText());
				
                    ((DefaultTableModel) tableListaAnuncios.getModel()).setRowCount(0);
                    readTtableFroNome(AnunciosModel);
                }
            });
            btnPesquisa.setBounds(720, 7, 89, 23);
            frmAnuncio.getContentPane().add(btnPesquisa);
		
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(47, 158, 762, 158);
            frmAnuncio.getContentPane().add(scrollPane);
		
            tableListaAnuncios = new JTable();
            tableListaAnuncios.addMouseListener(new MouseAdapter() {
			
		@Override
		public void mouseClicked(MouseEvent e) {
				
                    id = Integer.valueOf(tableListaAnuncios.getModel().getValueAt(tableListaAnuncios.getSelectedRow(), 0).toString());
                    textNome.setText(tableListaAnuncios.getModel().getValueAt(tableListaAnuncios.getSelectedRow(), 1).toString());
                    relatorio = set.valueOf(tableListaAnuncios.getModel().getValueAt(tableListaAnuncios.getSelectedRow(),2).toString());
		}
            });
		
            tableListaAnuncios.setModel(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
                    "Id_Cliente", "nomeAnuncio", "dataInicial", "dataTermino", "investimentoDiario"
		}
            ));
            scrollPane.setViewportView(tableListaAnuncios);
		
            JButton btnHome = new JButton("Home");
            btnHome.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
                    frmAnuncio.setVisible(false);
		}
                });
		btnHome.setBounds(47, 7, 89, 23);
		frmAnuncio.getContentPane().add(btnHome);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			
                    public void actionPerformed(ActionEvent e) {
			textNome.setText("");
				
                    }
		});
		btnLimpar.setBackground(new Color(204, 255, 255));
		btnLimpar.setBounds(720, 84, 89, 23);
		frmAnuncio.getContentPane().add(btnLimpar);
	}


	}
