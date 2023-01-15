package Artificialy;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Hashtable;

import javax.swing.table.DefaultTableModel;

public class SaveMouseListener implements MouseListener{

    GUI_Management GUI_ManagementObj;
    Utilities Utilities_Obj = new Utilities();
    
    final String[] columnsToDisplay = {
			"FIRST NAME",
			"LAST NAME",
			"E-MAIL",
			"GENDER",
			"IP ADDRESS",
			"COUNTRY"			
	};
    
	public SaveMouseListener(GUI_Management GUI_ManagementObj)
	{
		this.GUI_ManagementObj = GUI_ManagementObj;		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		insert();
		
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
	
	public void insert() {
		
		// I get the values inserted by GUI
		String firstName = GUI_ManagementObj.textFieldFirstName.getText().trim();
		String lastName = GUI_ManagementObj.textFieldLastName.getText().trim();
		String email = GUI_ManagementObj.textFieldEmail.getText().trim();
		String gender = GUI_ManagementObj.textFieldGender.getText().trim();
		String ipAddress = GUI_ManagementObj.textFieldIpAddress.getText().trim();
		String country =  GUI_ManagementObj.textFieldCountry.getText().trim();
		
		//I put these values in an hashtable
		Hashtable rowHashtableNewPerson= new Hashtable();
		rowHashtableNewPerson.put(columnsToDisplay[0], firstName);
		rowHashtableNewPerson.put(columnsToDisplay[1], lastName);
		rowHashtableNewPerson.put(columnsToDisplay[2], email);
		rowHashtableNewPerson.put(columnsToDisplay[3], gender);
		rowHashtableNewPerson.put(columnsToDisplay[4], ipAddress);
		rowHashtableNewPerson.put(columnsToDisplay[5], country);
		
				
		
		//I add this hashtable to the arraylist which elements are shown in the JTable
		GUI_ManagementObj.tableArrayList.add(rowHashtableNewPerson);
		
		
		//I delete all data from the JTable
		DefaultTableModel tableModel = ((DefaultTableModel)GUI_ManagementObj.table.getModel());
		tableModel.setRowCount(0);
		
		reloadTable();
		
		//I update the comboBox with the new country just inserted (if it is not already present)
		updateCountryComboBox(country);
		
	}
	
     public void reloadTable() {
		
		GUI_ManagementObj.insertData(GUI_ManagementObj.tableArrayList);
		
	}     
     
     
     public void updateCountryComboBox(String newCountry) {
    	 
    	 if (Utilities_Obj.StringIsPresent(newCountry,GUI_ManagementObj.CountryDistinct)==false) {
    	 
    		 GUI_ManagementObj.CountryDistinct.add(newCountry);
    		 GUI_ManagementObj.countryComboBox.addItem(newCountry);
    	 }
    	 
     }
	

}
