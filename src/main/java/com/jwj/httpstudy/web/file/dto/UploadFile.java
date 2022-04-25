package com.jwj.httpstudy.web.file.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadFile {

    private String uploadFileName; // 화면단에서 보이눈 파일명
    private String storeFileName; // UUID로 시스템 내에서 구분하는 파일명

}
