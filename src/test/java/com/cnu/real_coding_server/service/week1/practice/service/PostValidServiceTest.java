package com.cnu.real_coding_server.service.week1.practice.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.cnu.real_coding_server.service.valid.PostValidService;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
public class PostValidServiceTest {

    @Autowired
    PostValidService postValidService;

    @Autowired
    ObjectMapper mapper;

    @DisplayName("post 제목에 비속어가 있나 테스트")
    @Test
    void testValidPostIncludeSlangInTitle() {
        // given
        String testTitle = "비속어와 욕이 섞인 제목";
        String testContent = "정상적인 글";
        List<String> slangList = List.of("비속어", "욕");
        // when postValidService 에 제목에 비속어가 있는지 확인하는 함수를 만들어 실행 결과 반환
        // then 결과가 true인지 확인

        boolean validPost = postValidService.isSlangInclude(slangList, testTitle, testContent);
        assertThat(validPost).isEqualTo(true);
    }

    @DisplayName("post 본문에 비속어가 있나 테스트")
    @Test
    void testValidPostIncludeSlangInContent() {
        String testTitle = "일반적인 제목";
        String testContent = "비속어가 섞인 제목";
        List<String> slangList = List.of("비속어", "비속어같지만일반어", "욕");
        // when postValidService 에 본문에 비속어가 있는지 확인하는 함수를 만들어 실행 결과 반환
        // then 결과가 true인지 확인

        boolean validPost = postValidService.isSlangInclude(slangList, testTitle, testContent);
        assertThat(validPost).isEqualTo(true);
    }
}
