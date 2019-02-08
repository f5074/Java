package practice.awt.table02;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTable;

public class TableEx {

	public static void main(String[] args) {
		
		Frame f = new Frame();
		String[] columnType = { "��ȣ", "�̸�", "����", "����"};

		Object[][] data = {

		       {"1", "��ö��", "20", "����"},

		       {"2", "�����", "43", "����"},

		       {"3", "�̼���", "100", "����"},

		       {"4", "������", "18", "����"},

		       {"5", "�� ��", "54", "����"}

		};

		JTable table = new JTable(data, columnType);
		
		// ���� �̺�Ʈ
		f.addWindowListener(new WindowAdapter(){
			  public void windowClosing(WindowEvent we){
			    System.exit(0);
			  }
		});
		
		f.add(table);
		f.setVisible(true);
		f.pack();
	}

}
