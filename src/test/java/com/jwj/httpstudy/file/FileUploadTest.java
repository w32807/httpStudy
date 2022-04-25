package com.jwj.httpstudy.file;

import com.jwj.httpstudy.domain.file.FileStore;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@SpringBootTest
public class FileUploadTest {

    @Mock
    MockMultipartFile file;

    @Autowired
    FileStore fileStore;

    @Test
    @DisplayName("파일 업로드 테스트")
    public void fileUploadTest() throws Exception{
        fileStore.storeFile(createTextFile());
    }

    @Test
    @DisplayName("이미지 파일 업로드 테스트")
    public void imageFileUploadTest() throws Exception{
        fileStore.storeFile(createImageFile());
    }

    private MockMultipartFile createTextFile() throws IOException {
        return new MockMultipartFile("test",
                "test.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "test content".getBytes(StandardCharsets.UTF_8));
    }

    private MockMultipartFile createImageFile() throws IOException {
        return new MockMultipartFile("test",
                "test.png",
                MediaType.IMAGE_PNG_VALUE,
                "test content".getBytes(StandardCharsets.UTF_8));
    }
}
