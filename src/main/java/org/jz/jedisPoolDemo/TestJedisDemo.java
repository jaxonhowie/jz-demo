package org.jz.jedisPoolDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Hongyi Zheng
 * @date 2018/6/26
 */
public class TestJedisDemo {

    private static final Logger logger = LoggerFactory.getLogger(TestJedisDemo.class);

    public static void main(String[] args) {
//        Jedis jedis = new Jedis("127.0.0.1",6379);
        Jedis jedis = new Jedis("localhost");
        logger.info("连接成功");
        logger.info("服务正在运行：" + ("PONG".equalsIgnoreCase(jedis.ping())));
        //java.lang.String
        jedis.set("mykey","myvalue");
        logger.info("redis key--{},value--{}","mykey",jedis.get("mykey"));


        //list
        jedis.rpush("lpushKey","ele1");
        jedis.lpush("lpushKey","ele2");
        jedis.lpush("lpushKey","ele3");
        jedis.lpush("lpushKey","ele4");
        jedis.lpush("lpushKey","ele5");
        jedis.lpush("lpushKey","ele6");
        jedis.lpush("lpushKey","ele7");
        jedis.lpush("lpushKey","ele8");
        List<String> list = jedis.lrange("lpushKey",0,-1);
        list.forEach(System.out::println);
        //set
        Set<String> set = jedis.keys("*");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        jedis.select(2);
        jedis.lpush("lpushkey", "asdji");
    }
}
