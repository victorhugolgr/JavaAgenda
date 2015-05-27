package agenda.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import agenda.io.AgendaIO;
import agenda.util.PeriodicidadeEnum;
import agenda.vo.Evento;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroEventoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfDescEvento;
	private JTextField tfDataEvento;
	private JTextField tfEncaminharEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox ckbAlarme;
	private JRadioButton rdbUmavez;
	private JRadioButton rdbSemanal;
	private JRadioButton rdbMensal;

	/**
	 * Create the panel.
	 */
	ListaEventosPanel listaEventos;
	
	public CadastroEventoPanel(ListaEventosPanel listaEventos) {
		
		this.listaEventos = listaEventos;
		
		setLayout(null);
		
		JLabel lblDescEvento = new JLabel("Descri\u00E7\u00E3o do Evento");
		lblDescEvento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescEvento.setBounds(10, 11, 130, 14);
		add(lblDescEvento);
		
		tfDescEvento = new JTextField();
		tfDescEvento.setBounds(10, 36, 430, 20);
		add(tfDescEvento);
		tfDescEvento.setColumns(10);
		
		JLabel lblDataEvento = new JLabel("Data do Evento");
		lblDataEvento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataEvento.setBounds(10, 73, 95, 14);
		add(lblDataEvento);
		
		tfDataEvento = new JTextField();
		tfDataEvento.setBounds(125, 70, 130, 20);
		add(tfDataEvento);
		tfDataEvento.setColumns(10);
		
		JLabel lblEncaminharEmail = new JLabel("Encaminhar e-mail");
		lblEncaminharEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEncaminharEmail.setBounds(10, 98, 105, 14);
		add(lblEncaminharEmail);
		
		tfEncaminharEmail = new JTextField();
		tfEncaminharEmail.setBounds(125, 95, 196, 20);
		add(tfEncaminharEmail);
		tfEncaminharEmail.setColumns(10);
		
		JLabel lblPeriodicidadeEvento = new JLabel("Periodicidade do Evento");
		lblPeriodicidadeEvento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPeriodicidadeEvento.setBounds(10, 123, 141, 14);
		add(lblPeriodicidadeEvento);
		
		rdbUmavez = new JRadioButton("Uma Vez");
		buttonGroup.add(rdbUmavez);
		rdbUmavez.setBounds(146, 119, 73, 23);
		add(rdbUmavez);
		
		rdbSemanal = new JRadioButton("Semanal");
		buttonGroup.add(rdbSemanal);
		rdbSemanal.setBounds(221, 119, 73, 23);
		add(rdbSemanal);
		
		rdbMensal = new JRadioButton("Mensal");
		buttonGroup.add(rdbMensal);
		rdbMensal.setBounds(294, 119, 59, 23);
		add(rdbMensal);
		
		ckbAlarme = new JCheckBox("Alarme");
		ckbAlarme.setFont(new Font("Tahoma", Font.BOLD, 11));
		ckbAlarme.setBounds(10, 151, 97, 23);
		add(ckbAlarme);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chamaCadastroEvento();
			}
		});
		btnSalvar.setBounds(130, 151, 89, 23);
		add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(232, 151, 89, 23);
		add(btnLimpar);

	}

	private void chamaCadastroEvento(){
		
		AgendaIO io = new AgendaIO();
		Evento evento = new Evento();
		
		Object[] novaLinha = new Object[5];
		
		evento.setDataEvento(agenda.util.AgendaUtils.getDateFromString(tfDataEvento.getText()));
		evento.setDescEvento(tfDescEvento.getText());
		evento.setAlarme(ckbAlarme.isSelected()? 1:0);
		evento.setEmailEncaminhar(tfEncaminharEmail.getText());
		
		novaLinha[0] = tfDataEvento.getText();
		novaLinha[1] = tfDescEvento.getText();
		novaLinha[2] = ckbAlarme.isSelected()? "LIGADO": "DESLIGADO";
		novaLinha[3] = tfEncaminharEmail.getText();
		
		if(rdbUmavez.isSelected()){
			evento.setPeriodicidade(PeriodicidadeEnum.UNICO);
		}else if(rdbSemanal.isSelected()){
			evento.setPeriodicidade(PeriodicidadeEnum.SEMANAL);
		}else if(rdbMensal.isSelected()){
			evento.setPeriodicidade(PeriodicidadeEnum.MENSAL);
		}
		
		try {
			io.gravarEvento(evento);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "ERRO", ex.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
		
		listaEventos.addNewRow(novaLinha);
		limparCampos();
	}
	
	private void limparCampos(){
		tfDataEvento.setText("");
		tfDescEvento.setText("");
		tfEncaminharEmail.setText("");
		ckbAlarme.setSelected(false);
		rdbUmavez.setSelected(true);
	}
}
