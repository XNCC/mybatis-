package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.User;

public class Test1 {

    public static void main(String[] args) throws IOException {
        //mybatis�������ļ�
        String resource = "conf.xml";
            //����sessionFactory�ЃɷN��ʽ  
                 //��һ�N
				        //ʹ�������������mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
				        //InputStream is = Test1.class.getClassLoader().getResourceAsStream(resource);
				        //����sqlSession�Ĺ���
				        // SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
				 //�ڶ��N       
				        //ʹ��MyBatis�ṩ��Resources�����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
				        Reader reader = Resources.getResourceAsReader(resource); 
				        //����sqlSession�Ĺ���
				        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //������ִ��ӳ���ļ���sql��sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * ӳ��sql�ı�ʶ�ַ�����
         * me.gacl.mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * getUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         */
        
        
// ��ԃ       
//        String statement = "dao_mapping.userMapping.getUser";//ӳ��sql�ı�ʶ�ַ���
//        //ִ�в�ѯ����һ��Ψһuser�����sql
//        User user = session.selectOne(statement, "�׻����");
//        System.out.println(user);
        
//����       
//        String statement = "dao_mapping.userMapping.addUser";//ӳ��sql�ı�ʶ�ַ���
//        User user = new User();
//        user.setName("�û��°�����");
//        user.setAge(20);
//        //ִ�в������
//        int retResult = session.insert(statement,user);
//        //�ֶ��ύ����
//        session.commit();
//        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
//        session.close();
//        System.out.println(retResult);
        
 //�޸�     
        //�޸Ĺ���߀����id�����ϲ�ԃ
//        String statement = "dao_mapping.userMapping.updateUser";//ӳ��sql�ı�ʶ�ַ���
//        User user = new User();
//        user.setId(3);
//        user.setName("�°�����");
//        user.setAge(25);
//        //ִ���޸Ĳ���
//        int retResult = session.update(statement,user);
//        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
//        session.commit();
//        session.close();
//        System.out.println(retResult);   
        
        
 //�h��  
//        String statement = "dao_mapping.userMapping.deleteUser";//ӳ��sql�ı�ʶ�ַ���
//        int retResult = session.delete(statement,3);
//        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
//        session.commit();
//        session.close();  
//        System.out.println(retResult);
        
//��ԃ����
        String statement = "dao_mapping.userMapping.getAllUsers";//ӳ��sql�ı�ʶ�ַ���
        List<User> lstUsers = session.selectList(statement);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        session.close();
        System.out.println(lstUsers);
        
    }
}