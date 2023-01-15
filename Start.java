package Artificialy;

import java.util.ArrayList;
import java.util.Hashtable;

public class Start {

	public static void main(String[] args) {
		
		final String[] columnsToDisplay = {
			"FIRST NAME",
			"LAST NAME",
			"E-MAIL",
			"GENDER", 
			"IP ADDRESS",
			"COUNTRY"			
		};
		
		
		IO_Management IO_Management_Obj = new IO_Management();
		Utilities Utilities_Obj = new Utilities();
		GUI_Management guiManagementObj = new GUI_Management();
		
		int numColumnCountries = 3;
		int numColumnPeople = 6;
		String[] CountryHeader = new String[numColumnCountries];
		String[] PeopleHeader = new String[numColumnPeople];
		ArrayList FileCountries = new ArrayList();
		ArrayList FilePeople = new ArrayList();
		
		ArrayList InfoCountries = new ArrayList();
		ArrayList InfoPeople = new ArrayList();
		ArrayList dataNotFilteredToDisplay = new ArrayList();		
		
		
		IO_Management_Obj.setPath("C:\\Users\\Marco\\Downloads\\esercizio_libero\\esercizio_libero\\data\\");
		IO_Management_Obj.setFileName("countries.csv");
	    
		//I read country file
		try {
			FileCountries = IO_Management_Obj.ReadFIle();
		} catch (Exception e) {
			System.out.println("File non trovato");
			return;
		}
		
		//I read people file
        IO_Management_Obj.setFileName("persons.csv");
	    
		try {
			FilePeople = IO_Management_Obj.ReadFIle();
		} catch (Exception e) {
			System.out.println("File non trovato");
			return;
		}		
		
		
		//I get the header of the two files
		CountryHeader = Utilities_Obj.SplitData((String)FileCountries.get(0), numColumnCountries);
		PeopleHeader = Utilities_Obj.SplitData((String)FilePeople.get(0), numColumnPeople);
						
		//I split each file (according to the separator) and I put the output in an arraylist of hashtables
		InfoPeople = Utilities_Obj.getSplitData(FilePeople, numColumnPeople);		
		InfoCountries = Utilities_Obj.getSplitData(FileCountries,numColumnCountries);		
		
		//I build the hashtables only with the information I want to show (taking the information from the 
		//just built arraylists of people and countries) and I add them to an arraylist
		for(int i = 0; i< InfoPeople.size(); ++i) {
		
			Hashtable person = new Hashtable();
			Hashtable country = new Hashtable();
			Hashtable infoToDisplay = new Hashtable();
			String countryForCombo = new String();
			
			person = (Hashtable)InfoPeople.get(i);
			country = (Hashtable)InfoCountries.get(i);				
			
			for(int j = 1; j< (PeopleHeader.length) ; ++j)		
				infoToDisplay.put(columnsToDisplay[j-1],person.get(PeopleHeader[j]));
		    
			
			infoToDisplay.put(columnsToDisplay[columnsToDisplay.length-1],country.get(CountryHeader[CountryHeader.length-1]));
			
			dataNotFilteredToDisplay.add(infoToDisplay);			
			
		}			
			
		guiManagementObj.setArrayListToDisplay(dataNotFilteredToDisplay);
		guiManagementObj.CreateGUI();
		guiManagementObj.fillTable(dataNotFilteredToDisplay);				
		
	}		
}  
	
	    

	
