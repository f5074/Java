package practice.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Awt02 {
	private static String url;
	private static String id;
	private static String password;
	private static Frame frame = new Frame();
	private static Label[] label = new Label[7];
	private static TextField[] textField = new TextField[7];
	private static Panel[] panel = new Panel[7];

	public static void main(String[] args) {

		// 1. Github�� �ø� ��� �ڽ��� ���������� ������� �ʵ��� �׻� ����
		// 2. ���̵�� ��й�ȣ ������ ���� ���� �����ϱ� ���� ���
		try {

			// ������Ƽ ��ü ����
			Properties properties = new Properties();

			// ���� �б�
			properties.load(new FileInputStream("C:\\DEV\\server.ini"));

			// ������Ƽ �� �б�
			url = properties.getProperty("url");
			id = properties.getProperty("id");
			password = properties.getProperty("password");

		} catch (Exception exception) {

			System.err.println(exception);
			// ������ ���� ��쳪 ���� �߻� �� url, id, password �⺻ ��
			url = "jdbc:mysql://127.0.0.1:3306/university?characterEncoding=UTF-8&serverTimezone=UTC";
			id = "root";
			password = "1234";
		}


//		label[0] = new Label("no");
//		label[1] = new Label("grade");
//		label[2] = new Label("subject");
//		label[3] = new Label("professor");
//		label[4] = new Label("year");
//		label[5] = new Label("semester");
//		label[6] = new Label("count");
		
		
		String[] labelName = new String[] {"no","grade","subject","professor","year","semester","count"};

		for (int i = 0; i < label.length; i++) {
			panel[i] = new Panel();
			label[i] = new Label(labelName[i]);
			textField[i] = new TextField(20);
			panel[i].add(label[i]);
			panel[i].add(textField[i]);
			
		}
		



//		TextField text1 = new TextField(20);
//		TextField text2 = new TextField(20);
//		TextField text3 = new TextField(20);
//		TextField text4 = new TextField(20);
//		TextField text5 = new TextField(20);
//		TextField text6 = new TextField(20);
//		TextField text7 = new TextField(20);
		
//		for (int i = 0; i < textField.length; i++) {
//			textField[i] = new TextField(20);
//		}
		

//		Panel[] panel = new Panel[7];
//		for (int i = 0; i < panel.length; i++) {
//			panel[i].add(label[i]);
//			panel[i].add(textField[i]);
//			Npanel.add(panel[i]);
//		}	
		
		Button button = new Button("Insert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connect = DriverManager.getConnection(url, id, password);

					String sql = "INSERT INTO problemm(no,grade,subject,professor,year,semester,count) VALUES (?,?,?,?,?,?,?)";
					PreparedStatement pstmt = connect.prepareStatement(sql);

					pstmt.setString(1, textField[0].getText());
					pstmt.setString(2, textField[1].getText());
					pstmt.setString(3, textField[2].getText());
					pstmt.setString(4, textField[3].getText());
					pstmt.setString(5, textField[4].getText());
					pstmt.setString(6, textField[5].getText());
					pstmt.setString(7, textField[6].getText());

					int result = pstmt.executeUpdate();
					
					if (result != 0) {
						System.out.println("����");
						JOptionPane.showMessageDialog(null, "����");
					} else {
						System.out.println("����");
						JOptionPane.showMessageDialog(null, "����");
					}

				} catch (Exception exception) {
					System.err.println(exception);
				}
			}
		});

		Panel Npanel = new Panel(new GridLayout(4, 3));
		Npanel.add(panel[0]);
		Npanel.add(panel[1]);
		Npanel.add(panel[2]);
		Npanel.add(panel[3]);
		Npanel.add(panel[4]);
		Npanel.add(panel[5]);
		Npanel.add(panel[6]);
		Npanel.add(button);
		frame.add(Npanel);

		// ���� �̺�Ʈ
		frame.addWindowListener(new WindowAdapter(){
			  public void windowClosing(WindowEvent we){
			    System.exit(0);
			  }
		});
		frame.setVisible(true);
		frame.pack();
	}
}
