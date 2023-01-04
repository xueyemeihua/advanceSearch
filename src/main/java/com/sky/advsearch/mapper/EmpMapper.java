package com.sky.advsearch.mapper;

import com.sky.advsearch.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    //    根据员工姓名模糊查询员工信息
    List<Emp> searchEmpByEnameAndSalary(@Param("ename") String ename, @Param("salary") int salary);

    //    查询比该工资少的员工信息
    List<Emp> searchEmpBySalary(@Param("salary") int salary);

    //    根据用户输入员工姓名模糊查询
    List<Emp> searchEmpByEnameLike(@Param("ename") String ename);

    //    查询所有员工信息
    List<Emp> searchEmp();
}
