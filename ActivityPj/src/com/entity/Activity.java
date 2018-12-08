package com.entity;

import java.util.Date;

public class Activity {
	
	
	private String stuid;
	@Override
	public String toString() {
		return "Activity [stuid=" + stuid + ", actid=" + actid + ", actname=" + actname + ", acttime=" + acttime
				+ ", actxuefen=" + actxuefen + ", actflag=" + actflag + ", acttype=" + acttype + "]";
	}
	private String actid;
	private String actname;
	private String acttime;
	private String actxuefen;
	private String actflag;
	private String acttype;
	
	public String getActtype() {
		return acttype;
	}
	public void setActtype(String acttype) {
		this.acttype = acttype;
	}
	public String getActflag() {
		return actflag;
	}
	public void setActflag(String actflag) {
		this.actflag = actflag;
	}
	public String getActid() {
		return actid;
	}
	public void setActid(String actid) {
		this.actid = actid;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getActname() {
		return actname;
	}
	public void setActname(String actname) {
		this.actname = actname;
	}
	public String getActtime() {
		return acttime;
	}
	public void setActtime(String acttime) {
		this.acttime = acttime;
	}
	public String getActxuefen() {
		return actxuefen;
	}
	public void setActxuefen(String actxuefen) {
		this.actxuefen = actxuefen;
	}
	
	

}
