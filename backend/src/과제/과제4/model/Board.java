package 과제.과제4.model;

public class Board {
	public int views;
	public String writer;
	public String content;
	public String title;
	
	public Board() {}

	public Board(int views, String writer, String title,String content) {
		this.views = views;
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	
	
}
