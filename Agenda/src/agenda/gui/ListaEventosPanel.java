package agenda.gui;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import agenda.io.AgendaIO;

public class ListaEventosPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListaEventosPanel() {
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 430, 278);
		add(scrollPane);

		table = new JTable(getDataColumns(), getNameColumns());
		scrollPane.setColumnHeaderView(table);

	}

	private Vector<String> getNameColumns() {
		Vector<String> nameColumns = new Vector<String>();

		nameColumns.add("Data");
		nameColumns.add("Descrição");
		nameColumns.add("Periodicidade");
		nameColumns.add("E-mail");
		nameColumns.add("Alarme");

		return nameColumns;
	}

	public void addNewRow(Object[] valores) {
		((DefaultTableModel) table.getModel()).addRow(valores);
	}
	
	private Vector<Vector<Object>> getDataColumns(){
		AgendaIO io = new AgendaIO();
		Vector<Vector<Object>> dataColumns = null;
		
		try {
			dataColumns = io.getEventos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"ERRO", e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
		
		return dataColumns;
	}

}
