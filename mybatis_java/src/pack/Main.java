package pack;

import java.util.List;


public class Main {
	public static void main(String[] args) {
		ProcessDao dao = ProcessDao.getInstance();
		
		try {
			System.out.println("자료 추가 ------");
			/*DataDto dataDto = new DataDto();
			dataDto.setCode("100");
			dataDto.setSang("초코우유");
			dataDto.setSu("5");
			dataDto.setDan("2000");
			dao.insertData(dataDto);*/
System.out.println();
			
			System.out.println("자료 수정 ------");
			DataDto dataDto = new DataDto();
			dataDto.setCode("100");
			dataDto.setSang("바나나우유");
			dao.updateData(dataDto);
System.out.println();
			
			System.out.println("자료 삭제 ------");
			boolean b = dao.deleteData(6);
			if(b){
				System.out.println("삭제 성공");
			}else{
				System.out.println("삭제 실패");
			}
			
System.out.println();
			
			System.out.println("전체 자료 읽기---");
			List<DataDto> list = dao.selectdataAll();	//읽어서 list로 반환
			for(DataDto s:list){
				System.out.println(s.getCode() + " " +
								s.getSang() + " " +
								s.getSu() + " " +
								s.getDan());
			}
			
			System.out.println("\n부분 자료 읽기------");
			DataDto s = dao.selectDataPart("1");
			
			System.out.println(s.getCode() + " " +
					s.getSang() + " " +
					s.getSu() + " " +
					s.getDan());
			
			System.out.println();
			System.out.println();
		} catch (Exception e) {
			System.out.println("err: e");
		}
	}
}
