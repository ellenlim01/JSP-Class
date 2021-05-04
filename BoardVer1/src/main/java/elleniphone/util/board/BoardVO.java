package elleniphone.util.board;

import java.sql.Date;

public class BoardVO {
	private int iboard;
	private String title;
	private String content;
	private Date regitime;
	
	public int getIboard() {
		return iboard;
	}
	public void setIboard(int iboard) {
		this.iboard = iboard;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegitime() {
		return regitime;
	}
	public void setRegitime(Date regitime) {
		this.regitime = regitime;
	}
	
	
}
