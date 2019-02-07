package no.hvl.dat152;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat152.modell.Beskrivelse;
import no.hvl.dat152.modell.Handlekurv;
import no.hvl.dat152.modell.Vare;

/**
 * Servlet implementation class oppsett
 */
@WebServlet("/oppsett")
public class oppsett extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public oppsett() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Beskrivelse beskrivelse1 = new Beskrivelse("no_NO","Dette er cupens ultimatum for programvareutviklere som jobber om natten og trenger noe å unngå");
		Beskrivelse beskrivelse2 = new Beskrivelse("en_US","This is the cup ultimatum for software developers who work at night and need something to avoid");
		Beskrivelse beskrivelse3 = new Beskrivelse("de_DE","Dies ist das ultimative Ultimatum für Softwareentwickler, die nachts arbeiten und etwas zu vermeiden brauchen");
		Beskrivelse liste1[] = {beskrivelse1, beskrivelse2, beskrivelse3};
		Vare vare1 = new Vare("White Coffee Cup (TM)", liste1, (float) (6.5), "WhiteCoffeeCup.jpeg");
		
		Beskrivelse beskrivelse4 = new Beskrivelse("no_NO","Dette er et krus for dem som liker svart farge. Koppen er veldig bra for kaffe, te og melk, men det er også mulig å bruke den med andre drinker");
		Beskrivelse beskrivelse5 = new Beskrivelse("en_US", "This is a mug for them that like black color. The cup is very good for coffee, tea and milk, but it is also possible to use it with other drinks");
		Beskrivelse beskrivelse6 = new Beskrivelse("de_DE", "Dies ist eine Tasse für sie, die wie schwarze Farbe. Die Tasse ist sehr gut für Kaffee, Tee und Milch, aber es ist auch möglich, sie mit anderen Getränken zu verwenden.");
		Beskrivelse liste2[] = {beskrivelse4, beskrivelse5, beskrivelse6};
		Vare vare2 = new Vare("Black Coffee Cup (TM)", liste2, (float) 4.75, "BlackCoffeeCup.jpeg");
		
		Vare vare[] = {vare1, vare2};
		HttpSession sesjon = request.getSession(false);
		sesjon = request.getSession(true);

		sesjon.setAttribute("vare", vare);
		request.setAttribute("vare", vare);
		// request.setAttribute("liste, request.getAttribute("liste"));
		//request.getRequestDispatcher("/products").forward(request, response);
		//response.sendRedirect("products");
		//request.getRequestDispatcher("products").forward(request, response); 
		request.getSession().setAttribute("vare", vare);
		request.getRequestDispatcher("products").forward(request, response);


		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
