package yzk.classs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yzk.classs.mapper.ClasssMapper;
import yzk.common.pojo.Classs;
import yzk.common.vo.JsonResult;
@Service
public class ClasssService {

	@Autowired
	private ClasssMapper classsMapper;
	
	List<String> data;

	public List<String> gradeList() {
		// TODO Auto-generated method stub
		return null;
	}
	//添加班级
	
	public void insertClass(Classs cla) {
		classsMapper.insertClass(cla);
		
	}
	//获取列表
	
	public List<String> selectData1() {
		System.out.println("nj");
		return data = classsMapper.selectDataGrade();
	}

	public List<String> selectData2(String cxnj) {
		System.out.println("xi");
		return data = classsMapper.selectDataXi(cxnj);
	}

	public List<String> selectData3(String cxnj, String cxxi) {
		System.out.println("zy");
		return data = classsMapper.selectDataZhuanYe(cxnj,cxxi);
	}
	public List<String> selectBj() {
		System.out.println("bj");
		return data=classsMapper.selectDataBj();
	}
	public JsonResult searchBanJi(Integer page, Integer limit, String nianji, String xi, String zhuanye) {
		JsonResult jsonResult=new JsonResult();
		long count=classsMapper.countBan();
		try {
			Integer start=(page-1)*limit;
			Integer size=limit;	
			List<Classs> list=classsMapper.searchBanJi(start, size,nianji,xi,zhuanye);
			jsonResult.setCount(count);
			jsonResult.setData(list);
			jsonResult.setCode("0");
			jsonResult.setMsg("响应成功");
		} catch (Exception e) {
			jsonResult.setCode("1");
			jsonResult.setMsg("查询失败");
			e.printStackTrace();
		}
		return jsonResult;
	}

	public void deleteById(Integer id) {
		classsMapper.deleteById(id);	
	}

	

	

}
