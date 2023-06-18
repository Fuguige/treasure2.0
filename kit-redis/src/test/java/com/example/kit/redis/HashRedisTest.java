package com.example.kit.redis;

import com.example.kit.redis.utils.hash.HashRedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class HashRedisTest {

    @Test
    public void test() {
        HashRedisUtil redisUtil = HashRedisUtil.getInstance();
        System.out.println(redisUtil.set("keyTest","valueTest"));
        System.out.println(redisUtil.get("keyTest"));
        redisUtil.destroy();
    }

}
