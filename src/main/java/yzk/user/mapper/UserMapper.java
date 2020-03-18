package yzk.user.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;


import yzk.common.pojo.User;
import yzk.user.formEntity.BjEntity;
import yzk.user.formEntity.UserEntity;

public interface UserMapper {
	//登录
	User queryUser(@Param("uname") String uname,@Param("pwd")String pwd);
	//查找所有用户
    List<User> userListPwd(@Param("start")Integer start, @Param("size")Integer size,@Param("xh") String xh);
	//查询总条数
    long countUser();
    //管理员改密码
	int pwdEditManage(@Param("id")Integer id,@Param("mm")String mm);
	List<UserEntity> stuAllList(@Param("start")Integer start, @Param("size")Integer size,  
			@Param("nianji")String nianji,  @Param("xi")String xi,  @Param("zhuanye")String zhuanye, 
			 @Param("banji")String banji, @Param("xh")String xh);
	//查询学生总条数
	long countStu(@Param("nianji")String nianji, @Param("xi")String xi, @Param("zhuanye")String zhuanye, @Param("banji")String banji, @Param("xh")String xh);
	long countTea(@Param("js")String js, @Param("xh")String xh);
	List<UserEntity> teaAllList(@Param("start")Integer start, @Param("size")Integer size, @Param("js")String js, @Param("xh")String xh);
	Integer deleteID(@Param("id")Integer id);
	Integer editStu(@Param("id")Integer id, @Param("xh")String xh, @Param("zsxm")String zsxm, @Param("xb")String xb, @Param("bjid")String bjid);
	List<BjEntity> getClassId(@Param("bj")String bj);
	Integer editTea(@Param("id")Integer id, @Param("xh")String xh, @Param("zsxm")String zsxm, @Param("xb")String xb);
	Integer addStu(@Param("xh")Integer xh,@Param("jsid")Integer jsid, @Param("zsxm")String zsxm, @Param("xb")String xb, @Param("bjid")String bjid);
	Integer addTea(@Param("xh")Integer xh,@Param("jsid")Integer jsid, @Param("zsxm")String zsxm, @Param("xb")String xb);

	
	
}