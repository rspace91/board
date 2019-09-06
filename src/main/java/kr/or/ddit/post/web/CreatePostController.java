package kr.or.ddit.post.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/postForm")
public class CreatePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int boardno = Integer.parseInt(request.getParameter("boardno"));

		request.setAttribute("boardno", boardno);

		request.getRequestDispatcher("/post/postForm.jsp").forward(request, response);
	}

}
