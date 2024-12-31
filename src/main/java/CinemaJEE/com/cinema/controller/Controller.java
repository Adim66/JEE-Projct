package CinemaJEE.com.cinema.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import CinemaJEE.com.cinema.dao.Cinema;
import CinemaJEE.com.cinema.dao.CinemaBean;
import CinemaJEE.com.cinema.dao.Utilisateur;
import CinemaJEE.com.cinema.dao.UtilisateurBean;
import CinemaJEE.com.cinema.entities.Compte;
import CinemaJEE.com.cinema.entities.SalleProgramme;
import CinemaJEE.com.cinema.entities.Seance;
import CinemaJEE.com.cinema.model.NavigationSallesProModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="servlet01", urlPatterns= {"adim","*.jee"}) // Circular Redirection Loop , probleme lazem na3ref nsammi les servlets 
public class Controller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf;
	private Utilisateur user_dao;
	private Cinema cin_dao;

	@Override
	public void init() throws ServletException {
		emf = Persistence.createEntityManagerFactory("myPU");
		user_dao = new UtilisateurBean();
		cin_dao= new CinemaBean();
		
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager em = emf.createEntityManager();
		String path = req.getServletPath();
		System.out.println("path est :");
		System.out.println(req.getServletPath());
		if (path.equals("/createAccount.jee")) {
			System.out.println("AddComptePage");
			req.getRequestDispatcher("AddCompte.jsp").forward(req, resp);
		}
		if (path.equals("/Home.jee")) {
			System.out.println("Homepage");

			try {
				// Long id = Long.valueOf(req.getParameter("id"));
				req.getRequestDispatcher("Home.jsp").forward(req, resp);

				

			} catch (Exception e) {
				System.out.println(e);
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request");
			} finally {
				System.out.println("succcess to load ");
			}

		}
		if (path.equals("/Reserver.jee")) {
		   int id = Integer.parseInt(req.getParameter("id"));
		     Compte compte=  em.find(Compte.class,id); 
			 user_dao.setEm(em);
             cin_dao.setEm(em);
		     user_dao.init(compte.getName(),compte.getPassword());//tester si pas d exception donc le user exist// cv on pass
		     Set<SalleProgramme> salles =cin_dao.getAllSalleProg();
		     NavigationSallesProModel model= new NavigationSallesProModel();
		     model.setId(id);
		     model.setSalles_prog(salles);
		     req.setAttribute("model_salles", model);
		     req.getRequestDispatcher("SalleNavigation.jsp").forward(req, resp);
			 
		}
		if(path.equals("/SeancesSalle.jee")) {
			int id_salle= Integer.parseInt(req.getParameter("salleProgId"));
			Query q = em.createQuery("SELECT s FROM Seance s WHERE s.salle.id = :id_salle");
			q.setParameter("id_salle", id_salle);
			List<Seance> seances= q.getResultList();
			req.setAttribute("seances", seances);
		    req.getRequestDispatcher("Reservation.jsp").forward(req, resp);

			
			
			
			
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager em = emf.createEntityManager();
		String path = req.getServletPath();
		if (path.equals("/AddAccountController.jee")) {
			String name = req.getParameter("name");
			int solde = Integer.parseInt(req.getParameter("solde")); // on n a pas besoin du module car pas de jsp qui
																		// le nessecite
			String password = req.getParameter("password");
			System.out.println("succcess to sole "+solde);
			System.out.println("succcess to name "+name);
			System.out.println("succcess to pass"+password);
			Compte compte = new Compte(name, password, solde);
			user_dao.setEm(em);
			user_dao.save(compte);
			System.out.println("useradded");
			req.setAttribute("compte", compte);
			req.getRequestDispatcher("Registred.jsp").forward(req, resp);

		}

	}

	@Override
	public void destroy() {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}
}