package com.thinkhub.component.gateway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GatewayApplicationTests {

    @Test
    public void contextLoads() {

    }
    private static final String GATEWAY_ROUTES = "gateway_routes::";
    protected static Logger LOGGER = LoggerFactory.getLogger(GatewayApplicationTests.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis(){
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("testkey","testvalue");
        String testkey = stringStringValueOperations.get("testkey");
        LOGGER.info(testkey);

        Set<String> gatewayKeys = stringRedisTemplate.keys(GATEWAY_ROUTES + "*");
    }
}
