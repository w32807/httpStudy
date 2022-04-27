package com.jwj.httpstudy.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.CacheControl;

@Slf4j
public class CacheTest {

    @Test
    @DisplayName("캐시 컨트롤 테스트")
    public void cacheControlTest() throws Exception{
        // given
        CacheControl cc = CacheControl.noCache();
        //cc = CacheControl.maxAge(5, TimeUnit.MINUTES);
        // when
        String headerValue = cc.getHeaderValue();
        // then
        log.info("headerValue {}", headerValue);
    }

}
