package com.cnu.real_coding_server.service.valid;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContentValidService {
    public boolean isSlangInclude(List<String> slangList,
                                  String postContent) {
        for (String slang : slangList) {
            if(postContent.contains(slang)) {
                return true;
            }
        }
        return false;
    }
}



