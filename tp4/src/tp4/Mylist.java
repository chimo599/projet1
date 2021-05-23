package tp4;


import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JList;

public class Mylist extends JList  {
	
	@Override
	public String getToolTipText(MouseEvent event) {
		int n=this.locationToIndex(new Point(event.getX(),event.getY()));
		if (n>=0) {
			Contact c =Test_Event.data.get(n);
		    return (c.nom+" "+c.prenom) ;
	}
		return null;

}}
