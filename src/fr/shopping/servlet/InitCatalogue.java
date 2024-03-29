package fr.shopping.servlet;

import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import fr.shopping.bean.Catalogue;
import fr.shopping.bean.Produit;

/**
 * Servlet implementation class InitCatalogue
 */
@WebServlet("/InitCatalogue")
public class InitCatalogue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/*
	 * initialisation de catalogue au d�marrage du serveur.
	 */
	public InitCatalogue() {
		Produit produit1 = new Produit();
		produit1.setId("P1");
		produit1.setNom("PHILIPS 52PFL7203H");
		produit1.setPrix(1499.99f);
		Produit produit2 = new Produit();
		produit2.setId("P2");
		produit2.setNom("SAMSU_PS42A416");
		produit2.setPrix(589.99f);
		produit2.setImage("http://www.lcd-compare.com/images/pdts/xlm/SAMPS42A416.jpg");
		produit2.setDescription("T�l�viseur Plasma 42\" (106 cm) 16:9 - Tuner TNT int�gr� - Double HDMI - Entr�e PC -"
		+ "R�solution: 1024 x 768 - Luminosit�: 1500 cd/m� - Taux de contraste: 100 000:1 - Angle de vision: 175�");
		Produit produit3 = new Produit();
		produit3.setId("P3");
		produit3.setNom("PHILIPS 52PFL7203H");
		produit3.setImage("http://img.clubic.com/0156015601294748-c2-photo-oYToxOntzOjU6ImNvbG9yIjtzOjU6IndoaXRlIjt9-televiseur-lcd-philips-32pfl7403.jpg");
		produit3.setPrix(1499.99f);
		Produit produit4 = new Produit();
		produit4.setId("P4");
		produit4.setNom("TOSHIBA 32CV515DG");
		produit4.setPrix(499.99f);
		produit4.setDescription("T�l�viseur LCD 32\" (81 cm) 16:9 HD TV - Tuner TNT HD int�gr� - Triple HDMI - R�solution:"
		+ "1366 x 768 - Luminosit�: 500 cd/m� - Contraste: 30000:1 - Temps de r�ponse: 8 ms - Angle de vision: 178�");
		HashMap<String, Produit> listProduit = new HashMap<String, Produit>();
		listProduit.put(produit1.getId(), produit1);
		listProduit.put(produit2.getId(), produit2);
		listProduit.put(produit3.getId(), produit3);
		listProduit.put(produit4.getId(), produit4);
		Catalogue catalogue = Catalogue.getInstance();
		catalogue.setName("Catalogue");
		catalogue.setListProduit(listProduit);
		}

}
