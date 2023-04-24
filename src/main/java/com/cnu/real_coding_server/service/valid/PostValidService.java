package com.cnu.real_coding_server.service.valid;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PostValidService {
    public boolean isSlangIncludeinTitle(List<String> slangList, String title) {
        for (String slang : slangList) {
            if(title.contains(slang)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSlangIncludeinContent(List<String> slangList, String postContent) {
        for (String slang : slangList) {
            if(postContent.contains(slang)) {
                return true;
            }
        }
        return false;
    }

}
