package com.kh.mb.board.model.vo;

import java.sql.Date;

public class Board implements java.io.Serializable {

	private int bid;
	private int bType;
	private String bTitle;
	private String bContent;
	private int bWriter;
	private String userName;
	private int bCount;
	private Date createDate;
	private Date modifyDate;
	private String status;

	public Board() {

	}

	public Board(int bid, int bType, String bTitle, String bContent, int bWriter, String userName, int bCount,
			Date createDate, Date modifyDate, String status) {
		super();
		this.bid = bid;
		this.bType = bType;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bWriter = bWriter;
		this.userName = userName;
		this.bCount = bCount;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getbType() {
		return bType;
	}

	public void setbType(int bType) {
		this.bType = bType;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public int getbWriter() {
		return bWriter;
	}

	public void setbWriter(int bWriter) {
		this.bWriter = bWriter;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getbCount() {
		return bCount;
	}

	public void setbCount(int bCount) {
		this.bCount = bCount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Board [bid=" + bid + ", bType=" + bType + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bWriter="
				+ bWriter + ", userName=" + userName + ", bCount=" + bCount + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + ", status=" + status + "]";
	}

}
