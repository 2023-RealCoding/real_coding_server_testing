package com.cnu.real_coding_server.service.valid;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TitleValidService {
    public boolean isSlangInclude(List<String> slangList,
                                  String title) {
        for (String slang : slangList) {
            if(title.contains(slang)) {
                return true;
            }
        }
        return false;
    }
}