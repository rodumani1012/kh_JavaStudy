package com.page.dto;

public class PageMaker {

	final int P = 5; //한블럭에 표시하고싶은 페이지번호수
	//finalt int C
	private int totalcount;
	private int pagenum;
	private int contentnum;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int currentblock;
	private int lastblock;
	private int startCon;
	private int endCon;

	public PageMaker() {
		super();
	}

	public PageMaker(int totalcount, int pagenum, int contentnum) {
		this.totalcount = totalcount;
		this.pagenum = pagenum;
		this.contentnum = contentnum;
		setCurrentblock(pagenum);
		setLastblock(totalcount);
		setStartPage(this.getCurrentblock());
		setEndPage(this.getLastblock(), this.getCurrentblock());
		setStartCon(pagenum, contentnum);
		setEndCon(pagenum, contentnum);
		setNext(pagenum);
		setPrev(pagenum);
	}

//전체페이지수를 결정하는 메서드
	public int calcpage(int totalcount, int contentnum) {
		int totalpage = totalcount / contentnum;
		if (totalcount % contentnum > 0) {
			totalpage++;
		}
		return totalpage;
	}

	// 전체게시물갯수
	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	// 내가 가려고하는 페이지번호
	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	// 내가 한페이지에 뿌려줄 게시물의 갯수
	public int getContentnum() {
		return contentnum;
	}

	public void setContentnum(int contentnum) {
		this.contentnum = contentnum;
	}

	// 해당하는 블럭에서 시작되는 페이지넘버
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int currentblock) {
		this.startPage = (currentblock * P) - (P - 1);
	}

	// 해당하는 블럭에서 마지막으료 표시되는 넘버
	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int getlastblock, int getcurrentblock) {

		if (getlastblock == getcurrentblock) {
			this.endPage = calcpage(getTotalcount(), getContentnum());
		} else {
			this.endPage = getStartPage() + (P-1);
		}

	}

	public boolean getPrev() {
		return prev;
	}

	public void setPrev(int pagenum) {
		if (pagenum > 0 && pagenum <= P)
			this.prev = false;
		else
			this.prev = true;
	}

	public boolean getNext() {
		return next;
	}

	public void setNext(int pagenum) {
		if (this.lastblock == this.currentblock)
			this.next = false;
		else
			this.next = true;
	}

	public int getCurrentblock() {
		return currentblock;
	}

	public void setCurrentblock(int pagenum) {

		this.currentblock = pagenum / P;
		if (pagenum % P > 0) {
			this.currentblock++;
		}
	}

	public int getLastblock() {
		return lastblock;
	}

	public void setLastblock(int totalcount) {
		this.lastblock = totalcount / (this.contentnum * P);
		if (totalcount % (this.contentnum * P) > 0) {
			this.lastblock++;

		}
	}

	public int getStartCon() {
		return startCon;
	}

	public void setStartCon(int getPagenum, int getContentnum) {
		this.startCon = (getPagenum * getContentnum) - (getContentnum - 1);
	}

	public int getEndCon() {
		return endCon;
	}

	public void setEndCon(int getPagenum, int getContentnum) {
		this.endCon = getPagenum * getContentnum;
	}

}