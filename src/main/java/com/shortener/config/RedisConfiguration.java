package com.shortener.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.shortener.model.ShortenUrlInfo;

@Configuration
public class RedisConfiguration extends CachingConfigurerSupport {

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		 RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost", 6379);
		 return new JedisConnectionFactory(config);
	}

	@Bean
	public RedisTemplate<String, ShortenUrlInfo> redisTemplate() {
        RedisTemplate<String, ShortenUrlInfo> redisTemplate = new RedisTemplate<String, ShortenUrlInfo>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setEnableTransactionSupport(true);
        return redisTemplate;
	}

	@Bean
	public StringRedisTemplate stringRedisTemplate() {
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(redisConnectionFactory());
		stringRedisTemplate.setEnableTransactionSupport(true);
		return stringRedisTemplate;
	}

}
