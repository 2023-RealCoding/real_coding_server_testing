package com.cnu.real_coding_server.service.week1.practice.service;

import com.cnu.real_coding_server.entity.Post;
import com.cnu.real_coding_server.error.SlangBadRequestException;
import com.cnu.real_coding_server.model.request.PostRequest;
import com.cnu.real_coding_server.model.type.Tag;
import com.cnu.real_coding_server.service.PostService;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PostServiceTest {
    @Autowired
    private PostService postService;

    @Autowired
    private ObjectMapper mapper;

    @DisplayName("post 제목에 비속어가 있나 테스트")
    @Transactional
    @Test
    void createPostWithSlangInTitle() throws JsonProcessingException {
        String title = "비속어1 포함된 제목";
        String content = "정상 본문";
        Tag tag = Tag.SPRINGBOOT;
        PostRequest postRequest = mapper.readValue(
                """
                        {
                            "title": "%s",
                            "contents": "%s",
                            "tag": "%s"
                        }
                        """.formatted(title, content, tag)
                , PostRequest.class);
        assertThrows(SlangBadRequestException.class, () -> postService.createPost(postRequest));
    }

    @DisplayName("post 본문에 비속어가 있나 테스트")
    @Transactional
    @Test
    void createPostWithSlangInContent() throws JsonProcessingException {
        String title = "정상 제목";
        String content = "비속어2 포함된 본문";
        Tag tag = Tag.SPRINGBOOT;
        PostRequest postRequest = mapper.readValue(
                """
                        {
                            "title": "%s",
                            "contents": "%s",
                            "tag": "%s"
                        }
                        """.formatted(title, content, tag)
                , PostRequest.class);
        assertThrows(SlangBadRequestException.class, () -> postService.createPost(postRequest));
    }


}
