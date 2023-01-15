package Artificialy;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IO_Management {
	
	private String path;
	private String FileName;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String FileName) {
		this.FileName = FileName;
	}
	
	//It reads a file and returns an arraylist
	public ArrayList ReadFIle() throws IOException, NullPointerException
	{
		ArrayList PersonInformation = new ArrayList();
		FileReader fr 		= null;
		BufferedReader br 	= null;
		try
		{
			//System.out.println(path+FileName);
			fr = new FileReader(path+FileName);
			br = new BufferedReader(fr);
			String linea;
			while( (linea = br.readLine()) != null)
			{				
				PersonInformation.add(linea);
			}
		}
		catch(IOException e)
		{
			throw new IOException(e);
		}
		finally
		{
			br.close();
		}
		return PersonInformation;
			
	}	

}
