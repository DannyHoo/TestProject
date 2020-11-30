package com.example.service;

import com.example.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * mime type https://www.w3school.com.cn/media/media_mimeref.asp
 * https://blog.csdn.net/u011271202/article/details/37915213
 * https://blog.csdn.net/ryelqy/article/details/74980549
 */
@Slf4j
@Service

public class FileUploadService {

    @Autowired
    private HttpServletRequest httpServletRequest;

    public Result fileUploadFormData(MultipartFile file) {
        if (file == null) {
            return Result.error();
        }
        String fileName = file.getOriginalFilename();
        String url;
        try {
            byte[] content = file.getBytes();
            System.out.println("fileUploadFormData. fileType:" + getFileType(content));

        } catch (IOException ex) {
        }
        return Result.success();
    }

    private static boolean isBMP(byte[] buf) {
        byte[] markBuf = "BM".getBytes();  //BMP图片文件的前两个字节
        return compare(buf, markBuf);
    }

    private static boolean isICON(byte[] buf) {
        byte[] markBuf = {0, 0, 1, 0, 1, 0, 32, 32};
        return compare(buf, markBuf);
    }

    private static boolean isWEBP(byte[] buf) {
        byte[] markBuf = "RIFF".getBytes(); //WebP图片识别符
        return compare(buf, markBuf);
    }

    private static boolean isGIF(byte[] buf) {
        byte[] markBuf = "GIF89a".getBytes(); //GIF识别符
        if (compare(buf, markBuf)) return true;
        markBuf = "GIF87a".getBytes(); //GIF识别符
        if (compare(buf, markBuf)) return true;
        return false;
    }

    private static boolean isPNG(byte[] buf) {
        byte[] markBuf = {(byte) 0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A}; //PNG识别符
        return compare(buf, markBuf);
    }

    private static boolean isDOC(byte[] buf) {
        byte[] markBuf = {-48, -49}; //PNG识别符
        return compare(buf, markBuf);
    }

    private static boolean isDOCX(byte[] buf) {
        byte[] markBuf = {80, 75}; //PNG识别符
        return compare(buf, markBuf);
    }

    private static boolean isJPEGHeader(byte[] buf) {
        byte[] markBuf = {(byte) 0xff, (byte) 0xd8}; //JPEG开始符
        return compare(buf, markBuf);
    }

    private static boolean isJPEGFooter(byte[] buf) {//JPEG结束符
        byte[] markBuf = {(byte) 0xff, (byte) 0xd9};
        return compare(buf, markBuf);
    }

    private static boolean isTiff(byte[] buf) {
        byte[] markBuf = {(byte) 0x4D, (byte) 0x4D};
        if (compare(buf, markBuf)) return true;

        byte[] markBuf1 = {(byte) 0x49, (byte) 0x49};
        return compare(buf, markBuf1);
    }

    private static boolean isPdf(byte[] buf) {
        byte[] markBuf = {(byte) 0x25, (byte) 0x50, (byte) 0x44};
        return compare(buf, markBuf);
    }

    private static boolean compare(byte[] buf, byte[] markBuf) {
        for (int i = 0; i < markBuf.length; i++) {
            byte b = markBuf[i];
            byte a = buf[i];
            if (a != b) return false;
        }
        return true;
    }

    public String getFileType(byte[] b) {
        if (b.length < 10) return "";
        if (isDOC(b)) return "doc";
        if (isDOCX(b)) return "docx";
        if (isPNG(b)) return "png";
        if (isGIF(b)) return "gif";
        if (isWEBP(b)) return "webp";
        if (isBMP(b)) return "bmp";
        if (isICON(b)) return "ico";
        if (isTiff(b)) return "tiff";
        if (isPdf(b)) return "pdf";
        if (isJPEGHeader(b)) {
            byte[] end = new byte[2];
            end[0] = b[b.length - 2];
            end[1] = b[b.length - 1];
            if (isJPEGFooter(end)) return "jpeg";
        }
        return "";
    }

    public String fileTypeToContentType(String fileType) {
        if (fileType == null || fileType.length() == 0) return "text/plain";
        if ("gif".equals(fileType)) return "image/gif";
        if ("png".equals(fileType)) return "image/png";
        if ("jpg".equals(fileType)) return "image/jpeg";
        if ("bmp".equals(fileType)) return "image/bmp";
        if ("ico".equals(fileType)) return "image/ico";
        if ("webp".equals(fileType)) return "image/webp";
        if ("tiff".equals(fileType)) return "image/tiff";
        if ("pdf".equals(fileType)) return "application/pdf";
        return "text/plain";
    }

}
