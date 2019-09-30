package com.ssm07.service;

import com.ssm07.entity.Student;

public interface StuService {
	Student cha(int sid);
	int updatePic(String touxiang);
	int update(Student stu);
}
