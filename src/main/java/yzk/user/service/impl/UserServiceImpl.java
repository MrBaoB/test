package yzk.user.service.impl;




import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import yzk.common.pojo.User;
import yzk.common.utils.MapperUtil;
import yzk.common.vo.JsonResult;
import yzk.common.vo.SysResult;
import yzk.user.formEntity.BjEntity;
import yzk.user.formEntity.UserEntity;
import yzk.user.mapper.UserMapper;
import yzk.user.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;


	//redis登录
	public SysResult doLogin(String uname,String pwd) {
		SysResult sysResult=new SysResult();
			// 判断登录的权限校验
			// 加密
			//user.setPassword(MD5Util.md5(user.getPassword()));
			//正常进入newTicket-userJson
			String newTicket="";
			try{
				User exist = userMapper.queryUser(uname,pwd);
				String loginKey = "login_"+exist.getXh();
				System.out.println("redis登录钥匙="+loginKey);
				Jedis jedis=new Jedis("39.105.166.3",6379);
				//判断loginKey是不是存在
				if(jedis.exists(loginKey)){
					//曾经有人登陆过
					//将oldTicket删除
					String oldTicket = jedis.get(loginKey);
					System.out.println("有人登陆过：redis删除旧的loginKey："+oldTicket);
					jedis.del(oldTicket);
				}
				newTicket = "EM_TICKET"+System.currentTimeMillis()+exist.getId();
				System.out.println("redis设置新的钥匙newTicket="+newTicket);
				//对象转化userJson
				String userJson = MapperUtil.MP.writeValueAsString(exist);
				System.out.println("user对象："+userJson);
				jedis.setex(newTicket, 60*60*2, userJson);
				//设置有效的ticket使用
				jedis.setex(loginKey, 60*60*2, newTicket);
				if(exist.getJsid()!=2) {
					System.out.println("老师或管理员登录");
					sysResult.setData(newTicket);
					sysResult.setMsg("教师或管理管登录成功");
					sysResult.setStatus(200);				
				}else if(exist.getJsid()==2){
					System.out.println("学生登录");
					sysResult.setData(newTicket);
					sysResult.setMsg("学生登录成功");
					sysResult.setStatus(201);
				}	
				return sysResult;
			}catch (Exception e) {
				e.printStackTrace();
				return SysResult.build(500, "账号或密码错误", "");
			}
		}
	
	public String queryUserJson(String ticket) {
		//ShardedJedis jedis = pool.getResource();
		Jedis jedis=new Jedis("39.105.166.3",6379);
		String userJson="";
		try{
			//首先判断超时剩余时间
			Long leftTime = jedis.pttl(ticket);
			System.out.println("查询剩余时间="+leftTime);
			//少于10分钟,延长5分钟
			if(leftTime<1000*60*10l){
				System.out.println("少于十分钟了，再加5分钟");
				jedis.pexpire(ticket,leftTime+1000*60*5);
			}
			userJson=jedis.get(ticket);
			System.out.println("返回user对象信息");
			return userJson;
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
	
//	//登录
//	public User doLogin(String uname,String pwd) {
//		return userMapper.queryUser(uname,pwd);
//	}
	//管理员改密码查询
	public JsonResult userListPwd(Integer page, Integer limit, String xh){
		JsonResult jsonResult=new JsonResult();
		//System.out.println("进入userService");
		
		try {
			long count=userMapper.countUser();
			//System.out.println("总条数="+count);
			Integer start=(page-1)*limit;
			Integer size=limit;	
			List<User> list=userMapper.userListPwd(start, size, xh);
			//System.out.println("user对象"+list);
			jsonResult.setCount(count);
			jsonResult.setData(list);
			//System.out.println("Data中user对象信息"+jsonResult.getData());
			jsonResult.setCode("0");
			jsonResult.setMsg("响应成功");
		} catch (Exception e) {
			jsonResult.setCode("1");
			jsonResult.setMsg("查询失败");
			e.printStackTrace();
		}
		return jsonResult;
	}
	//管理员直接修改密码
	public SysResult pwdEditManage(Integer id, String password1, String password2) {
		SysResult sysResult=new SysResult();
		try {
			if(password1.equals(password2)) {
				//System.out.println("两次密码一样进入service体");
				String mm=password2;
				//System.out.println("新设置的密码mm"+mm);
				int affect=userMapper.pwdEditManage(id,mm);
				//System.out.println("执行完mapper，受影响行数："+affect);
				if(affect==1) {
					sysResult.setStatus(200);
					sysResult.setMsg("修改密码成功");
					System.out.println("sysResult对象"+sysResult);
				}else {
					sysResult.setStatus(201);
					sysResult.setMsg("修改密码失败");
				}
			}else {
				sysResult.setStatus(201);
				sysResult.setMsg("修改密码失败,两次密码不一致");
			}		
		} catch (Exception e) {
			sysResult.setStatus(500);
			sysResult.setMsg("服务错误");
			e.printStackTrace();
		}
		return sysResult;
	}

	//查询所有用户
	public JsonResult stuAllList(Integer page, Integer limit, String nianji, String xi, String zhuanye, String banji,
			String xh) {
		JsonResult jsonResult=new JsonResult();
		//System.out.println("进入userService");
		
		try {
			long count=userMapper.countStu(nianji,xi,zhuanye,banji,xh);
			//System.out.println("总条数="+count);
			Integer start=(page-1)*limit;
			Integer size=limit;
			List<UserEntity> list=userMapper.stuAllList(start,size,nianji,xi,zhuanye,banji,xh);
			System.out.println("学生管理Alluser对象"+list);
			jsonResult.setCount(count);
			jsonResult.setData(list);
			//System.out.println("Data中user对象信息"+jsonResult.getData());
			jsonResult.setCode("0");
			jsonResult.setMsg("响应成功");
		} catch (Exception e) {
			jsonResult.setCode("1");
			jsonResult.setMsg("查询失败");
			e.printStackTrace();
		}
		return jsonResult;
	}
	//查询所有教师加管理
	public JsonResult teaAllList(Integer page, Integer limit,String js,String xh) {
		JsonResult jsonResult=new JsonResult();
		//System.out.println("进入userService");
		
		try {
			long count=userMapper.countTea(js,xh);
			//System.out.println("总条数="+count);
			Integer start=(page-1)*limit;
			Integer size=limit;
			List<UserEntity> list=userMapper.teaAllList(start,size,js,xh);
			System.out.println("教师管理Alluser对象"+list);
			jsonResult.setCount(count);
			jsonResult.setData(list);
			//System.out.println("Data中user对象信息"+jsonResult.getData());
			jsonResult.setCode("0");
			jsonResult.setMsg("响应成功");
		} catch (Exception e) {
			jsonResult.setCode("1");
			jsonResult.setMsg("查询失败");
			e.printStackTrace();
		}
		return jsonResult;
	}
	//根据id删除用户信息
	@Override
	public SysResult deleteID(Integer id) {
		SysResult sysResult=new SysResult();
		try {
			Integer affect=userMapper.deleteID(id);
			if(affect==1) {
				sysResult.build(200, "删除成功", "");
			}
		} catch (Exception e) {
			sysResult.build(500, "程序异常,更新失败", "");
			e.printStackTrace();
		}
		return sysResult;
	}

	@Override
	public SysResult editStu(Integer id, String xh, String zsxm, String xb, String bj) {
		SysResult sysResult=new SysResult();
		try {		
			List<BjEntity> list=userMapper.getClassId(bj);
			String bjid=list.get(0).getId();
			Integer affect=userMapper.editStu(id,xh,zsxm,xb,bjid);
			if(affect==1) {
				sysResult.build(200, "修改成功", "");
			}
		} catch (Exception e) {
			sysResult.build(500, "程序异常,更新失败", "");
			e.printStackTrace();
		}
		return sysResult;
	}

	@Override
	public SysResult editTea(Integer id, String xh, String zsxm, String xb) {
		SysResult sysResult=new SysResult();
		try {						
			Integer affect=userMapper.editTea(id,xh,zsxm,xb);
			if(affect==1) {
				sysResult.build(200, "删除成功", "");
			}
		} catch (Exception e) {
			sysResult.build(500, "程序异常,更新失败", "");
			e.printStackTrace();
		}
		return sysResult;
	}

	@Override
	//判断是否有班级字段确定为插入学生或者老师
	public SysResult addUser(Integer xh, String zsxm, String xb, String bj) {
		SysResult sysResult=new SysResult();
		try {
			Integer jsid;
			if(bj != null && bj != "") {
				List<BjEntity> list=userMapper.getClassId(bj);
				String bjid=list.get(0).getId();
				jsid=2;
				Integer affect=userMapper.addStu(xh,jsid,zsxm,xb,bjid);
				if(affect==1) {
					sysResult.build(200, "添加成功", "");
				}
			}else {
				jsid=1;
				Integer affect=userMapper.addTea(xh,jsid,zsxm,xb);
				if(affect==1) {
					sysResult.build(200, "添加成功", "");
				}
			}
		} catch (Exception e) {
			sysResult.build(500, "程序异常,添加失败", "");
			e.printStackTrace();
		}
		return sysResult;
	}
	
	
	
}
