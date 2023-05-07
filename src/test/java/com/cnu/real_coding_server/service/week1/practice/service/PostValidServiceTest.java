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
    void testValidPostTitleAndContentIncludeSlang() {
        // given 시나리오
        String testTitle = "비속어가 섞인 제목";
        String testContent = "비속어가 섞인 욕";
        List<String> slangList = List.of("비속어", "비속어2");

        boolean validPost = postValidService.isSlangInclude(slangList, testTitle, testContent);
        // then 검증
        assertThat(validPost).isEqualTo(true);
    }

    @DisplayName("post 제목 비속어가 있나 테스트")
    @Test
    void testValidPostTitleIncludeSlang() {
        // given 시나리오
        String testTitle = "비속어가 섞인 제목";
        List<String> slangList = List.of("비속어", "비속어2");

        boolean validPost = postValidService.isSlangIncludeTitle(slangList, testTitle);
        // then 검증
        assertThat(validPost).isEqualTo(true);
    }


    @DisplayName("post 본문에 비속어가 있나 테스트")
    @Test
    void testValidPostContentIncludeSlang() {
        // given 시나리오
        String testContent = "비속어가 섞인 욕";
        List<String> slangList = List.of("비속어", "비속어2");

        boolean validPost = postValidService.isSlangIncludeContent(slangList, testContent);
        // then 검증
        assertThat(validPost).isEqualTo(true);
    }

}


/*
명세란 무엇일까?
- 소프트웨어 개발 프로세스의 시작 요구사항을 분석하고 정의하는 단계에서 작성되는 최종 산출물

단위 테스트에서 Given/When/Then에 대해 설명하시오
- Given: 시나리오, 테스트를 준비하는과정, 테스트에 필요한 변수, 입력값을 준비하는 단계이다.
- When: 실행, 실제로 테스트를 실행해보는 단계이다.
- Then: 검증, 마지막으로 테스트를 검증하는 단계, 예상값과 테스트 결과값을 비교하여 검증한다.

테스트 코드를 작성하는 이유는?
- 동작, 데이터등이 내가 의도한대로 처리가 되는지 확인하기 위해.

@SpringBootTest가 하는 역할은?
- 애플리케이션을 시작하고 테스트를 실행하는 역할.

@Test가 하는 역할은?
- 테스트를 사용한다.

mockito를 쓰는 이유는?
- 객체를 쉽게만들고, 관리하고, 검증하기 위해

assertAll가 하는 역할은?
- 객체 내무 데이터를 확인및 데스트하기 위해

 */