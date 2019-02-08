package practice.awt.table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddButton implements ActionListener {

	JTable table;
	JTextField tfName;
	JTextField tfAge;
	JTextField tfSex;

	// �����ڿ��� table�� ��Ÿ ������ �Ѱ��ش�.
	public AddButton(JTable table, JTextField tfName, JTextField tfAge, JTextField tfSex) {
		this.table = table;
		this.tfName = tfName;
		this.tfAge = tfAge;
		this.tfSex = tfSex;
	}

	public void actionPerformed(ActionEvent e) {
		String str[] = new String[3];
		str[0] = tfName.getText();
		str[1] = tfAge.getText();
		str[2] = tfSex.getText();

		// �����ڷκ��� ���� table ��ü�� Ÿ���� �����Ѵ�.
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		// table�� object�� �߰��Ѵ�.
		model.addRow(str);
	}
}