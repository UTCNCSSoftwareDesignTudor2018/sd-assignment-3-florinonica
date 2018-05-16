package Communication.Requests;

import java.io.Serializable;

public class ArticleRequest implements Serializable {
	private static final long serialVersionUID = 1L;	
	private String title;

	public ArticleRequest(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
