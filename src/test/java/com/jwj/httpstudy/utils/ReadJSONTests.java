package com.jwj.httpstudy.utils;

import com.jwj.httpstudy.web.member.dto.MemberRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static com.jwj.httpstudy.utils.JSONReadUtils.*;
import static com.jwj.httpstudy.utils.JSONReadUtils.readJSONList;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ReadJSONTests {

    @Test
    @DisplayName("Member 초기화 JSON 파읽 읽기 (여러 건)")
    public void readMemberInitData() throws IOException {
        // given
        String filePath = "initData/memberInitData.json";
        // when
        List<MemberRequestDto> list = readJSONList(filePath, MemberRequestDto.class);
        // then
        assertThat(list).isNotEmpty();
        assertThat(list.size()).isGreaterThan(0);
        assertThat(list.get(0).getClass()).isEqualTo(MemberRequestDto.class);
    }

    @Test
    @DisplayName("Member 초기화 JSON 파읽 읽기 (1건)")
    public void readMemberInitData2() throws IOException {
        // given
        String filePath = "initData/memberInitData2.json";
        // when
        MemberRequestDto dto = readJSON(filePath, MemberRequestDto.class);
        // then
        assertThat(dto).isNotNull();
    }
}
