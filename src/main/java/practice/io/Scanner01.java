package practice.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scanner01 {

	public static void main(String[] args) {

		try {

			// ������Ʈ ���� ��� ã��
			String projectPath = System.getProperty("user.dir");

			// ���� ��ü ����
			File file = new File(projectPath + "\\src\\main\\resources\\check.txt");

			// ��ĳ�� ����
			Scanner scanner = new Scanner(file);

			// ��ĳ���� ���� ���� ���� �� ���� ���
			while (scanner.hasNextLine()) {
				// ��ĳ�� ���� ���
				System.out.println(scanner.nextLine());
			}
		} catch (Exception exception) {
			System.out.println(exception);
		}

	}

}
