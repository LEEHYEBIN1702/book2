package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.common.Command;

public class MemberJoinForm implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// ȸ������ ������ �̵�
		return "member/memberJoinForm";
	}

}
