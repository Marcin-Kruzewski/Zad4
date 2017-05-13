package webapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MovieRepository;

/**
 * Servlet implementation class MoviesSrvlet
 */
@WebServlet("/movies")
public class MoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public MovieRepository movies = new MovieRepository();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoviesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getParameter("id"));
		//System.out.println(request.getParameter("comment"));
		//System.out.println(request.getParameter("stars"));
		if (request.getParameter("id") != null){
			Integer id = new Integer(request.getParameter("id"));
			if (request.getParameter("comment") != null){
				if (request.getParameter("comment").length() > 0){
					this.movies.addComment(id, request.getParameter("comment"), "anonymus");
				}
			}
			if (request.getParameter("stars") != null){
				if (request.getParameter("stars").matches("^[123456789]+$")){
					this.movies.addStars(id, new Integer(request.getParameter("stars")));
				}
			}
			response.getWriter().append("<html><body><p>");
			response.getWriter().append(this.movies.getMovie(id));
			response.getWriter().append("<br><form method=GET action=/movies><input type=hidden name=id value=");
			response.getWriter().append(request.getParameter("id"));
			response.getWriter().append(">");
			response.getWriter().append("<br><input type=text name=comment>");
			response.getWriter().append("<br><input type=number name=stars><input type=submit value='Add rating'></form></p><body></html>");
		}
		else{
			response.getWriter().append(this.movies.getMoviesJSON());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.movies.addMovie(request.getParameter("title"));
		doGet(request, response);
	}

}
