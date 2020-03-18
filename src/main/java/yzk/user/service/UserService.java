package yzk.user.service;


import org.apache.ibatis.annotations.Param;

import yzk.common.pojo.User;
import yzk.common.vo.JsonResult;
import yzk.common.vo.SysResult;
import yzk.user.formEntity.PwdEntity;

public interface UserService {

	SysResult pwdEditManage(Integer id,String password1,String password2);
	SysResult doLogin(@Param("uname") String uname,@Param("pwd")String pwd);
	JsonResult userListPwd(Integer page, Integer limit, String xh);
	String queryUserJson(String ticket);
	JsonResult stuAllList(Integer page, Integer limit, String nianji, String xi, String zhuanye, String banji,
			 String xh);
	JsonResult teaAllList(Integer page, Integer limit,String js,String xh);
	SysResult deleteID(Integer id);
	SysResult editStu(Integer id, String xh, String zsxm, String xb, String bj);
	SysResult editTea(Integer id, String xh, String zsxm, String xb);
	SysResult addUser(Integer xh, String zsxm, String xb, String bj);
	
	
	
}
