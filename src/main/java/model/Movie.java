package model;
import java.util.ArrayList;
import com.google.gson.Gson;


public class Movie {
	private String title;
	private ArrayList<Comment> comments = new ArrayList<Comment>();
	private ArrayList<Integer> stars = new ArrayList<Integer>();
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addStars(Integer stars){
		this.stars.add(stars);
	}
	
	public String getRating(){
		Integer rating = 0;
		for (int i = 0; i < this.stars.size(); i++){
			rating+=this.stars.get(i);
		}
		if(this.stars.size() == 0){
			return "0";
		}else{
			rating = rating / this.stars.size();
		}
		String finalRating = rating.toString();
		return finalRating;
	}
	
	public String getComments(){
		String json = new Gson().toJson(this.comments);
		System.out.println(json);
		return json;
	}
	
	public void addComment(String content, String poster){
		Comment comment = new Comment(content, poster);
		this.comments.add(comment);
	}
	
	public void removeComment(int commentId){
		this.comments.remove(commentId);
	}
	
	public String getMovieJSON(){
		return new Gson().toJson(this);
	}

	public Movie(String title) {
		this.title = title;
	}
	
}
