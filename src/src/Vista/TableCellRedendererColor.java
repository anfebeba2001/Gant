package src.Vista;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCellRedendererColor extends DefaultTableCellRenderer {
	
	private Component componente;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if (value == null)
			componente.setBackground(Color.WHITE);
		else if (value.equals("  "))
			componente.setBackground(new Color(154, 163, 223));
		else if(value.equals(" "))
			componente.setBackground(new Color(101, 248, 170));
		else
			componente.setBackground(Color.WHITE);
		
		return componente; 	
	}
	
}
