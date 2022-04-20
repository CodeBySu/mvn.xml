package com.suhuan.test;
import com.suhuan.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {
	private SqlSession sqlSession = null;
    @Before
    public void init(){
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();//建造者
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = ssfb.build(resourceAsStream);//建造者建造的汽车厂,传入的值是IO流对象，指向sqlMapConfig.xml(相当于图纸)
        sqlSession = factory.openSession();//汽车厂生产的车
    }
    @Test//来自于pom.xml中的Junit单元测试工具
    public void testFindAll(){
        //调用SQL语句：
        List<Emp> list = sqlSession.selectList("findEmp");//返回的都是Dept对象装入到list集合里面
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    @After
    public void release(){
        //关闭SQLSession
        sqlSession.close();
    }
}
