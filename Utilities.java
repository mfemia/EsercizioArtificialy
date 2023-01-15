package Artificialy;

import java.util.ArrayList;
import java.util.Hashtable;

public class Utilities {

	public ArrayList getSplitData(ArrayList DataToSplit, int numColumn) {
				
		String linea = new String();
		String[] singleLine = new String[numColumn];
		ArrayList infoPeople = new ArrayList();		
		String[] header = new String[numColumn];
		
		// I get the header of the file and I put it in a vector of String
		header = SplitData((String)DataToSplit.get(0),numColumn);
		
		// I begin from i=1 in order to exclude the header
		for(int i = 1; i< DataToSplit.size(); ++i) {			
			
			Hashtable hs = new Hashtable();
			linea = (String)DataToSplit.get(i);
			
			// to Split of a single data line
			singleLine = SplitData(linea,numColumn);
			
			// I insert data in an hashtable
			hs=BuildHashtable(header, singleLine);
			
			infoPeople.add(hs);			
			
			
		}
		
		return infoPeople;
	}	
	
	
	// It splits a string into an array of strings according to a separator
	public String[] SplitData(String DataToSplit,int numColumn) {	
		
		final char separator = ',';		
		String[] singleLine = new String[numColumn];	
		String line = new String();
		int j=0;
		
		for(int i = 0; i< numColumn; ++i)
			singleLine[i]="";
			
			
		for(int k = 0; k< numColumn; ++k) {			
				
			while(j<DataToSplit.length()) {
				
				if (DataToSplit.charAt(j) != separator) {
				
					singleLine[k] = singleLine[k] + DataToSplit.charAt(j);				    
				    j++;
				}
				else {					
					
					j++;
				    break;
				}
				
			}							
					
		}
		
		return singleLine;
	}
		
		
	// It builds an hashtable using "header" as key and "dataForHashtable" as value
    public Hashtable BuildHashtable(String[] header, String[] dataForHashtable) {
    	
    	Hashtable hs2 = new Hashtable();
    	
    	for(int i=0; i<header.length; i++) {
    	
    		//System.out.println(header[i]);
    		hs2.put(header[i],dataForHashtable[i]);	    		
    	
    	}
    	
    	return hs2;
    }

    //It looks if the string "StringToFind" is contained in the arraList of strings "ArrayListToInspect" 
    //and returns TRUE if it was contained, FALSE otherwise
    public Boolean StringIsPresent(String StringToFind, ArrayList ArrayListToInspect) {
    	
    	Boolean isPresent = false;      	
    	
    	for(int i=0; i<ArrayListToInspect.size(); i++) { 		  	    
    	    
    	    if (StringToFind.equals((String)ArrayListToInspect.get(i))) {	
    	    	isPresent = true;
    	    }
    		
    	}
    	
    	return isPresent;
    }
}
	

