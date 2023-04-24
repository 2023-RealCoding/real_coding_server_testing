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


    @DisplayName("post 제목/본문에 비속어가 있나 테스트")
    @Test
    void testValidPostIncludeSlang() {
        // given 시나리오
        String testTitle = "비속어가 섞인 제목";
        String testContent = "비속어가 섞인 욕";
        List<String> slangList = List.of("비속어", "비속어2");

        boolean validPost = postValidService.isSlangInclude(slangList, testTitle, testContent);
        // then 검증
        assertThat(validPost).isEqualTo(true);
    }

    @DisplayName("Post 제목에 비속어 있나 테스트")
    @Test
    void PostTitleIncludeSlang() {
        String title = "비속어 포함 제목";
        String content = "정상 본문";
        List<String> slangList = List.of("비속어", "비속어2");

        boolean slangInclude = postValidService.isSlangInclude(slangList, title, content);

        assertThat(slangInclude).isEqualTo(true);
    }

    @DisplayName("Post 본문에 비속어 있나 테스트")
    @Test
    void PostContentIncludeSlang() {
        String title = "정상 제목";
        String content = "비속어 포함 본문";
        List<String> slangList = List.of("비속어", "비속어2");

        boolean slangInclude = postValidService.isSlangInclude(slangList, title, content);

        assertThat(slangInclude).isEqualTo(true);
    }
}
