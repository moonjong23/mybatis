package pack;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		ProcessDao dao = ProcessDao.getInstance();
		
		try {
			System.out.println("전체 자료 읽기---");
			List<DataDto> list = dao.selectdataAll();	//읽어서 list로 반환
			for(DataDto s:list){
				System.out.println(s.getCode() + "" +
								s.getSang() + "" +
								s.getSu() + " " +
								s.getDan());
			}
		} catch (Exception e) {
			System.out.println("err: e");
		}
	}
}
