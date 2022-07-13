

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class TelaProdutos {
	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProdutos window = new TelaProdutos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaProdutos() {
		initialize();
	}

    private Object[][] data;
	private ListaPedido lista = ListaPedido.getInstance();
	private HashSet<Pedido> pedidos;
	
	private String getTextoEstado(EstadoPedido estado) {
		String estadoString = "";
		switch (estado) {
			case Admitido:
				estadoString = "Admitido";
				break;
			case Carregamento:
				estadoString = "Carregamento";
				break;
			case Transporte:
				estadoString = "Transporte";
				break;
			case Entregue:
				estadoString = "Entregue";
				break;
		}
		
		return estadoString;
	}
	
	private void updateTable() {
		model.setRowCount(0);
		pedidos = lista.read();
		
		for (Pedido p : pedidos) {
			Endereco origem = p.getOrigem();
			Endereco destino = p.getDestino();
			String cidadeOrigem = (origem == null) ? "" : origem.getCidade();
			String cidadeDestino = (destino == null) ? "" : destino.getCidade();
			
			Object[] row = new Object[] {
					p.uuid,
					p.getDescricao(),
					getTextoEstado(p.getEstado()),
					p.getDimensoes(),
					p.getPeso(),
					cidadeOrigem,
					cidadeDestino
			};
			model.addRow(row);
		}
		
	}

	private DefaultTableModel model;
	private JTable jTable = new JTable(model);
    private JTextField jtfFilter = new JTextField();
    private JButton jbtFilter = new JButton("Filter");
    private JTable table;
    private JTextField descricaoTextField;
    private JTextField dimensoesTextField;
    private JTextField pesoTextField;
    private JTextField cepOrigemTextField;
    private JTextField ruaOrigemTextField;
    private JTextField numeroOrigemTextField;
    private JTextField bairroOrigemTextField;
    private JTextField cidadeOrigemTextField;
    private JTextField ufOrigemTextField;
    private JTextField complementoOrigemTextField;
    private JTextField numeroDestinoTextField;
    private JTextField cidadeDestinoTextField;
    private JTextField complementoDestinoTextField;
    private JTextField ufDestinoTextField;
    private JTextField bairroDestinoTextField;
    private JTextField cepDestinoTextField;
    private JTextField ruaDestinoTextField;
    private JTextField textField_17;

    private void initializeTable(JFrame frame) {
    	JScrollPane scrollPane = new JScrollPane();
    	scrollPane.setBounds(550, 24, 627, 526);
    	frame.getContentPane().add(scrollPane);
    	Object[] labels = { "UUID", "Descrição", "Estado Pedido", "Dimensoes", "Peso", "Cidade de Origem", "Cidade de Destino" };

    	model = new DefaultTableModel(data, labels);
    	table = new JTable();
    	scrollPane.setViewportView(table);
    	 
    	model.fireTableDataChanged();
    	table.setModel(model);
    	updateTable();
    }
    
    private Pedido getPedidoTextForm() {    	  	
    	Pedido pedido = new Pedido();
    	String descricao = descricaoTextField.getText();
    	String dimensoes = dimensoesTextField.getText();
    	String peso = pesoTextField.getText();
    	
    	pedido.setDescricao(descricao);
    	pedido.setDimensoes(dimensoes);
    	pedido.setPeso(peso);
    	
    	return pedido;
    }
    
    private Pedido pedido;
    private Endereco getEnderecoOrigemTextForm() {    	  	
    	Endereco endereco = new Endereco();
    	String cep = cepOrigemTextField.getText();
    	String rua = ruaOrigemTextField.getText();
    	String numero = numeroOrigemTextField.getText();
    	String bairro = bairroOrigemTextField.getText();
    	String cidade = cidadeOrigemTextField.getText();
    	String uf = ufOrigemTextField.getText();
    	String complemento = ufOrigemTextField.getText();
    	
    	endereco.setCep(cep);
    	endereco.setRua(rua);
    	endereco.setNumero(numero);
    	endereco.setBairro(bairro);
    	endereco.setCidade(cidade);
    	endereco.setUf(uf);
    	endereco.setComplemento(complemento);
    	
    	return endereco;
    }
    
    private Endereco getEnderecoDestinoTextForm() {    	  	
    	Endereco endereco = new Endereco();
    	String cep = cepDestinoTextField.getText();
    	String rua = ruaDestinoTextField.getText();
    	String numero = numeroDestinoTextField.getText();
    	String bairro = bairroDestinoTextField.getText();
    	String cidade = cidadeDestinoTextField.getText();
    	String uf = ufDestinoTextField.getText();
    	String complemento = ufDestinoTextField.getText();

    	endereco.setCep(cep);
    	endereco.setRua(rua);
    	endereco.setNumero(numero);
    	endereco.setBairro(bairro);
    	endereco.setCidade(cidade);
    	endereco.setUf(uf);
    	endereco.setComplemento(complemento);
    	
    	return endereco;
    }
    
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
	
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		initializeTable(frame);
		
		JButton btnNewButton = new JButton("Criar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pedido = getPedidoTextForm();
				Endereco origem = getEnderecoOrigemTextForm();
				Endereco destino = getEnderecoDestinoTextForm();
				pedido.setOrigem(origem);
				pedido.setDestino(destino);
				
				try {
					ListaPedido.getInstance().add(pedido);
				} catch (Exception exception) {
				}
				
				updateTable();					
			}
		});
		
		btnNewButton.setBounds(118, 529, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtualizar.setBounds(213, 529, 85, 21);
		frame.getContentPane().add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(308, 529, 85, 21);
		frame.getContentPane().add(btnDeletar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				descricaoTextField.setText("");
				dimensoesTextField.setText("");
				pesoTextField.setText("");
				
				cepOrigemTextField.setText("");
				ruaOrigemTextField.setText("");
				numeroOrigemTextField.setText("");
				bairroOrigemTextField.setText("");
				cidadeOrigemTextField.setText("");
				ufOrigemTextField.setText("");
				complementoOrigemTextField.setText("");
				
				cepDestinoTextField.setText("");
				ruaDestinoTextField.setText("");
				numeroDestinoTextField.setText("");
				bairroDestinoTextField.setText("");
				cidadeDestinoTextField.setText("");
				ufDestinoTextField.setText("");
				complementoDestinoTextField.setText("");
			}
		});
		btnLimpar.setBounds(404, 529, 85, 21);
		frame.getContentPane().add(btnLimpar);
		
		
		JLabel lblNewLabel = new JLabel("Descrição:");
		lblNewLabel.setBounds(22, 55, 94, 21);
		frame.getContentPane().add(lblNewLabel);
		
		descricaoTextField = new JTextField();
		descricaoTextField.setBounds(117, 55, 421, 21);
		frame.getContentPane().add(descricaoTextField);
		descricaoTextField.setColumns(10);
		
		JLabel lblDimenses = new JLabel("Dimensões:");
		lblDimenses.setBounds(22, 86, 85, 21);
		frame.getContentPane().add(lblDimenses);
		
		dimensoesTextField = new JTextField();
		dimensoesTextField.setColumns(10);
		dimensoesTextField.setBounds(117, 86, 253, 21);
		frame.getContentPane().add(dimensoesTextField);
		
		pesoTextField = new JTextField();
		pesoTextField.setColumns(10);
		pesoTextField.setBounds(453, 86, 85, 21);
		frame.getContentPane().add(pesoTextField);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(402, 86, 41, 21);
		frame.getContentPane().add(lblPeso);
		
		JLabel lblEndereoOrigem = new JLabel("Endereço Origem");
		lblEndereoOrigem.setBounds(236, 148, 125, 21);
		frame.getContentPane().add(lblEndereoOrigem);
		
		cepOrigemTextField = new JTextField();
		cepOrigemTextField.setColumns(10);
		cepOrigemTextField.setBounds(118, 179, 141, 21);
		frame.getContentPane().add(cepOrigemTextField);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(23, 179, 94, 21);
		frame.getContentPane().add(lblCep);
		
		ruaOrigemTextField = new JTextField();
		ruaOrigemTextField.setColumns(10);
		ruaOrigemTextField.setBounds(118, 210, 421, 21);
		frame.getContentPane().add(ruaOrigemTextField);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(23, 210, 94, 21);
		frame.getContentPane().add(lblRua);
		
		numeroOrigemTextField = new JTextField();
		numeroOrigemTextField.setColumns(10);
		numeroOrigemTextField.setBounds(118, 241, 85, 21);
		frame.getContentPane().add(numeroOrigemTextField);
		
		JLabel lblNmero = new JLabel("Número:");
		lblNmero.setBounds(23, 241, 94, 21);
		frame.getContentPane().add(lblNmero);
		
		bairroOrigemTextField = new JTextField();
		bairroOrigemTextField.setColumns(10);
		bairroOrigemTextField.setBounds(308, 241, 231, 21);
		frame.getContentPane().add(bairroOrigemTextField);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(262, 241, 46, 21);
		frame.getContentPane().add(lblBairro);
		
		cidadeOrigemTextField = new JTextField();
		cidadeOrigemTextField.setColumns(10);
		cidadeOrigemTextField.setBounds(118, 272, 231, 21);
		frame.getContentPane().add(cidadeOrigemTextField);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(23, 272, 94, 21);
		frame.getContentPane().add(lblCidade);
		
		ufOrigemTextField = new JTextField();
		ufOrigemTextField.setColumns(10);
		ufOrigemTextField.setBounds(454, 272, 85, 21);
		frame.getContentPane().add(ufOrigemTextField);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(414, 272, 30, 21);
		frame.getContentPane().add(lblUf);
		
		complementoOrigemTextField = new JTextField();
		complementoOrigemTextField.setColumns(10);
		complementoOrigemTextField.setBounds(118, 303, 421, 21);
		frame.getContentPane().add(complementoOrigemTextField);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(23, 303, 94, 21);
		frame.getContentPane().add(lblComplemento);
		
		JCheckBox checkboxAutocompleteCepOrigem = new JCheckBox("Completar Endereço Origem");
		checkboxAutocompleteCepOrigem.setBounds(265, 179, 275, 21);
		frame.getContentPane().add(checkboxAutocompleteCepOrigem);
		
		JLabel lblCidade_1 = new JLabel("Cidade:");
		lblCidade_1.setBounds(22, 458, 94, 21);
		frame.getContentPane().add(lblCidade_1);
		
		JLabel lblComplemento_1 = new JLabel("Complemento:");
		lblComplemento_1.setBounds(22, 489, 94, 21);
		frame.getContentPane().add(lblComplemento_1);
		
		JLabel lblNmero_1 = new JLabel("Número:");
		lblNmero_1.setBounds(22, 427, 94, 21);
		frame.getContentPane().add(lblNmero_1);
		
		JLabel lblCep_1 = new JLabel("CEP:");
		lblCep_1.setBounds(22, 365, 94, 21);
		frame.getContentPane().add(lblCep_1);
		
		JLabel lblRua_1 = new JLabel("Rua:");
		lblRua_1.setBounds(22, 396, 94, 21);
		frame.getContentPane().add(lblRua_1);
		
		numeroDestinoTextField = new JTextField();
		numeroDestinoTextField.setColumns(10);
		numeroDestinoTextField.setBounds(117, 427, 85, 21);
		frame.getContentPane().add(numeroDestinoTextField);
		
		cidadeDestinoTextField = new JTextField();
		cidadeDestinoTextField.setColumns(10);
		cidadeDestinoTextField.setBounds(117, 458, 231, 21);
		frame.getContentPane().add(cidadeDestinoTextField);
		
		complementoDestinoTextField = new JTextField();
		complementoDestinoTextField.setColumns(10);
		complementoDestinoTextField.setBounds(117, 489, 421, 21);
		frame.getContentPane().add(complementoDestinoTextField);
		
		ufDestinoTextField = new JTextField();
		ufDestinoTextField.setColumns(10);
		ufDestinoTextField.setBounds(453, 458, 85, 21);
		frame.getContentPane().add(ufDestinoTextField);
		
		JLabel lblUf_1 = new JLabel("UF:");
		lblUf_1.setBounds(413, 458, 30, 21);
		frame.getContentPane().add(lblUf_1);
		
		bairroDestinoTextField = new JTextField();
		bairroDestinoTextField.setColumns(10);
		bairroDestinoTextField.setBounds(307, 427, 231, 21);
		frame.getContentPane().add(bairroDestinoTextField);
		
		JLabel lblBairro_1 = new JLabel("Bairro:");
		lblBairro_1.setBounds(261, 427, 46, 21);
		frame.getContentPane().add(lblBairro_1);
		
		cepDestinoTextField = new JTextField();
		cepDestinoTextField.setColumns(10);
		cepDestinoTextField.setBounds(117, 365, 141, 21);
		frame.getContentPane().add(cepDestinoTextField);
		
		JCheckBox checkboxAutocompleteCepDestino = new JCheckBox("Completar Endereço Destino");
		checkboxAutocompleteCepDestino.setBounds(264, 365, 275, 21);
		frame.getContentPane().add(checkboxAutocompleteCepDestino);
		
		JLabel lblEndereoDestino = new JLabel("Endereço Destino");
		lblEndereoDestino.setBounds(236, 334, 125, 21);
		frame.getContentPane().add(lblEndereoDestino);
		
		ruaDestinoTextField = new JTextField();
		ruaDestinoTextField.setColumns(10);
		ruaDestinoTextField.setBounds(118, 396, 421, 21);
		frame.getContentPane().add(ruaDestinoTextField);
		
		JLabel lblPesquisa = new JLabel("Pesquisa:");
		lblPesquisa.setBounds(22, 24, 94, 21);
		frame.getContentPane().add(lblPesquisa);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(117, 24, 421, 21);
		frame.getContentPane().add(textField_17);
		
		JButton btnPrximoEstado = new JButton("Próximo Estado");
		btnPrximoEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedido n = new Pedido();
				n.setDescricao("testabdoooo");
				
				ListaPedido.getInstance().add(n);
			}
		});
		btnPrximoEstado.setBounds(338, 117, 201, 21);
		frame.getContentPane().add(btnPrximoEstado);
		
		JButton btnEstadoAnterior = new JButton("Estado Anterior");
		btnEstadoAnterior.setBounds(118, 117, 201, 21);
		frame.getContentPane().add(btnEstadoAnterior);
	}
}
