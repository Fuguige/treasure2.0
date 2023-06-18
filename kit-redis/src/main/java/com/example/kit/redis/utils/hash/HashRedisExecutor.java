package com.example.kit.redis.utils.hash;

import redis.clients.jedis.Jedis;

public interface HashRedisExecutor<T> {

    T execute(Jedis jedis);

}


