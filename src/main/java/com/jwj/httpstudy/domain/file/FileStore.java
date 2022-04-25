package com.jwj.httpstudy.domain.file;

import com.jwj.httpstudy.web.file.dto.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.jwj.httpstudy.utils.FileUtils.getFullPath;

@Component
public class FileStore {

    @Value("${file.dir}")
    private String fileDir;

    public List<UploadFile> storeFiles(List<MultipartFile> files) throws IOException {
        List<UploadFile> storeFileResult = new ArrayList<>();

        for(MultipartFile file : files){
            if(!file.isEmpty()){
                storeFileResult.add(storeFile(file));
            }
        }
        return storeFileResult;
    }

    // MultipartFile을 받아서 파일 저장 후, 경로를 저장한 UploadFile을 반환
    public UploadFile storeFile(MultipartFile file) throws IOException{
        if(file.isEmpty()) return null;
        return isImageFile(file) ? storeImageFile(file) : storeNormalFile(file);
    }

    private UploadFile storeNormalFile(MultipartFile file) throws IOException {
        UploadFile uploadFile = parseFile(file);
        file.transferTo(new File(getFullPath(fileDir, uploadFile.getStoreFileName())));
        return uploadFile;
    }

    private UploadFile storeImageFile(MultipartFile file) throws IOException{
        UploadFile uploadFile = parseFile(file);
        file.transferTo(new File(getFullPath(fileDir, uploadFile.getStoreFileName())));
        return uploadFile;
    }

    private UploadFile parseFile(MultipartFile file) {
        String originalFilename = createOriginalFilename(file.getOriginalFilename()); // 클라이언트로부터 받은 파일명
        String storeFilename = createStoreFilename(originalFilename);
        return new UploadFile(originalFilename, storeFilename);
    }

    private String createStoreFilename(String originalFilename) {
        return UUID.randomUUID().toString() + '.' + extractExt(originalFilename);
    }

    private String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }

    private String createOriginalFilename(String originalFilename){
        // IE나 Edge는 전체 경로가 들어오므로 substring 처리
        int lastIndex = originalFilename.lastIndexOf("\\" + 1);
        return (lastIndex < 1) ? originalFilename : originalFilename.substring(lastIndex);
    }

    private boolean isImageFile(MultipartFile file){
        return (file != null) ? !file.isEmpty() && file.getContentType().startsWith("image") : false;
    }
}
