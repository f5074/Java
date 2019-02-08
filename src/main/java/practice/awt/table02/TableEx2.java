package practice.awt.table02;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;

/**
 * Created by with2J on 2017-07-21.
 */
public class TableEx2 extends JFrame implements TableModelListener {

    public static void main(String[] args)
    {
        new TableEx2();
    }

    //FIELDS
    private JTable table;
    private JScrollPane scrollPane;
    private String[] columnType = { "��ȣ", "�̸�", "����", "����"};
    private Object[][] data = {
            {"1", "��ö��", "20", "����"},
            {"2", "�����", "43", "����"},
            {"3", "�̼���", "100", "����"},
            {"4", "������", "18", "����"},
            {"5", "�� ��", "54", "����"}
    };

    //CONSTRUCTOR
    TableEx2()
    {
        super("JTable Test!"); //setTitle() �� ����
        setSize(500, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        table = new JTable(data, columnType);
        scrollPane = new JScrollPane(table);

        table.setPreferredScrollableViewportSize(new Dimension(500, 300));
        table.setFillsViewportHeight(true);

        table.getModel().addTableModelListener(this); // ���̺� �Ҽӵ� �ϳ��� ���� ������ �����ϹǷ� �׻� getModel() �� ȣ���ؾ���
        table.setAutoCreateRowSorter(true); //�ڵ� �� ���ı��

        //���� �÷��� ������ �������� �߰��� �� �ֵ��� �����Ѵ�.
        TableColumn genderColumn = table.getColumn("����");
        JComboBox gender = new JComboBox();
        gender.addItem("����");
        gender.addItem("����");
        genderColumn.setCellEditor(new DefaultCellEditor(gender));

        add(scrollPane);
        setVisible(true);
    }

//    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();

        if (column == 2) { // �÷���ȣ�� 2�̸� "����" �÷��̴�. �÷��ε����� 0���� �����Ѵ�.
            TableModel model = (TableModel) e.getSource();
            String colName = model.getColumnName(column); //�ش� �ε����� �÷��̸��� �޾ƿ´�.
            String str = (String) model.getValueAt(row, column); // data�� object Ÿ���̹Ƿ� ����ȯ�ؾ� �Ѵ�.
            if (Integer.parseInt(str) > 100) { //�Է��� ���̰��� 100�� ���� ���, ���â�� ����.
                JOptionPane.showMessageDialog(this, "���� ������ �ʰ��Ͽ����ϴ�. 100 �̸����� �Է����ּ���.", "���",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}