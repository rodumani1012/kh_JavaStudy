package pagingDto;

import java.sql.Date;

public class pagingBoardDto {
	private int board_seq;
	private String board_id;
	private String board_title;
	private String board_content;
	private Date regdate;
	
	public pagingBoardDto() {
		
	}
	
	public pagingBoardDto(int board_seq, String board_id, String board_title, String board_content, Date regdate) {
		this.board_seq = board_seq;
		this.board_id = board_id;
		this.board_title = board_title;
		this.board_content = board_content;
		this.regdate = regdate;
	}

	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}

	public String getBoard_id() {
		return board_id;
	}

	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
