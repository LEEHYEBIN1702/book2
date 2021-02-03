package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.BookDao;
import co.micol.book.dao.BookRentalDao;
import co.micol.book.vo.BookRentalVo;
import co.micol.book.vo.BookVo;
import co.micol.common.Command;

public class BookReturn implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// ���� �ݳ��ϱ�
		
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		BookRentalDao rdao = new BookRentalDao();
		BookRentalVo rvo = new BookRentalVo();
		
		vo.setBookcode(request.getParameter("bookcode"));
		vo.setBcount(Integer.parseInt(request.getParameter("bcount")));
		System.out.println("���� ����" + request.getParameter("bcount"));
		rvo.setBookcode(request.getParameter("bookcode"));
		
		int n = dao.bookUpdate2(vo);
		System.out.println("�ݳ� : " + n);
		
		if(n != 0) {
			n = rdao.rentalUpdate(rvo);
		}
		System.out.println("���� ���� �� �ݳ� : " + n);
		String viewPage;
		
		if(n == 0) {
			viewPage ="book/bookReturnFail";
		} else {
			viewPage = "bookReturnForm.do";
		}
		
		return viewPage;
	}

}
