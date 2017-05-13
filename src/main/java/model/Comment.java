package model;

public class Comment {
	private String body;
	private String sender;
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Comment(String body, String sender) {
		super();
		this.body = body;
		this.sender = sender;
	}
	@Override
	public String toString() {
		return "[body=" + body + ", sender=" + sender + "]";
	}
}
