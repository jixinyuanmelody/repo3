package com.ssm07.dao;


import com.ssm07.entity.Student;

public interface StuDao {
	Student getStuBySid(int sid);
    int updatePic(String touxiang);
    int update(Student stu);
}
