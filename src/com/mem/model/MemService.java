package com.mem.model;

import java.sql.Date;
import java.util.List;

public class MemService {
	private MemDAO_interface dao;

	public MemService() {
		dao = new MemDAO();
	}

	public MemVO addMem(String mem_ac, String mem_pwd, String mem_lname, String mem_fname, String mem_email,
			String mem_phone, String mem_add, byte[] mem_pic, String mem_set, Integer mem_total_pt, Integer mem_pt,
			Integer grade_no, String mem_stat, java.sql.Date mem_stat_cdate, java.sql.Date mem_reg_date) {
		MemVO memVO = new MemVO();

		memVO.setMem_ac(mem_ac);
		memVO.setMem_pwd(mem_pwd);
		memVO.setMem_lname(mem_lname);
		memVO.setMem_fname(mem_fname);
		memVO.setMem_email(mem_email);
		memVO.setMem_phone(mem_phone);
		memVO.setMem_add(mem_add);
		memVO.setMem_pic(mem_pic);
		memVO.setMem_set(mem_set);
		memVO.setMem_total_pt(mem_total_pt);
		memVO.setMem_pt(mem_pt);
		memVO.setGrade_no(grade_no);
		memVO.setMem_stat(mem_stat);
		memVO.setMem_stat_cdate(mem_stat_cdate);
		memVO.setMem_reg_date(mem_reg_date);
		dao.insert(memVO);

		return memVO;
	}

	public void addMem(MemVO memVO) {
		dao.insert(memVO);
	}

	// 簡易註冊
	public MemVO reg_mem(String mem_ac, String mem_pwd, String mem_phone) {
		MemVO memVO = new MemVO();
		memVO.setMem_ac(mem_ac);
		memVO.setMem_pwd(mem_pwd);
		memVO.setMem_phone(mem_phone);
		memVO.setMem_total_pt(0);
		memVO.setMem_pt(0);
		memVO.setGrade_no(1);
		memVO.setMem_set(" , , ");
		memVO.setMem_stat("正常");
		memVO.setMem_reg_date(new Date(System.currentTimeMillis()));
		dao.insert(memVO);
		return memVO;

	}

	public MemVO updateMem(String mem_ac, String mem_pwd, String mem_lname, String mem_fname, String mem_email,
			String mem_phone, String mem_add, byte[] mem_pic, String mem_set, Integer mem_total_pt, Integer mem_pt,
			Integer grade_no, String mem_stat, java.sql.Date mem_stat_cdate, java.sql.Date mem_reg_date) {
		MemVO memVO = new MemVO();

		memVO.setMem_ac(mem_ac);
		memVO.setMem_pwd(mem_pwd);
		memVO.setMem_lname(mem_lname);
		memVO.setMem_fname(mem_fname);
		memVO.setMem_email(mem_email);
		memVO.setMem_phone(mem_phone);
		memVO.setMem_add(mem_add);
		memVO.setMem_pic(mem_pic);
		memVO.setMem_set(mem_set);
		memVO.setMem_total_pt(mem_total_pt);
		memVO.setMem_pt(mem_pt);
		memVO.setGrade_no(grade_no);
		memVO.setMem_stat(mem_stat);
		memVO.setMem_stat_cdate(mem_stat_cdate);
		memVO.setMem_reg_date(mem_reg_date);
		dao.update(memVO);

		return memVO;
	}
	
	public MemVO addPtToMem(String mem_ac, Integer pt) {
		MemVO memVO = dao.findByPrimaryKey(mem_ac);
		Integer mem_total_pt = memVO.getMem_total_pt()+pt;
		Integer mem_pt = memVO.getMem_pt()+pt;
		Integer grade_no;
		 if(mem_total_pt<=100){
			  grade_no=1;
		  }else if(mem_total_pt<=200){
			  grade_no=2;
		  }else if(mem_total_pt<=300){
			  grade_no=3;
		  }else if(mem_total_pt<=400){
			  grade_no=4;
		  }else if(mem_total_pt<=500){
			  grade_no=5;
		  }else{
			  grade_no=6;
		  }
		 memVO.setGrade_no(grade_no);
		 memVO.setMem_total_pt(mem_total_pt);
		 memVO.setMem_pt(mem_pt);
		 dao.update(memVO);
		return memVO;
	}

	public void updateMem(MemVO memVO) {
		dao.update(memVO);
	}

	// 更改資料 mem_data.jsp
	public MemVO update_databyres(String mem_ac ,String mem_lname, String mem_fname, String mem_email, String mem_add,
			byte[] mem_pic, String mem_set) {
		MemVO memVO = dao.findByPrimaryKey(mem_ac);
		
		memVO.setMem_lname(mem_lname);
		memVO.setMem_fname(mem_fname);
		memVO.setMem_email(mem_email);
		memVO.setMem_add(mem_add);
		memVO.setMem_pic(mem_pic);
		memVO.setMem_set(mem_set);

		dao.update(memVO);
		return memVO;
	}

	public void deleteMem(String mem_ac) {
		dao.delete(mem_ac);
	}

	public MemVO getOneMem(String mem_ac) {//
		 MemVO memvo=dao.findByPrimaryKey(mem_ac);
//		 memvo.setMem_pwd(null);
		 return memvo;
	}

	// 名稱錯誤
	public MemVO getOneProd(String mem_ac) {
		return getOneMem(mem_ac);
	}

	public List<MemVO> getAll() {//
		
		List<MemVO> memvos= dao.getAll();
		for(MemVO memvo:memvos){
			memvo.setMem_pwd(null);
		}
		return  memvos;
	}

	public List<MemVO> getAllNoImg() {
		return dao.getAllNoImg();
	}

	public MemVO findByPrimaryKeyNoImg(String mem_ac) {
		return dao.findByPrimaryKeyNoImg(mem_ac);
	}

	public byte[] getImageByPK(String mem_ac) {
		return dao.getImageByPK(mem_ac);
	}

	public MemVO findPwdByPK(String mem_ac) {
		return dao.findPwdByPK(mem_ac);
	}

}
