package com.act_comm.model;

import java.io.Serializable;
import java.sql.Date;

public class Act_commVO implements Comparable,Serializable {
	private String comm_no;
	private String act_no;
	private String mem_ac;
	private String comm_cont;
	private Date comm_date;
	private String comm_reply_cont;
	private Date comm_reply_date;
	public Act_commVO() {
		super();
	}
	public String getComm_no() {
		
		return comm_no;
	}
	public void setComm_no(String cOMM_NO) {
		comm_no = cOMM_NO;
	}
	public String getAct_no() {
		return act_no;
	}
	public void setAct_no(String aCT_NO) {
		act_no = aCT_NO;
	}
	public String getMem_ac() {
		return mem_ac;
	}
	public void setMem_ac(String mEM_AC) {
		mem_ac = mEM_AC;
	}
	public String getComm_cont() {
		return comm_cont;
	}
	public void setComm_cont(String cOMM_CONT) {
		comm_cont = cOMM_CONT;
	}
	public Date getComm_date() {
		return comm_date;
	}
	public void setComm_date(Date cOMM_DATE) {
		comm_date = cOMM_DATE;
	}
	public String getComm_reply_cont() {
		return comm_reply_cont;
	}
	public void setComm_reply_cont(String cOMM_REPLY_CONT) {
		comm_reply_cont = cOMM_REPLY_CONT;
	}
	public Date getComm_reply_date() {
		return comm_reply_date;
	}
	public void setComm_reply_date(Date cOMM_REPLY_DATE) {
		comm_reply_date = cOMM_REPLY_DATE;
	}
	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		Act_commVO objVO=(Act_commVO) obj;
		System.out.println("dateToTimestamp(this.getComm_date()).getTime()= "+dateToTimestamp(this.getComm_date()).getTime()+" ,dateToTimestamp(objVO.getComm_date()).getTime()= "+dateToTimestamp(objVO.getComm_date()).getTime());
		System.out.println(dateToTimestamp(this.getComm_date()));
		if(dateToTimestamp(this.getComm_date()).getTime()<dateToTimestamp(objVO.getComm_date()).getTime()){
			
			return 1;
		}else if(dateToTimestamp(this.getComm_date()).getTime()>dateToTimestamp(objVO.getComm_date()).getTime()){
			return -1;
		}else{
		
		
		return 0;
		}
	}
	
	
	public static java.sql.Date timestampToDate(java.sql.Timestamp timestamp){
		java.util.Date  test_timestamp=timestamp;
		java.sql.Date test_date=new java.sql.Date(test_timestamp.getTime());
		return test_date;
	}

	public static java.sql.Timestamp dateToTimestamp(java.sql.Date date){
		
		java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		return timestamp;
		
	}
	
	
}
