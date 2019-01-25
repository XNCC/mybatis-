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
        //mybatis的配置文件
        String resource = "conf.xml";
            //創建sessionFactory有兩種方式  
                 //第一種
				        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
				        //InputStream is = Test1.class.getClassLoader().getResourceAsStream(resource);
				        //构建sqlSession的工厂
				        // SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
				 //第二種       
				        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
				        Reader reader = Resources.getResourceAsReader(resource); 
				        //构建sqlSession的工厂
				        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        
        
// 查詢       
//        String statement = "dao_mapping.userMapping.getUser";//映射sql的标识字符串
//        //执行查询返回一个唯一user对象的sql
//        User user = session.selectOne(statement, "白虎神皇");
//        System.out.println(user);
        
//插入       
//        String statement = "dao_mapping.userMapping.addUser";//映射sql的标识字符串
//        User user = new User();
//        user.setName("用户孤傲苍狼");
//        user.setAge(20);
//        //执行插入操作
//        int retResult = session.insert(statement,user);
//        //手动提交事务
//        session.commit();
//        //使用SqlSession执行完SQL之后需要关闭SqlSession
//        session.close();
//        System.out.println(retResult);
        
 //修改     
        //修改功能還是在id功能上查詢
//        String statement = "dao_mapping.userMapping.updateUser";//映射sql的标识字符串
//        User user = new User();
//        user.setId(3);
//        user.setName("孤傲苍狼");
//        user.setAge(25);
//        //执行修改操作
//        int retResult = session.update(statement,user);
//        //使用SqlSession执行完SQL之后需要关闭SqlSession
//        session.commit();
//        session.close();
//        System.out.println(retResult);   
        
        
 //刪除  
//        String statement = "dao_mapping.userMapping.deleteUser";//映射sql的标识字符串
//        int retResult = session.delete(statement,3);
//        //使用SqlSession执行完SQL之后需要关闭SqlSession
//        session.commit();
//        session.close();  
//        System.out.println(retResult);
        
//查詢所有
        String statement = "dao_mapping.userMapping.getAllUsers";//映射sql的标识字符串
        List<User> lstUsers = session.selectList(statement);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        session.close();
        System.out.println(lstUsers);
        
    }
}