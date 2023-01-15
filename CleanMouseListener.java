package Artificialy;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CleanMouseListener implements MouseListener{

    GUI_Management GUI_ManagementObj;
	
	public CleanMouseListener(GUI_Management GUI_ManagementObj)
	{
		this.GUI_ManagementObj = GUI_ManagementObj;		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		clean();
		
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

	public void clean() {
		
		GUI_ManagementObj.textFieldFirstName.setText("");
		GUI_ManagementObj.textFieldLastName.setText("");
		GUI_ManagementObj.textFieldEmail.setText("");
		GUI_ManagementObj.textFieldGender.setText("");
		GUI_ManagementObj.textFieldIpAddress.setText("");
		GUI_ManagementObj.textFieldCountry.setText("");
		
	}
			
	
}
