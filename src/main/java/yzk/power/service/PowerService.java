package yzk.power.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yzk.common.vo.JsonResult;
import yzk.common.vo.SysResult;
import yzk.power.entity.Power;
import yzk.power.mapper.PowerMapper;

@Service
public class PowerService {
	
	@Autowired
	private PowerMapper powerMapper;
	
	
	public JsonResult powerManage(Integer page, Integer limit, String xh) {
		JsonResult jsonResult=new JsonResult();
		try {
			long count=powerMapper.countPower();
			//System.out.println("总条数="+count);
			Integer start=((page-1)*limit);
			Integer size=limit;	
			List<Power> list=powerMapper.powerManage(start, size, xh);
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

	//修改权限
	public SysResult editPower(Integer jsid, Integer id,String jsxgr) {
		try {
			long time=System.currentTimeMillis();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String jsxgrq=sdf.format(time);
			System.out.println("当前角色为"+jsid);
			Integer ejsid = null;
			if(jsid == 1) {
				ejsid=0;
			}else if(jsid==0){
				ejsid=1;
			}
			System.out.println("修改后jsid为："+ejsid);
			Integer affect=powerMapper.editPower(ejsid,jsxgr,jsxgrq,id);
			if(affect==1) {
				return SysResult.build(200, "用户角色权限修改成功", "");
			}else {
				return SysResult.build(201, "用户角色权限修改失败", "");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return SysResult.build(500, "服务错误", "");
		}
	}

}
