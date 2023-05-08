package com.cnu.real_coding_server.service.week1.practice.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.cnu.real_coding_server.service.valid.ContentValidService;
import com.cnu.real_coding_server.service.valid.PostValidService;
import java.util.List;

import com.cnu.real_coding_server.service.valid.TitleValidService;
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
    TitleValidService titleValidService;
    @Autowired
    ContentValidService contentValidService;


    @DisplayName("post 제목/본문에 비속어가 있나 테스트")
    @Test
    void testValidPostIncludeSlang() {
        // given 시나리오
        String testTitle = "비속어가 섞인 제목";
        String testContent = "비속어가 섞인 욕";
        List<String> slangList = List.of("비속어", "비속어2");
        // when 코드 실행
        boolean validPost = postValidService.isSlangInclude(slangList, testTitle, testContent);
        // then 실행 결과 검증
        assertThat(validPost).isEqualTo(true);
    }

    @DisplayName("post 제목에 비속어가 있나 테스트")
    @Test
    void testValidTitleIncludeSlang() {
        // given 시나리오
        String testTitle = "비속어가 섞인 제목";
        List<String> slangList = List.of("비속어", "비속어2");
        // when 코드 실행
        boolean validTitle = titleValidService.isSlangInclude(slangList, testTitle);
        // then 실행 결과 검증
        assertThat(validTitle).isEqualTo(true);
    }

    @DisplayName("post 본문에 비속어가 있나 테스트")
    @Test
    void testValidContentIncludeSlang() {
        // given 시나리오
        String testContent = "비속어가 섞인 욕";
        List<String> slangList = List.of("비속어", "비속어2");
        // when 코드 실행
        boolean validContent = contentValidService.isSlangInclude(slangList, testContent);
        // then 실행 결과 검증
        assertThat(validContent).isEqualTo(true);
    }


}
