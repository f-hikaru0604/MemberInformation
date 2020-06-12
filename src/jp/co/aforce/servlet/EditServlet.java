package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.models.EditModel;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");

		String member_no = request.getParameter("member_no");
		String name = request.getParameter("name");
		String age0 = request.getParameter("age");
		String birth_year0 = request.getParameter("birth_year");
		String birth_month0 = request.getParameter("birth_month");
		String birth_day0 = request.getParameter("birth_day");

		try {
			int age = Integer.parseInt(age0);
			int birth_year = Integer.parseInt(birth_year0);
			int birth_month = Integer.parseInt(birth_month0);
			int birth_day = Integer.parseInt(birth_day0);

			MemberBean memberBean = new MemberBean();
			memberBean.setMember_no(member_no);
			memberBean.setName(name);
			memberBean.setAge(age);
			memberBean.setBirth_year(birth_year);
			memberBean.setBirth_month(birth_month);
			memberBean.setBirth_day(birth_day);

			EditModel editModel = new EditModel();

			int processingNumber = 0;

			processingNumber = editModel.update(memberBean);

			if (processingNumber > 0) {

				request.setAttribute("msg", "変更に成功しました");
			} else {

				request.setAttribute("msg", "変更に失敗しました");
			}
			RequestDispatcher rd = request.getRequestDispatcher("/views/edit.jsp");
			rd.forward(request, response);

		} catch (NumberFormatException e) {
			request.setAttribute("msg", "登録に失敗しました");
			RequestDispatcher rd = request.getRequestDispatcher("/views/edit.jsp");
			rd.forward(request, response);
		}
	}

}
