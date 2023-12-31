package com.example.kit.redis;

import com.example.kit.redis.config.jedis.JedisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@SpringBootTest
class KitRedisApplicationTests {

    @Autowired
    private JedisPool jedisPool;

    @Test
    void contextLoads() {

        Jedis jedis = jedisPool.getResource();
        jedis.set("world", "bin");
        jedis.close();




    }

}
