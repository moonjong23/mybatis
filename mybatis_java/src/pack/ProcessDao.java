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
	
	public DataDto selectDataPart(String arg) throws SQLException{
		SqlSession sqlSession = factory.openSession();
		DataDto dto = sqlSession.selectOne("selectDataById", arg);
		sqlSession.close();
		
		return dto;
	}
	
	public void insertData(DataDto dto) throws SQLException{
		SqlSession sqlSession = factory.openSession(); //수동
		//SqlSession sqlSession = factory.openSession(true); //auto commit
		int re;
		re = sqlSession.insert("insertData", dto);
		//System.out.println("re : " + re);
		sqlSession.commit(); //sqlSession.rollback();
		sqlSession.close();
	}
	
	public void updateData(DataDto dto) throws SQLException{
		SqlSession sqlSession = factory.openSession(true);
		sqlSession.update("updateData", dto);
		//sqlSession.commit();
		sqlSession.close();
	}
	
	public boolean deleteData(int arg){
		SqlSession sqlSession = factory.openSession();
		boolean b = false;
		try {
			int cou = sqlSession.delete("deleteData", arg);
			if(cou > 0) b =  true;
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("deleteData err: " + e);
			sqlSession.rollback();
		}finally{
			if(sqlSession != null) sqlSession.close();
		}		
		return b;
	}
}



















