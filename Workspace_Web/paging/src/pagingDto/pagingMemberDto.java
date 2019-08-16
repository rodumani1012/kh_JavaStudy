package pagingDto;

public class pagingMemberDto {
	private String paging_id;
	private String paging_pw;
	
	public pagingMemberDto() {
		
	}
	public pagingMemberDto(String id, String pw) {
		this.paging_id = id;
		this.paging_pw = pw;
	}
	public String getPaging_id() {
		return paging_id;
	}
	public void setPaging_id(String paging_id) {
		this.paging_id = paging_id;
	}
	public String getPaging_pw() {
		return paging_pw;
	}
	public void setPaging_pw(String paging_pw) {
		this.paging_pw = paging_pw;
	}
}
