package dtos;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

public class CommentDTO implements Serializable {
    @Serial private static final long serialVersionUID = 1L;

    private String text;
    private Date date;
    private AuthorDTO author;
    
    public CommentDTO() {}

	public CommentDTO(String text, AuthorDTO author) {
		super();
		this.text = text;
		this.date = Date.from(Instant.now());
		this.author = author;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}
	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
}
