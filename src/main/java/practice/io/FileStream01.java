package practice.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileStream01 {

	public static final String filePath = "C:\\DEV\\";

	public static void main(String[] args) throws IOException {

		try {
			
			// ������Ƽ ��ü ����
			Properties properties = new Properties();
			
			// ������Ʈ ��� ã��
			String projectPath = System.getProperty("user.dir");
			// ���� �б�
			properties.load(new FileInputStream(projectPath + "\\src\\main\\resources\\server.ini"));

			// ������Ƽ �� �б�
			System.out.println(properties.getProperty("url"));
			System.out.println(properties.getProperty("id"));
			System.out.println(properties.getProperty("password"));

			// ������Ƽ �� ����
			properties.setProperty("key", "value");

			// ������Ƽ ����Ʈ ���
			properties.list(System.out);

			// ���� ����
			properties.store(new FileOutputStream(filePath + "server.ini"),null);
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
