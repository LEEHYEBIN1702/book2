package co.micol.book.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.BookDao;
import co.micol.book.vo.BookVo;
import co.micol.common.Command;

public class BookList implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// �����뿩 �� �����ֱ�(����ٰ� memberid ���� �߰��� �޼ҵ� �ҷ�����)
		
				BookDao dao = new BookDao();
				ArrayList<BookVo> list = new ArrayList<BookVo>();
				list = dao.bookSelectList();
				
				request.setAttribute("list", list); 
				return "book/bookList";
	}

}
