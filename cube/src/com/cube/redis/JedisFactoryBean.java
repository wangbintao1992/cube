package com.cube.redis;

import org.springframework.beans.factory.FactoryBean;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisFactoryBean implements FactoryBean<Jedis>{
	private static JedisPool pool = null;  
	private String host;
	
	public static void returnResource(JedisPool pool, Jedis redis) {  
        if (redis != null) {  
            pool.returnResource(redis);
        }  
    }
	public Jedis getObject() throws Exception {
		if (pool == null) {  
            pool = new JedisPool(new JedisPoolConfig(),host);
        }  
        return pool.getResource();  
	}

	public Class<Jedis> getObjectType() {
		return Jedis.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}  
}
