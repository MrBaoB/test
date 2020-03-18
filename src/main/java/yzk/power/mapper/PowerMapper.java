package yzk.power.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import yzk.power.entity.Power;

public interface PowerMapper {
	
	//获得总条数
	long countPower();
	//查询用户权限信息
	List<Power> powerManage(@Param("start")Integer start,@Param("size")Integer size,@Param("xh")String xh);
	//修改权限
	Integer editPower(@Param("ejsid")Integer ejsid,@Param("jsxgr")String jsxgr,
			@Param("jsxgrq")String jsxgrq,@Param("id")Integer id);
	
	
}
