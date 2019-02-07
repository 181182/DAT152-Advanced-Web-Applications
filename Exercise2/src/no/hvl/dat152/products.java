package no.hvl.dat152;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat152.modell.Handlekurv;
import no.hvl.dat152.modell.Vare;

/**
 * Servlet implementation class prodicts
 */
@WebServlet("/products")
public class products extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Handlekurv handlekurv = new Handlekurv();
	HttpSession sesjon;
	Vare vare[];

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public products() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// sesjon = request.getSession(true);
		vare = (Vare[]) request.getSession().getAttribute("vare");
		request.setAttribute("vare", request.getSession().getAttribute("vare"));
		System.out.println(request.getSession().getAttribute("vare"));
		request.setAttribute("handlekurv", handlekurv);
		sesjon = request.getSession(true);
		sesjon.setAttribute("handlekurv", handlekurv);
		request.getRequestDispatcher("/products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String varenavn = request.getParameter("verdi");
		for (Vare v : vare) {
			if (v.getNavn().equals(varenavn)) {
				handlekurv.addVare(v);
			}

		}
		sesjon = request.getSession(true);
		sesjon.setAttribute("handlekurv", handlekurv);
		request.setAttribute("handlekurv", handlekurv);

		response.sendRedirect("products");
	}

}
