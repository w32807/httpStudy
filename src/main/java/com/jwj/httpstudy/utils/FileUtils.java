package com.jwj.httpstudy.utils;

import java.io.File;
import java.time.LocalDate;
import java.util.UUID;

import static java.time.format.DateTimeFormatter.ofPattern;

public class FileUtils {

    // Static으로만 사용할 클래스는 클래스의 생성자를 외부에서 호출할 수 없도록 막기
    private FileUtils() {
        throw new AssertionError();
    }

    public static String getFullPath(String filePath, String fileName) {
        return filePath + File.separator + makeFolder(filePath) + File.separator + fileName;
    }

    public static String createStoreFileName(String originalFileName){
        String today = LocalDate.now().format(ofPattern("yyyy-MM-dd"));
        return UUID.randomUUID().toString() + "_" + today + "." + extractExt(originalFileName);
    }

    public static String extractExt(String originalFileName) {
        int pos = originalFileName.lastIndexOf(".");
        return originalFileName.substring(pos + 1);
    }

    public static String makeFolder(String filePath){
        String folderPath = LocalDate.now().format(ofPattern("yyyy-MM-dd")).replace("//", File.separator);
        File uploadPathFolder = new File(filePath, folderPath);

        if(!isFileExists(uploadPathFolder)){
            uploadPathFolder.mkdirs();
        }

        return folderPath;
    }

    public static boolean isFileExists(File file){
        return file.exists();
    }
}
