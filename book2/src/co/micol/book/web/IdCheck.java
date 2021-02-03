package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.MemberDao;
import co.micol.common.Command;

public class IdCheck implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// ���̵� �ߺ�üũ
		
		MemberDao dao = new MemberDao();
		String id = request.getParameter("memberid");
		boolean bool = dao.isidCheck(id);
		String message = null;
		if(bool) {
			message = id + "��(��) ����� �� �ִ� ���̵� �Դϴ�.";
		}else {
			message = id + "��(��) ����� �� ���� ���̵� �Դϴ�.";
		}
		
		request.setAttribute("msg", message);
		request.setAttribute("check", bool);
		
		return "member/idCheck";
	}

}
