package agenda.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class CadastroEventoPanel extends JPanel {
	private JTextField tfDescEvento;
	private JTextField tfDataEvento;
	private JTextField tfEncaminharEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public CadastroEventoPanel() {
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
		
		JRadioButton rdbUmavez = new JRadioButton("Uma Vez");
		buttonGroup.add(rdbUmavez);
		rdbUmavez.setBounds(146, 119, 73, 23);
		add(rdbUmavez);
		
		JRadioButton rdbSemanal = new JRadioButton("Semanal");
		buttonGroup.add(rdbSemanal);
		rdbSemanal.setBounds(221, 119, 73, 23);
		add(rdbSemanal);
		
		JRadioButton rdbMensal = new JRadioButton("Mensal");
		buttonGroup.add(rdbMensal);
		rdbMensal.setBounds(294, 119, 59, 23);
		add(rdbMensal);
		
		JCheckBox ckbAlarme = new JCheckBox("Alarme");
		ckbAlarme.setFont(new Font("Tahoma", Font.BOLD, 11));
		ckbAlarme.setBounds(10, 151, 97, 23);
		add(ckbAlarme);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(130, 151, 89, 23);
		add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(232, 151, 89, 23);
		add(btnLimpar);

	}
}
