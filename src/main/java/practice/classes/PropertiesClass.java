package practice.classes;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesClass {
	public static String url;
	public static String id;
	public static String password;
	
	public PropertiesClass() {
		
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
	}

}
