package yzk.user.controller;



import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import yzk.common.vo.JsonResult;
import yzk.common.vo.SysResult;

import yzk.user.service.UserService;

@RestController
@RequestMapping("/user/manage")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//登录
	@CrossOrigin
	@RequestMapping("/login")
	public SysResult doLogin(String uname,String pwd) {
		//调用业务层确定合法并且存储数据
		System.out.println("进入usercontroller，准备存储数据到redis");
		return userService.doLogin(uname,pwd);	
				
	}
	//携带的ticket值查询redisuser数据
	@CrossOrigin
	@RequestMapping("/query")
		public SysResult checkLoginUser(String ticket){
		System.out.println("进入查询Redis中user对象Controller");
			String userJson=userService.queryUserJson(ticket);
			//判断非空
			if(StringUtils.isNotEmpty(userJson)){
				//查询成功
				//确实曾经登录过.也正在登录使用状态中
				return SysResult.build(200, "ok", userJson);
			}else{
				return SysResult.build(201, "", null);
			}
		}

	//用户密码List
	@CrossOrigin
	@RequestMapping("/userList")
	public JsonResult userList(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit,String xh){		
		return userService.userListPwd(page, limit, xh);
	}
	//管理员修改密码
	@CrossOrigin
	@RequestMapping("/editPwdManage")
	public SysResult pwdEditManage(Integer id,String password1,String password2) {
		System.out.println("id"+id);
		System.out.println("password1"+password1);
		System.out.println("password2"+password2);
		return userService.pwdEditManage(id, password1, password2);		
	}
	
	//用户List
	@CrossOrigin
	@RequestMapping("/stuAllList")
	public JsonResult stuAllList(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit,
			String nianji,String xi,String zhuanye,String banji,String xh){
			System.out.println("学生管理传进来的信息"+"page="+page+"/limit="+limit+"/nianji="+nianji+
					"/xi="+xi+"/zhuanye="+zhuanye+"/banji="+banji+"/xh="+xh);
			return userService.stuAllList(page, limit,nianji,xi,zhuanye,banji,xh);
	}
	//用户List
	@CrossOrigin
	@RequestMapping("/teaAllList")
	public JsonResult teaAllList(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit,String js,String xh){
			System.out.println("教师管理传进来的信息"+"page="+page+"/limit="+limit+"角色="+js+"/xh="+xh);
			return userService.teaAllList(page, limit,js,xh);
	}
	//根据id删除用户信息deleteID
	@CrossOrigin
	@RequestMapping("/deleteID")
	public SysResult deleteID(Integer id) {
		return userService.deleteID(id);
	}
	//根据id修改用户信息editStu
	@CrossOrigin
	@RequestMapping("/editStu")
	public SysResult editStu(Integer id,String xh,String zsxm,String xb,String bj) {
		System.out.println("修改学生：id"+id+"学号："+xh+"真实姓名"+zsxm+"性别："+xb+"班级="+bj);
		return userService.editStu(id,xh,zsxm,xb,bj);
	}
	//根据id修改用户信息editTea
	@CrossOrigin
	@RequestMapping("/editTea")
	public SysResult editTea(Integer id,String xh,String zsxm,String xb) {
		System.out.println("修改教师：id"+id+"学号："+xh+"真实姓名"+zsxm+"性别："+xb);
		return userService.editTea(id,xh,zsxm,xb);
	}
	//添加用户
	@CrossOrigin
	@RequestMapping("/addUser")
	public SysResult addUser(Integer xh,String zsxm,String xb,String bj) {
		return userService.addUser(xh,zsxm,xb,bj);
	}
	
}
