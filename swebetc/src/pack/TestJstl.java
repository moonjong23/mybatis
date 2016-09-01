package pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestJstl")
public class TestJstl extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String irum = "마당쇠";
		request.setAttribute("man", irum);	//문자를 넘긴것
		
		Person person = new Person();	//사실은 init에서 생성해야함
		person.setName("한국인");
		request.setAttribute("person", person);	//객체를넘긴것
		
		Student student = new Student();
		student.setAge(20);
		request.setAttribute("student", student); //객체를넘긴것
		
		//문자열
		String[] ani = {"말", "강아지", "호랑이"};
		request.setAttribute("animal", ani);
		
		//collection
		String[] foods = {"당근", "사료", "동물"};
		List<Object> list = new ArrayList<>();
		list.add(ani);
		list.add(foods);
		request.setAttribute("list", list);	//콜렉션을 담은거
		
		request.getRequestDispatcher("testjstl.jsp").forward(request, response);	//서버에서 서버로 testjstl을 부름
	}

}
