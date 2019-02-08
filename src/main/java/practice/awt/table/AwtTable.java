package practice.awt.table;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AwtTable {

	public static void main(String[] args) {

		JFrame frame = new JFrame("������ ���");
		frame.setPreferredSize(new Dimension(500, 300));
		frame.setLocation(500, 400);

		Container contentPane = frame.getContentPane();

		String colNames[] = { "�̸�", "����", "����" };
		// Data�� ���� Default Table�� �����. column�� �ֱ� ������ �Ʒ��� ���� ����.
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		// spring table ����
		JTable table = new JTable(model);
		// scrollpanel�� �߰�
		JScrollPane scrollpane = new JScrollPane(table);
		// table�� frame�� �߰�
		contentPane.add(scrollpane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		JTextField tfName = new JTextField(6);
		JTextField tfAge = new JTextField(3);
		JTextField tfSex = new JTextField(2);

		JButton btAdd = new JButton("Add");
		JButton btDel = new JButton("Del");

		// �̺�Ʈ�� ó���� class ��ü�� �����Ѵ�.
		AddButton adaction = new AddButton(table, tfName, tfAge, tfSex);
		DeleteButton rmaction = new DeleteButton(table);
		// �̺�Ʈ ó�� ��ü�� �����Ѵ�.
		btAdd.addActionListener(adaction);
		btDel.addActionListener(rmaction);

		panel.add(new JLabel(colNames[0]));
		panel.add(tfName);
		panel.add(new JLabel(colNames[1]));
		panel.add(tfAge);
		panel.add(new JLabel(colNames[2]));
		panel.add(tfSex);

		panel.add(btAdd);
		panel.add(btDel);

		// table�� frame�� �߰�
		contentPane.add(panel, BorderLayout.SOUTH);

		// ���α׷� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame�� ȭ�鿡 �� �µ��� ó��
		frame.pack();
		// ȭ�鿡 ǥ��
		frame.setVisible(true);
	}

} 