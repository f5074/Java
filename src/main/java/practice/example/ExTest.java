package practice.example;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ExTest {
	static ActionBtn action = new ActionBtn();
	static Frame f = new Frame();
	static Panel p3 = new Panel();
	static Button[] btn = new Button[4];

	public static void main(String[] args) {
		btn[0] = new Button("��ȸ");
		btn[1] = new Button("�߰�");
		btn[2] = new Button("����");
		btn[3] = new Button("����");
		for (int i = 0; i < 4; i++) {
			btn[i].addActionListener(action);
			p3.add(btn[i]);
		}
		
		Panel p2 = new Panel();
		p2.add(p3);
		f.add(p2);
		
		
		f.setVisible(true);
		f.pack();
		


	}

}

class ActionBtn extends Exception implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("��ȸ")) {
			try {
				System.out.println("��ȸ");
				JOptionPane.showMessageDialog(null, "��ȸ");
				
			} catch (Exception exception) {
				System.err.println(exception.getMessage());
				
			}
		}  else if (e.getActionCommand().equals("����")) {
			try {
				System.out.println("����");
				JOptionPane.showMessageDialog(null, "����");
			} catch (Exception exception) {
				System.err.println(exception.getMessage());
			}


		}
	}
}
