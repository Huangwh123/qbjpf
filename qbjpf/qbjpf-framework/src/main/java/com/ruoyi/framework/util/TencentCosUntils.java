package com.ruoyi.framework.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;

public class TencentCosUntils {
    /**
     * tx appid
     */
    public final static  String APPID="1258366811";

    /**
     * tx SecretId
     */
    public final static  String SecretId ="AKIDaO2M1aKbDkJoGZvk0KaUEsPzTOFwwai2";

    /**
     * tx SecretKey
     */
    public final static  String SecretKey  ="VtNm64xhGi2ykOwQsNrNjvy3255xiidS";

    /**
     * tx CosHost
     */
    public final static  String CosHost ="https://qbjpf-1258366811.cos.ap-guangzhou.myqcloud.com";

    /**
     * tx bucketName
     */
    public final static   String bucketName = "qbjpf-1258366811";
    /**
     * tx regionName
     */
    public final static  String regionName ="ap-guangzhou";
    public static COSClient getCosConnect(){
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(SecretId,SecretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig中包含了设置region, https(默认http), 超时, 代理等set方法, 使用可参见源码或者接口文档FAQ中说明
        ClientConfig clientConfig = new ClientConfig(new Region(regionName));
        // 3 生成cos客户端
        COSClient cosClient = new COSClient(cred, clientConfig);
        return  cosClient;
    }
}
