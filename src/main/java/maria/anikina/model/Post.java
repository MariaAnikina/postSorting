package maria.anikina.model;

public class Post {
	private String text;
	private Integer likesCount;

	public Post(Integer likesCount) {
		this.likesCount = likesCount;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(Integer likesCount) {
		this.likesCount = likesCount;
	}
}
