package yzk.classs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import yzk.classs.service.ClasssService;
import yzk.common.pojo.Classs;
import yzk.common.vo.JsonResult;
import yzk.common.vo.SysResult;

@RestController
@RequestMapping("user/manage")
public class ClasssController {
	@Autowired
	private ClasssService classsService;	
	List<String> data;//列表
	@ResponseBody
	@CrossOrigin
	@RequestMapping("/add")
	public SysResult addClass(String nianji,String xi,String zhuanye,String banji){
	    try {
			Classs cla = new Classs();
			cla.setNjmc(nianji);
			cla.setXi(xi);
			cla.setZymc(zhuanye);
			cla.setBjmc(banji);
			System.out.println(cla.getNjmc()+cla.getXi()+cla.getZymc()+cla.getBjmc());
			classsService.insertClass(cla);
			return SysResult.ok();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return SysResult.build(201, "","");
			
		}
		
	}
	@ResponseBody
	@CrossOrigin
	@RequestMapping("/grade")
	public Map<Integer,List<String>> gradeList(@RequestParam String cxnj,@RequestParam String cxxi) {
		Map<Integer,List<String>> getMC = new HashMap<Integer,List<String>>(); 
		
		try {
			if(cxnj == null || "".equals(cxnj.trim())){

				data = classsService.selectData1();
			}else if(cxnj.substring(cxnj.length()-1).equals("级") ){
				if(cxxi != null && cxxi.length()!= 0){
					System.out.println("查专业");
					data = classsService.selectData3(cxnj,cxxi);
				}else{
					System.out.println("查系");
				    data = classsService.selectData2(cxnj);
				}
				
			}else if(cxnj.equals("年")&&cxxi.equals("级")){
				System.out.println("查询班级");
				data = classsService.selectBj();
			}
			getMC.put(200,data);
			return getMC;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data.add("null");
			getMC.put(201,data);
			return  getMC;
		}
	}
	@ResponseBody
	@CrossOrigin
	@RequestMapping("/banji")
	public JsonResult banjiList(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit,String nianji,String xi,String zhuanye){
		return classsService.searchBanJi(page, limit,nianji,xi,zhuanye);
	}
	
	@ResponseBody
	@CrossOrigin
	@RequestMapping("/deleterow")
	public SysResult deleteRow(Integer id){
		try {
			classsService.deleteById(id);
			return SysResult.ok();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return SysResult.build(201,"failed" , "");
		}
	}
}

