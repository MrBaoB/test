/*package yzk.user.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

@Configuration
@ConditionalOnClass({Jedis.class,ShardedJedisPool.class})
@ConfigurationProperties(prefix="redis.cluster")
public class PoolConfigRedis {
	private List<String> nodes;
	//10.9.39.13:6379,10.0.39.13:6380,10.9.39.13:6381
	private Integer maxTotal;
	private Integer maxIdle;
	private Integer minIdle;
	//构造一个连接池初始化的方法
	@Bean
	public ShardedJedisPool initShardPool(){
		//收集节点信息
		List<JedisShardInfo> list=
		new ArrayList<JedisShardInfo>();
		for (String node : nodes) {
			//node="10.9.39.13:6379"
			String host=node.split(":")[0];
			int port=Integer.
			parseInt(node.split(":")[1]);
			list.add(new JedisShardInfo(host,port));
		}
		//配置对象
		GenericObjectPoolConfig config=new 
				GenericObjectPoolConfig();
		config.setMaxIdle(maxIdle);
		config.setMaxTotal(maxTotal);
		config.setMinIdle(minIdle);
		return new ShardedJedisPool(config,list);
	}
	public List<String> getNodes() {
		return nodes;
	}
	public void setNodes(List<String> nodes) {
		this.nodes = nodes;
	}
	public Integer getMaxTotal() {
		return maxTotal;
	}
	public void setMaxTotal(Integer maxTotal) {
		this.maxTotal = maxTotal;
	}
	public Integer getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}
	public Integer getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(Integer minIdle) {
		this.minIdle = minIdle;
	}
	
}
*/