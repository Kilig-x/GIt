/**
 * Copyright (c) 2004-2011 Wang Jinbao(Julian Wong), http://www.ralasafe.com
 * Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php
 */
package org.ralasafe.demo;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ralasafe.WebRalasafe;
import org.ralasafe.util.StringUtil;

public class EmployeeServlet extends HttpServlet {
	//private EmployeeManager employeeManager = new EmployeeManager();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Get employees that current user is permitted to view.
		if(req.getParameter("id")!=null && 
				req.getParameter("id").equalsIgnoreCase(""))
		{
			EmployeeManager employeeManager=new  EmployeeManager();
			Employee emp=new Employee();
			
			String loginName=req.getParameter("loginName");
			String password=req.getParameter("password");;
			int companyId=Integer.parseInt(req.getParameter("companyId"));
			int departmentId=Integer.parseInt(req.getParameter("departmentId"));
			Date hireDate=new Date();
			emp.setLoginName(loginName);	
			emp.setName(loginName);
			emp.setPassword(password);			
			emp.setCompanyId(companyId);			
			emp.setDepartmentId(departmentId);
			emp.setIsManager(0);
			emp.setHireDate(hireDate);
			employeeManager.addEmployee(emp);
		}
		else if(req.getParameter("id")!=null && 
				!req.getParameter("id").equalsIgnoreCase("0"))
		{
			EmployeeManager employeeManager=new  EmployeeManager();
			
			int id = Integer.parseInt(req.getParameter("id"));
			if(req.getParameter("loginName")!=null)
			{
				String loginName=req.getParameter("loginName");
				String name=req.getParameter("name");
				String password=req.getParameter("password");
				int companyId=Integer.parseInt(req.getParameter("companyId"));
				int departmentId=Integer.parseInt(req.getParameter("departmentId"));
				Employee employee = employeeManager.getEmployee(id);
				Date hireDate=new Date();
				employee.setLoginName(loginName);
				employee.setName(name);
				employee.setPassword(password);			
				employee.setCompanyId(companyId);			
				employee.setDepartmentId(departmentId);			
				employee.setHireDate(hireDate);
				employeeManager.updateEmployee(employee);
			}
			else
			{
				Employee employee = employeeManager.getEmployee(id);
				req.setAttribute("employee", employee);
				RequestDispatcher rd = req.getRequestDispatcher("add_employee.jsp");
				rd.forward(req, resp);
				return;
			}
		}
		Collection employees = WebRalasafe.query(req, Privilege.QUERY_EMPLOYEE);
		req.setAttribute("employees", employees);

		RequestDispatcher rd = req.getRequestDispatcher("employee.jsp");
		rd.forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
