package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.HPermissionDAO;
import com.DAO.HierarchicalRoleDAO;
import com.DAO.PackageRoleDAO;
import com.DTO.HierarchicalPermissionDTO;
import com.DTO.Hierarchical_Role_PermissionDTO;
import com.DTO.Package_Role_PermissionDTO;
/**
 * Servlet implementation class HierarchyEdit1
 */
@WebServlet("/PackageEdit1")
public class PackageEdit1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PackageEdit1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PackageRoleDAO edit = new PackageRoleDAO();
		Package_Role_PermissionDTO List1 = new Package_Role_PermissionDTO();
		String perm = request.getParameter("pemission");
		perm=perm.trim();
		System.out.println("Permission is perm"+perm+"Hello");
		List1.setPackageRoleID(perm);
		List<Package_Role_PermissionDTO> PermissionIDList;
		PermissionIDList = edit.findAll2(List1);
		PrintWriter out = response.getWriter();
		
		System.out.println("permissionIdList:"+PermissionIDList.size());
		for(int i=0; i< PermissionIDList.size() ;i++)
		{
			int j=i+1;
			System.out.println("value of permission "+j+ " "+PermissionIDList.get(i).getPackagePermissionID1());
		}
		session.setAttribute("PermissionId", PermissionIDList);
		if(PermissionIDList.size() == 0)
		{
			out.println(
					
					"<option selected = 'selected' disabled='disabled'>No permissions </option>"
					);

		}
		else
		{
			out.println(
			"<option selected = 'selected' disabled='disabled'>Select permissions</option>"
		);
		for(int i=0; i<PermissionIDList.size();i++)
		{
			out.println(
				
			"<option value='" +  PermissionIDList.get(i).getPackagePermissionID1() + "'>" +  PermissionIDList.get(i).getPackagePermissionID1() + "</option>"
			);
		}
		}
	}	

}
