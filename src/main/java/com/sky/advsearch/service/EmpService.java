package com.sky.advsearch.service;

import com.sky.advsearch.mapper.EmpMapper;
import com.sky.advsearch.pojo.Emp;
import com.sky.advsearch.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class EmpService {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

    public List<Emp> getEmp(String ename, String salary1) {
        List<Emp> emps = new ArrayList<>();
        if (ename.equals("") || salary1.equals("")) {
            //存在空条件
            if (ename.equals("")&&salary1.equals("")) {
                emps = mapper.searchEmp();
            } else if (ename.equals("")){
                //查询比输入工资少的数据
                int salary = Integer.parseInt(salary1);
                emps = mapper.searchEmpBySalary(salary);
            } else {
                //模糊查询姓名为输入内容的员工信息
                emps = mapper.searchEmpByEnameLike(ename);
            }
        } else {
            //不存在空条件,直接用两个条件查询
            int salary = Integer.parseInt(salary1);
            emps = mapper.searchEmpByEnameAndSalary(ename,salary);
        }
        return emps;
    }

}
