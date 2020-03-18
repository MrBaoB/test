package yzk.classs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import yzk.common.pojo.Classs;

public interface ClasssMapper {
   // 添加班级
	void insertClass(Classs cla);
	//查询所有
	//查询年级
	List<String> selectDataGrade();
	// 查询系
    List<String> selectDataXi(@Param("cxnj")String cxnj);
    //查询专业
	List<String> selectDataZhuanYe(@Param("cxnj")String cxnj, @Param("cxxi")String cxxi);
	long countBan();
	List<Classs> searchBanJi(@Param("start") Integer start,@Param("size") Integer size,@Param("nianji") String nianji,@Param("xi") String xi,@Param("zhuanye") String zhuanye);
	void deleteById(@Param("id") Integer id);
	List<String> selectDataBj();

	

}
