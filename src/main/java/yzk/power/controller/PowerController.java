package yzk.power.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yzk.common.vo.JsonResult;
import yzk.common.vo.SysResult;
import yzk.power.service.PowerService;

@RestController
@RequestMapping("/user/manage")
public class PowerController {
	
	@Autowired
	private PowerService powerService;
	
	//权限管理
	@CrossOrigin
	@RequestMapping("/userPower")
	public JsonResult powerManager(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit,String xh) {
		return powerService.powerManage(page,limit,xh);
	}
	//更改权限
	@CrossOrigin
	@RequestMapping("/editPower")
	public SysResult editPower(Integer jsid,Integer id,String jsxgr){
		System.out.println("要修改的jsid为"+jsid);
		System.out.println("要修改的行号为"+id);
		System.out.println("修改人的名字为"+jsxgr);
		return powerService.editPower(jsid,id,jsxgr);
	}
	
}
