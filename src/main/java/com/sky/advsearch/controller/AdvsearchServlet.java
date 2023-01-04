package com.sky.advsearch.controller;

import com.sky.advsearch.pojo.Emp;
import com.sky.advsearch.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdvsearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //获取用户输入的信息
        String ename = request.getParameter("ename");
        String salary = request.getParameter("salary");
        EmpService service = new EmpService();
        List<Emp> emps = service.getEmp(ename, salary);
        if (emps.size() == 0) {
            //没有数据
            request.setAttribute("emps", emps);
            request.setAttribute("sEmpsError", "没有数据");
            request.getRequestDispatcher("/advsearch.jsp").forward(request, response);
        } else {
            request.setAttribute("emps", emps);
            request.setAttribute("sEmpsError", "");
            request.getRequestDispatcher("/advsearch.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
