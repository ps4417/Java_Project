
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.inflearn.BookDTO;

public class Project01_A {

	public static void main(String[] args) {
		// Object(BookDTO) -> JSON(String)
		BookDTO dto = new BookDTO("자바",21000,"에이비",670);
		Gson g = new Gson();
		String json = g.toJson(dto);
		System.out.println(json);
		
		// JSON(String) -> Object(BookDTO)
		BookDTO dto1 = g.fromJson(json, BookDTO.class);
		System.out.println(dto1);
		
		// Object(List<BookDTO>) -> JSON(String) : [{  },{  } ....]
		List<BookDTO> lst = new ArrayList<BookDTO>();
		lst.add(new BookDTO("자바1",21000,"에이비1",570));
		lst.add(new BookDTO("자바2",31000,"에이비2",670));
		lst.add(new BookDTO("자바3",11000,"에이비3",370));
		
		String lstJson = g.toJson(lst);
		System.out.println(lstJson);
		
		// JSON(String) -> Object(List<BookDTO>)
		List<BookDTO> lst1 = g.fromJson(lstJson, new TypeToken<List<BookDTO>>(){}.getType());
		for(BookDTO vo : lst1) {
			System.out.println(vo);
		}
	}

}
