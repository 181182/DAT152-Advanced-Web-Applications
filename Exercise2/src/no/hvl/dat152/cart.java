package no.hvl.dat152;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import com.sun.javafx.collections.MappingChange.Map;

import no.hvl.dat152.modell.Handlekurv;
import no.hvl.dat152.modell.Vare;

/**
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Handlekurv kurv;
	Vare vare[];
	HashMap<Vare, Integer> map;
	float sum;
	HttpSession sesjon;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		map = new HashMap<Vare, Integer>();
		sesjon = request.getSession(true);

		kurv = (Handlekurv) sesjon.getAttribute("handlekurv");
		// kurv = (Handlekurv) request.getSession().getAttribute("handlekurv");
		System.out.println(kurv.vare.toString());
		for (Vare v : kurv.vare) {

			if (!map.isEmpty()) {
				if (map.containsKey(v)) {
					int antall = map.get(v);
					antall++;
					map.put(v, antall);
				}
			} else if (!map.containsKey(v)) {
				map.put(v, 1);
			}
		}

		for (Entry<Vare, Integer> entry : map.entrySet()) {
			sum = sum + (entry.getValue() * entry.getKey().getPris());
		}

		request.setAttribute("sum", sum);
		request.setAttribute("map", map);
		request.getRequestDispatcher("/cart.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
