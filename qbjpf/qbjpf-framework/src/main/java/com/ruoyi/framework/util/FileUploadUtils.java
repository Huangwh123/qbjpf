package com.ruoyi.framework.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.ruoyi.common.base.AjaxResult;
import org.apache.tomcat.util.http.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.exception.file.FileNameLengthLimitExceededException;
import com.ruoyi.common.utils.Md5Utils;

/**
 * 文件上传工具类
 * 
 * @author ruoyi
 */
public class FileUploadUtils {
    /**
     * 默认大小 50M
     */
    public static final long DEFAULT_MAX_SIZE = 52428800;

    /**
     * 默认上传的地址
     */
    private static String defaultBaseDir = Global.getProfile();

    /**
     * 默认的文件名最大长度
     */
    public static final int DEFAULT_FILE_NAME_LENGTH = 200;

    /**
     * 默认文件类型jpg
     */
    public static final String IMAGE_JPG_EXTENSION = ".jpg";

    private static int counter = 0;

    public static void setDefaultBaseDir(String defaultBaseDir) {
        FileUploadUtils.defaultBaseDir = defaultBaseDir;
    }

    public static String getDefaultBaseDir() {
        return defaultBaseDir;
    }

    /**
     * 以默认配置进行文件上传
     *
     * @param file 上传的文件
     * @return 文件名称
     * @throws Exception
     */
    public static final String upload(MultipartFile file) throws IOException {
        try {
            return upload(getDefaultBaseDir(), file, FileUploadUtils.IMAGE_JPG_EXTENSION);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    /**
     * 根据文件路径上传
     *
     * @param baseDir 相对应用的基目录
     * @param file    上传的文件
     * @return 文件名称
     * @throws IOException
     */
    public static final String upload(String baseDir, MultipartFile file) throws IOException {
        try {
            return upload(baseDir, file, FileUploadUtils.IMAGE_JPG_EXTENSION);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    /**
     * 文件上传
     *
     * @param baseDir                   相对应用的基目录
     * @param file                      上传的文件
     * @param extension                 上传文件类型
     * @return 返回上传成功的文件名
     * @throws FileSizeLimitExceededException       如果超出最大大小
     * @throws FileNameLengthLimitExceededException 文件名太长
     * @throws IOException                          比如读写文件出错时
     */
    public static final String upload(String baseDir, MultipartFile file, String extension)
            throws FileSizeLimitExceededException, IOException, FileNameLengthLimitExceededException {
        int fileNamelength = file.getOriginalFilename().length();
        if (fileNamelength > FileUploadUtils.DEFAULT_FILE_NAME_LENGTH) {
            throw new FileNameLengthLimitExceededException(file.getOriginalFilename(), fileNamelength,
                    FileUploadUtils.DEFAULT_FILE_NAME_LENGTH);
        }

        assertAllowed(file);

        String fileName = encodingFilename(file.getOriginalFilename(), extension);

        File desc = getAbsoluteFile(baseDir, baseDir + fileName);
        file.transferTo(desc);
        return fileName;
    }

    private static final File getAbsoluteFile(String uploadDir, String filename) throws IOException {
        File desc = new File(File.separator + filename);

        if (!desc.getParentFile().exists()) {
            desc.getParentFile().mkdirs();
        }
        if (!desc.exists()) {
            desc.createNewFile();
        }
        return desc;
    }

    /**
     * 编码文件名
     */
    private static final String encodingFilename(String filename, String extension) {
        filename = filename.replace("_", " ");
        filename = Md5Utils.hash(filename + System.nanoTime() + counter++) + extension;
        return filename;
    }

    /**
     * 文件大小校验
     *
     * @param file 上传的文件
     * @return
     * @throws FileSizeLimitExceededException 如果超出最大大小
     */
    public static final void assertAllowed(MultipartFile file) throws FileSizeLimitExceededException {
        long size = file.getSize();
        if (DEFAULT_MAX_SIZE != -1 && size > DEFAULT_MAX_SIZE) {
            throw new FileSizeLimitExceededException("not allowed upload upload", size, DEFAULT_MAX_SIZE);
        }
    }

    public static final String uploadImgCos(MultipartFile file) {
        String fileName = "";
        String key = "/coupon/"+new Date().getTime() + ".png"  ;
        COSClient  cosClient = TencentCosUntils.getCosConnect();
        try {
            byte[] bytes = file.getBytes();
            InputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectMetadata objectMetadata = new ObjectMetadata();
            PutObjectRequest putObjectRequest = new PutObjectRequest(TencentCosUntils.bucketName, key,byteArrayInputStream, objectMetadata);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            fileName = TencentCosUntils.CosHost+key;
            }catch (Exception e ){
                e.printStackTrace();
        }
            // 关闭客户端(关闭后台线程)
             cosClient.shutdown();
            return fileName;
    }
    public static final AjaxResult deleteImgCos(String key) {
        AjaxResult ajaxResult = new AjaxResult();
        COSClient cosClient = TencentCosUntils.getCosConnect();
        try {
        // 指定文件在 COS 上的对象键
            cosClient.deleteObject(TencentCosUntils.bucketName, key);
            ajaxResult.put("code" ,0);
            ajaxResult.put("msg","成功");
        }catch (Exception e ){
            e.printStackTrace();
            ajaxResult.put("code" ,-1);
            ajaxResult.put("msg","删除失败");
        }
        // 关闭客户端(关闭后台线程)
        cosClient.shutdown();
        return  ajaxResult;
    }
}
