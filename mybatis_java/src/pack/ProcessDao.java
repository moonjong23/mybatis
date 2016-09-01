package pack;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ProcessDao {
	private static ProcessDao dao = new ProcessDao();
	
	public static ProcessDao getInstance(){
		return dao;
	}
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List selectdataAll() throws SQLException{
		SqlSession sqlSession = factory.openSession();	//session(작업단위) 열어준거
		List list = sqlSession.selectList("selectDataAll"); //DataMappe의 id를 읽기
		sqlSession.close();
		return list;
	}
}
