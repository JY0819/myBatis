package com.kh.mb.board.model.vo;

import java.sql.Date;

public class Reply implements java.io.Serializable {
	private int rid;
	private String rContent;
	private int refBid;
	private int rWriter;
	private String userName;
	private Date createDate;
	private Date modifyDate;
	private String status;
	
	public Reply() {
		
	}

	public Reply(int rid, String rContent, int refBid, int rWriter, String userName, Date createDate, Date modifyDate,
			String status) {
		super();
		this.rid = rid;
		this.rContent = rContent;
		this.refBid = refBid;
		this.rWriter = rWriter;
		this.userName = userName;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public int getRefBid() {
		return refBid;
	}

	public void setRefBid(int refBid) {
		this.refBid = refBid;
	}

	public int getrWriter() {
		return rWriter;
	}

	public void setrWriter(int rWriter) {
		this.rWriter = rWriter;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "Reply [rid=" + rid + ", rContent=" + rContent + ", refBid=" + refBid + ", rWriter=" + rWriter
				+ ", userName=" + userName + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", status="
				+ status + "]";
	}
	
}
