package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MemberBean;
import jp.co.aforce.models.RegistrationModel;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration-servlett")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		// 文字のエンコードを UTF-8 とする。これがないと文字化け。
		request.setCharacterEncoding("UTF-8");

		// ユーザによって入力された情報を取り出す
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int birth_year = Integer.parseInt(request.getParameter("birth_year"));
		int birth_month = Integer.parseInt(request.getParameter("birth_month"));
		int birth_day = Integer.parseInt(request.getParameter("birth_day"));

		MemberBean memberBean = new MemberBean();
		memberBean.setName(name);
		memberBean.setAge(age);
		memberBean.setBirth_year(birth_year);
		memberBean.setBirth_month(birth_month);
		memberBean.setBirth_day(birth_day);

		RegistrationModel registrationModel = new RegistrationModel();

		int processingNumber = 0;

		processingNumber = registrationModel.insert(memberBean);

		if (processingNumber > 0) {

			request.setAttribute("msg", "登録に成功しました");
		} else {

			request.setAttribute("msg", "登録に失敗しました"
					+ "");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/registration.jsp");
		rd.forward(request, response);

	}
}
