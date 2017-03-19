
package com.lhb.barber.control;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lhb.barber.model.Employee;
import com.lhb.barber.model.Post;
import com.lhb.barber.server.EmployeeServer;
import com.lhb.barber.server.SystemServer;
import com.lhb.barber.util.FileUtil;

@Controller
@RequestMapping("/employee")
public class EmployeeAction {
	@Autowired
	private EmployeeServer employeeServer;
	@Autowired
	private SystemServer systemServer;
	
	
	// /upload/file.do
	@RequestMapping(value = "file", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("name") String name, @RequestParam("myfile") MultipartFile myfile)
			throws IOException {

		if (!myfile.isEmpty()) {
			System.out.println("fileName: " + myfile.getName() + " , " + "fileContextType :" + myfile.getContentType());
			
			String picDir = "E:\\Workspaces_javaweb16\\workspace_spring\\SpringMVC-1-2\\WebContent\\upload";
			File newFile = new File(picDir, System.currentTimeMillis() + ".png");
			
			FileUtil.copyFile(myfile.getInputStream(), newFile);
			
		}

		return "success";
	}

	/**
	 * 添加员工
	 * 
	 * @param employee
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/operate", method = RequestMethod.POST)
	public String operate(Integer p_id,String operation,Employee employee, Model model){
		String message = "";		
		employee.setEmployee_post(systemServer.getPostById(p_id));		
		if ("addemployee".equals(operation)) {
			if (!employeeServer.addEmployee(employee))
				message = "添加员工失败!";
		}
		if ("updateemployee".equals(operation)) {
			if (!employeeServer.updateEmployee(employee))
				message = "修改员工失败！";
		}
		model.addAttribute("message", message);
		return "redirect:/system/allemployee.do";
		
	}
	/**
	 * 添加员工
	 * 
	 * @param employee
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addemployee")
	public String addEmployee(String operation,Employee employee, Model model) {
		List<Post> postlist=systemServer.getAllPost();
		model.addAttribute("postlist", postlist);
		model.addAttribute("operation", "addemployee");
		return "employee/add_employee";
	}

	/**
	 * 删除员工
	 * 
	 * @param employee
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteemployee/{Employee_id}",method=RequestMethod.GET)
	public String deleteEmployee(@PathVariable Integer Employee_id, Model model) {
		Employee employee = employeeServer.getEmployeeById(Employee_id);
		employeeServer.deleteEmployee(employee);
		model.addAttribute("member", "");
		return "redirect:/system/allemployee.do";
	}

	/**
	 * 更新员工
	 * 
	 * @param employee
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateemployee/{Employee_id}",method=RequestMethod.GET)
	public String updateEmployee(@PathVariable Integer Employee_id, Model model) {
		Employee employee = employeeServer.getEmployeeById(Employee_id);
		employeeServer.updateEmployee(employee);
		model.addAttribute("operation", "updateemployee");
		model.addAttribute("employee", employee);
		return "employee/add_employee";
	}

	/**
	 * 查找员工
	 * 
	 * @param message
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/findemployee", method = RequestMethod.POST)
	public String findEmployee(String message, Model model) {
		return null;
	}

	/**
	 * 所有员工信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/allemployee/{curPage}")
	public String allEmployee(@PathVariable Integer curPage,String message,Model model) {
		if (message != null && !message.equals("")) {
			model.addAttribute("message", message);
		}
		List<Employee> employeeList = employeeServer.getAllEmployee(curPage);
		model.addAttribute("employeeList", employeeList);
		return "employee/list_employee";
	}

}
