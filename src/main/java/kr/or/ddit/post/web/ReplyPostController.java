package kr.or.ddit.post.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/replyPost")
public class ReplyPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postNo = request.getParameter("postNo"); //게시글 번호
		String boardNo = request.getParameter("boardNo");
		String postGn = request.getParameter("postGn");

		request.setAttribute("postNo", postNo);
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("postGn", postGn);

		request.getRequestDispatcher("/post/postForm.jsp").forward(request, response);
	}

}
