package com.example.kit.redis.config.jedis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

@Slf4j
@Configuration
public class JedisConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;

    @Bean
    public JedisPool jPool() {
        JedisPoolConfig jpConf = new JedisPoolConfig();
        jpConf.setMinIdle(minIdle);
        jpConf.setMaxIdle(maxIdle);
        jpConf.setMaxTotal(maxActive);

        JedisPool jPool = new JedisPool(jpConf, host, port, timeout, password);
        log.info("JedisPool连接成功:{}\t{}", host, port);
        return jPool;
    }

    private static final String DEFAULT_REDIS_PROPERTIES = "redis";
    private static ResourceBundle REDIS_CONF = ResourceBundle.getBundle(DEFAULT_REDIS_PROPERTIES);

    public static String getConfProperty(String key) {
        return REDIS_CONF.getString(key);
    }


}
