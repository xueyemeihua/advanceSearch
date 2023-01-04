package com.sky.advsearch.test;

import com.sky.advsearch.mapper.EmpMapper;
import com.sky.advsearch.pojo.Emp;
import com.sky.advsearch.service.EmpService;
import com.sky.advsearch.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

public class EmpMapperTest {

    @Test
    public void testSearchEmpByEnameAndSalary() {
        List<Emp> emps = null;
//        EmpMapper mapper = SqlSessionUtil.getSqlSession().getMapper(EmpMapper.class);
//        emps = mapper.searchEmpByEnameAndSalary("lily", 8000);
//        emps = mapper.searchEmpBySalary(8000);
//        emps = mapper.searchEmpByEnameLike("d");
        EmpService service = new EmpService();
        emps = service.getEmp("s", "8000");
        System.out.println(emps);
    }
}
