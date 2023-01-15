package Artificialy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

public class GUI_Management {	
	
	protected JFrame frame;
	protected JPanel mainPanel;
	protected JPanel centerPanel;	
	protected JPanel countryPanel;
	protected JPanel personPanel;
	protected JPanel statisticPanel;
	protected JPanel tablePanel;
	protected BorderLayout borderLayout, tableBorderLayout, centerAreaBorderLayout, countryBorderLayout;
	protected FlowLayout countryFlowLayout, statisticFlowLayout;	
	protected GridLayout personGridLayout;
	protected JTextArea textArea = new JTextArea();	
	protected JButton deleteButton, loadButton, saveButton, cleanButton;
	protected SelectMouseListener selectCountryMouseListener;
	protected DeleteMouseListener deleteFilterMouseListener;
	protected SaveMouseListener savePersonMouseListener;
	protected CleanMouseListener cleanTextMouseListener;
	protected JComboBox countryComboBox;
	protected JTable table;
	protected JScrollPane tableScrollPane;
	protected JLabel labelFirstName, labelLastName, labelEmail, labelGender, labelIpAddress, labelCountry;
	protected JTextField  textFieldFirstName, textFieldLastName, textFieldEmail, textFieldGender, textFieldIpAddress, textFieldCountry;
		
	Utilities Utilities_Obj = new Utilities();	
	ArrayList tableArrayList;
	String countryForCombo = new String();
	ArrayList CountryDistinct = new ArrayList();	
	
	public final String[] columns = {
			"FIRST NAME",
			"LAST NAME",
			"E-MAIL",
			"GENDER",
			"IP ADDRESS",
			"COUNTRY"			
	};
	
	final static int MAX_CHAR = 15;
	
	public GUI_Management() {
		
		tableArrayList = new ArrayList();		
		
		frame = new JFrame();
		frame.setTitle("Artificialy");
		frame.setPreferredSize(new Dimension(1360,720));
		
		// frame.addWindowListener(new EventWindow());
		
		mainPanel = new JPanel();
		centerPanel = new JPanel();
		tablePanel = new JPanel();
		//leftPanel = new JPanel();
		countryPanel = new JPanel();
		personPanel = new JPanel();
		statisticPanel = new JPanel();
		
		loadButton = new JButton();
		loadButton.setText("FILTER DATA");
		deleteButton = new JButton();
		deleteButton.setText("REMOVE FILTER");			
		saveButton = new JButton();
		saveButton.setText("SAVE");
		cleanButton = new JButton();
		cleanButton.setText("CLEAN");
		
		countryComboBox = new JComboBox();
		
		
		//I disable the possibility of editing the cells
		DefaultTableModel nonEditableModel = new DefaultTableModel() {
		
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int mColIndex) {
			   return false;
			}
		};		
		
		table = new JTable(nonEditableModel);
		tableScrollPane = new JScrollPane(table);
		
		//I disable the possibility of modifying the column's order
		table.getTableHeader().setReorderingAllowed(false);
		
		borderLayout = new BorderLayout();
		tableBorderLayout = new BorderLayout();
		centerAreaBorderLayout = new BorderLayout();
		countryBorderLayout = new BorderLayout();
		countryFlowLayout = new FlowLayout();
		countryFlowLayout.setAlignment(FlowLayout.LEFT);
		statisticFlowLayout = new FlowLayout();
		statisticFlowLayout.setAlignment(FlowLayout.RIGHT);
		personGridLayout = new GridLayout(7,2);					
		
		labelFirstName = new JLabel("Nome");
		labelLastName = new JLabel("Cognome"); 
		labelEmail = new JLabel("E-mail"); 
		labelGender = new JLabel("Gender");
		labelIpAddress= new JLabel("IP Address"); 
		labelCountry= new JLabel("Country"); 
		 
		textFieldFirstName = new JTextField(MAX_CHAR);
		textFieldLastName= new JTextField(MAX_CHAR);
		textFieldEmail= new JTextField(MAX_CHAR); 
		textFieldGender= new JTextField(MAX_CHAR); 
		textFieldIpAddress= new JTextField(MAX_CHAR); 
		textFieldCountry= new JTextField(MAX_CHAR); 
				
		selectCountryMouseListener = new SelectMouseListener(this);
		deleteFilterMouseListener = new DeleteMouseListener(this);
		savePersonMouseListener = new SaveMouseListener(this);
		cleanTextMouseListener = new CleanMouseListener(this);
	}
	
	public void CreateGUI() {
		
		//It loads the arraylist with the distinct countries, used to load the combobox
		for(int k=0; k < tableArrayList.size(); k++) {
			
			Hashtable currentLine = new Hashtable();			 
			
			currentLine = (Hashtable)tableArrayList.get(k);
			countryForCombo = (String)currentLine.get(columns[columns.length-1]);
			
			if (Utilities_Obj.StringIsPresent(countryForCombo,CountryDistinct)==false) {
				
				CountryDistinct.add(countryForCombo);
				countryComboBox.addItem(countryForCombo);
			}
			
		}		
		
		mainPanel.setLayout(borderLayout);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(centerAreaBorderLayout);
		//centerPanel.add(statisticPanel, BorderLayout.EAST);
		centerPanel.add(countryPanel, BorderLayout.WEST);
		centerPanel.add(personPanel, BorderLayout.EAST);		
		
		countryPanel.setLayout(countryFlowLayout);		 
		personPanel.setLayout(personGridLayout);
		//statisticPanel.setLayout(statisticFlowLayout);		
				
		countryPanel.add(countryComboBox);
		countryPanel.add(loadButton);
		countryPanel.add(deleteButton);
		
		personPanel.add(labelFirstName);
		personPanel.add(textFieldFirstName);
		
		personPanel.add(labelLastName);
		personPanel.add(textFieldLastName);	
		
		personPanel.add(labelEmail);
		personPanel.add(textFieldEmail);
		
        personPanel.add(labelGender);
        personPanel.add(textFieldGender);
        
        personPanel.add(labelIpAddress);
        personPanel.add(textFieldIpAddress);
        
        personPanel.add(labelCountry);				
		personPanel.add(textFieldCountry);	
		
		personPanel.add(cleanButton);
		personPanel.add(saveButton);
		
		tablePanel.setLayout(tableBorderLayout);
		tablePanel.add(table.getTableHeader(),BorderLayout.NORTH );
		tablePanel.add(tableScrollPane,BorderLayout.CENTER );	
		table.setFillsViewportHeight(true); 
		
		mainPanel.add(tablePanel,BorderLayout.NORTH);
		
		loadButton.addMouseListener(selectCountryMouseListener);		
		deleteButton.addMouseListener(deleteFilterMouseListener);
		saveButton.addMouseListener(savePersonMouseListener);
		cleanButton.addMouseListener(cleanTextMouseListener);
		
		frame.setContentPane(mainPanel);
	    frame.pack();
	    frame.setVisible(true);    	    
		
	}
	
	
	public void setArrayListToDisplay(ArrayList tableArrayList) {
		
		this.tableArrayList = tableArrayList;
	}
	
	
	public void fillTable(ArrayList dataToDisplay) {	
		
		DefaultTableModel tableModel = ((DefaultTableModel)table.getModel());
		
		//Insert the name of the columns in the table
		for(int i=0; i<columns.length; i++)
			tableModel.addColumn(columns[i]);
		
		//Insert data in the table
		insertData(dataToDisplay);
			
	}
	
	
	// Insert data in the table using data contained in the input Arraylist
	public void insertData(ArrayList dataToDisplay) {
		
		DefaultTableModel tableModel = ((DefaultTableModel)table.getModel());
		
        for(int i = 0; i<dataToDisplay.size(); ++i){
			
			Hashtable hashTableRow = (Hashtable)dataToDisplay.get(i);
			ArrayList tmpArrayList = new ArrayList();		  				
			
			for (int j=0; j< columns.length; j++) {
				
				tmpArrayList.add(hashTableRow.get(columns[j]));				
			}
		
			tableModel.addRow(tmpArrayList.toArray());	
        }
	}
	
	
	//Filter data to be shown in the table according the country.
	//The country is the input String "filterValue".
	//It returns an Arraylist containing data filtered.
	public ArrayList filterTable(String filterValue){
		
		ArrayList TableFiltered = new ArrayList();
		String CurrentCountry = new String();
		
		for(int i = 0; i<tableArrayList.size(); ++i){
			
			Hashtable hashTableRow = (Hashtable)tableArrayList.get(i);
			CurrentCountry = (String)hashTableRow.get(columns[columns.length-1]);
		
			if (CurrentCountry.equals(filterValue)){
				
				TableFiltered.add(hashTableRow);
				
			}
		
		}
		
		return TableFiltered;
	}
	
}
