package practice.example;
import java.awt.*;
import java.awt.event.*;

class Exam_03_sub extends Frame {

	public void paint(Graphics g) {
		// ���� �⺻���� ����
		g.drawLine(50, 50, 100, 100); // �⺻ ��
		g.setColor(Color.BLUE); // �� ���ĺ��� �׸��� �� �Ķ���
		g.drawRect(50, 50, 100, 100); // �簢�� �׸���
		g.setColor(Color.RED); // �� ���ĺ��� ���� ����
		g.fillRect(200, 50, 100, 100); // �ȿ� ��ä�� �簢��
		g.drawOval(50, 50, 100, 100); // �� �׸���
		g.setColor(Color.BLACK);
		int x[] = new int[] { 170, 230, 140 };
		int y[] = new int[] { 170, 210, 200 };
		g.fillPolygon(x, y, 3); // �ٰ��� �׸���
		g.setColor(Color.GREEN);
		g.setFont(new Font("", Font.BOLD, 15));
		g.drawString("�ȳ��ϼ���!", 50, 200);

		Image img = Toolkit.getDefaultToolkit().getImage("C:\\dev\\sun.jpg");// �����
		g.drawImage(img, 230, 180, 80, 80, this); // ������ġ�� ��� (this)
	}

	Exam_03_sub(String title) {

		super(title); // �����ڸ� ���� Ÿ��Ʋ ����
		super.setSize(400, 300);

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int) (screen.getWidth() / 2) - super.getWidth() / 2;
		int ypos = (int) (screen.getHeight() / 2) - super.getHeight() / 2;

		super.setLocation(xpos, ypos);
		super.setResizable(false);
		super.setVisible(true);
	}

}

public class Exam_03 {

	public static void main(String[] args) {
		Exam_03_sub ex = new Exam_03_sub("awt �ǽ� Ÿ��Ʋ");
	}

}
