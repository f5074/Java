package practice.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {

	public static void main(String[] args) {

		String res = "practice/mybatis/config.xml";

		try {
			
//            // mybatisȯ�� ���� ������ �о���� ���� ��Ʈ�� ��ü
//            InputStream is = Resources.getResourceAsStream(res);
//
//            //SqlSessionFactory ��ü ������
//            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
//
//            //sql������ ȣ���ϴ� sqlSession��ü ������
//            SqlSession session = factory.openSession();
//            MemberVo vo = new MemberVo("batis1","1111","batis@co.kr","010", null);
//
//            //insert("ȣ���� sql���� id", �Ķ���Ͱ�ü );
//            int n=session.insert("add", vo); //xml�� insert�±� id, �Ķ����
//
//            if(n>0){
//                //Ŀ���ϱ�
//                session.commit();
//                System.out.println("�߰� ����");
//            }else{
//                session.rollback();
//                System.out.println("�߰� ����");
//            }

			
//			InputStream is = Resources.getResourceAsStream(res);
//			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//			SqlSession session = factory.openSession();
//            int n = session.delete("remove", "batis1");
//            System.out.println("delete ó���Ǽ�:" + n);            
//            session.commit();

			
						
			InputStream is = Resources.getResourceAsStream(res);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			List<MemberVo> list = session.selectList("getlist");
			for (MemberVo vo : list) {
				System.out.println("id:" + vo.getId());
				System.out.println("pwd:" + vo.getPwd());
				System.out.println("email:" + vo.getEmail());
				System.out.println("phone:" + vo.getPhone());
				System.out.println("regdate:" + vo.getregdate());
				System.out.println();

			}
//			String findId = "batis1";
//			MemberVo vo1 = session.selectOne("find", findId);
//			if (vo1 == null) {
//				System.out.println("�˻��� ȸ���� �����!");
//			} else {
//				System.out.println("id:" + vo1.getId());
//				System.out.println("pwd:" + vo1.getPwd());
//				System.out.println("email:" + vo1.getEmail());
//				System.out.println("phone:" + vo1.getPhone());
//				System.out.println("regdate:" + vo1.getregdate());
//				System.out.println();
//			}
//
//			HashMap<String, Object> map = session.selectOne("practice.mybatis.memberMapper.getInfo", "batis2");
//			// key : Į����, value : ����.
//			String id = (String) map.get("id");
//			String pwd = (String) map.get("pwd");
//			String email = (String) map.get("email");
//			String phone = (String) map.get("phone");
//			Timestamp regdate = (Timestamp) map.get("regdate");
//			System.out.println("[[  ���� �˻� (map ���)  ]]");
//			System.out.println("id:" + id);
//			System.out.println("pwd:" + pwd);
//			System.out.println("email:" + email);
//			System.out.println("phone:" + phone);
//			System.out.println("regdate:" + regdate);
			session.close();

		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
	}

}
