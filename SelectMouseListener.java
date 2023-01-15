package Artificialy;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.table.DefaultTableModel;

public class SelectMouseListener implements MouseListener {
	
	GUI_Management GUI_ManagementObj;
	
	public SelectMouseListener(GUI_Management GUI_ManagementObj)
	{
		this.GUI_ManagementObj = GUI_ManagementObj;		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {		
		
		//I delete all data from the table
		DefaultTableModel tableModel = ((DefaultTableModel)GUI_ManagementObj.table.getModel());
		tableModel.setRowCount(0);
		
		//I reload the table
		reloadTable();
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void reloadTable(){
		
		String CountrySelected = new String();
		
		CountrySelected = GUI_ManagementObj.countryComboBox.getSelectedItem().toString();		
		
		GUI_ManagementObj.insertData(GUI_ManagementObj.filterTable(CountrySelected));
		
	}
	
}
