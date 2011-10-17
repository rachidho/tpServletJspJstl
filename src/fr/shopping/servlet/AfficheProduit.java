package fr.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.shopping.bean.Catalogue;
import fr.shopping.bean.Produit;

/**
 * Servlet implementation class AfficheProduit
 */
@WebServlet("/AfficheProduit")
public class AfficheProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficheProduit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><title>details produit</title>"
				+ "<link rel=stylesheet type='text/css' href='css/styles.css'>"
				+ "<head><body>");

		String id = request.getParameter("id");
		Catalogue catalogue = Catalogue.getInstance();
		Produit produit = new Produit();
		for (Map.Entry<String, Produit> entry : catalogue.getListProduit()
				.entrySet()) {
			if (entry.getKey().equals(id)) {
				produit = entry.getValue();
			}
		}

		out.println("<div class='produit'>");
		out.println("<table><tr>");
		out.println("<td rowspan='2'> <img src=" + produit.getImage()
				+ " /></td>");
		out.println("<td><a class='nom' href='/tpServletJspJstl/AfficheProduit?id="
				+ produit.getId() + "'> " + produit.getNom() + "</a>");
		out.println("</td></tr><tr>");
		out.println("<td class='prix'>" + produit.getPrix()
				+ " &nbsp;&euro;</td>");
		out.println("</tr><tr>");
		out.println("<td colspan='2' class='desc'>" + produit.getDescription()
				+ "</td>");
		out.println("</tr></table>");
		out.println("</div>");
		out.println(" <form method='get' action='AjouteAuPanier'>" +
						"<input type='hidden' name='id' value="+ produit.getId()+"/>"+
						"<input type='submit' value='ajouter au panier' />"+
						"</form>");
		out.println("<body><html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
