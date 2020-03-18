package yzk.yzk_user;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestRedis {
	
	
	@Test
	public void TestJedisSingle(){
//		Jedis jedis=new Jedis("39.105.166.3",6379);
//		jedis.set("test", "hello jedis");
//		String string=jedis.get("test");
		long time=System.currentTimeMillis();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(time));
//		Integer page=2;
//		Integer limit=10;
//		Integer start=(page-1)*limit;
//		System.out.println(start);
//		System.out.println(limit);
	}
	

}
