package com.cnu.real_coding_server.service.week1.practice.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.cnu.real_coding_server.service.valid.PostValidService;
import java.util.List;
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


    @DisplayName("post 제목에 비속어가 있나 테스트")
    @Test
    void testValidPostIncludeSlangInTitle() {
        // given 시나리오
        String testTitle = "비속어가 섞인 제목";
        List<String> slangList = List.of("비속어", "비속어같지만일만어");

        boolean validTitle = postValidService.isSlangTitleInclude(slangList, testTitle);
        assertThat(validTitle).isEqualTo(true);

    }
    @DisplayName("post 본문에 비속어가 있나 테스트")
    @Test
    void testValidPostIncludeSlangInContent() {
        // given 시나리오
        String testContent = "비속어가 섞인 제목";
        List<String> slangList = List.of("비속어", "비속어같지만일만어");

        boolean validContent = postValidService.isSlangContentInclude(slangList, testContent);
        assertThat(validContent).isEqualTo(true);
    }
}
