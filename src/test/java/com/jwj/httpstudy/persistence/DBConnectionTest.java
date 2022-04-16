package com.jwj.httpstudy.persistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class DBConnectionTest {

    @Autowired
    DataSource dataSource;

    @Test
    @DisplayName("DB 연결 테스트")
    public void dBConnectionTest() throws Exception{
        assertThat(dataSource).isNotNull();
    }

}
