package model;
import java.util.ArrayList;

import com.google.gson.Gson;


public class MovieRepository {
	private ArrayList<Movie> movies= new ArrayList<Movie>();
	
	
	public void addMovie(String title){
		this.movies.add(new Movie(title));
	}
	
	public String getMovie(int id){
		return this.movies.get(id).getMovieJSON();
	}
	
	public void removeMovie(int id){
		this.movies.remove(id);
	}
	
	public void addComment(int id, String content, String poster){
		this.movies.get(id).addComment(content, poster);
	}
	
	public void addStars(int id, Integer stars){
		this.movies.get(id).addStars(stars);
	}
	
	public void changeTitle(int id, String title){
		this.movies.get(id).setTitle(title);
	}
	
	public void removeComment(int id, int commentId){
		this.movies.get(id).removeComment(commentId);
	}
	
	public String getMoviesJSON(){
		return new Gson().toJson(this.movies);
	}
}
