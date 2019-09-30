package com.ssm07.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm07.dao.StuDao;
import com.ssm07.entity.Student;
import com.ssm07.service.StuService;

@Service
public class StuServiceImpl implements StuService{

	@Autowired
	private StuDao dao;
	
	@Override
	public Student cha(int sid) {
		return dao.getStuBySid(sid);
	}

	@Override
	public int updatePic(String touxiang) {
		return dao.updatePic(touxiang);
	}

	@Override
	public int update(Student stu) {
		return dao.update(stu);
	}
	
}
