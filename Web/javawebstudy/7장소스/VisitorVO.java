package model.vo;
public class VisitorVO {
	private String name;
	private String writeDate;
	private String content;
	@Override 
	public String toString() {
		return "VisitorVO [name=" + name + ", writeDate=" + writeDate + ", content=" + content + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}	
}
