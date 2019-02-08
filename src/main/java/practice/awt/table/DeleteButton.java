package practice.awt.table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DeleteButton implements ActionListener {

	JTable table;

	// �����ڿ��� table�� ��Ÿ ������ �Ѱ��ش�.
	public DeleteButton(JTable table) {
		this.table = table;
	}

	public void actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		if (row >= 0) {
			// �����ڷκ��� ���� table ��ü�� Ÿ���� �����Ѵ�.
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			// table�� object�� �����Ѵ�.
			model.removeRow(row);
		}
	}
}