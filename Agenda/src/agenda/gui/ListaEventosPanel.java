package agenda.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListaEventosPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListaEventosPanel() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 430, 278);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);

	}
}
