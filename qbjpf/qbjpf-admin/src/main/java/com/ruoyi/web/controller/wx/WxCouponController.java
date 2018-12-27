package com.ruoyi.web.controller.wx;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.CouponInfo;
import com.ruoyi.system.service.ICouponInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.List;
@Controller
@RequestMapping("/wx")
public class WxCouponController extends BaseController {
    @Autowired
    private ICouponInfoService couponInfoService;
    /**
     * 微信页面优惠卷列表
     * */
    @GetMapping("/couponInfoIndex")
    public String queryCouponList(){
        return "web/coupon/couponIndex";
    }
    @GetMapping("/list")
    @ResponseBody
    public List<CouponInfo> lists(CouponInfo couponInfo)
    {
	/*	response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");*/
        startPage();
        List<CouponInfo> list = couponInfoService.selectCouponInfoList(couponInfo);
        return list;
    }
    /**
     * 微信优惠卷详情
     * */
    @GetMapping("/detailsCoupon/{id}")
    public String detailsCoupon(@PathVariable("id") Long id, ModelMap mmap)
    {
        CouponInfo couponInfo = couponInfoService.selectCouponInfoById(id);
        mmap.put("couponInfo", couponInfo);
        return "web/coupon/couponDetailst";
    }
    /**
     * 优惠卷图片  腾讯云对象存储图片上传
     * */
    @GetMapping("/testImg")
    @ResponseBody
    public String hhelsda(){
        try {
            // 1 初始化用户身份信息(secretId, secretKey)
            COSCredentials cred = new BasicCOSCredentials("AKIDaO2M1aKbDkJoGZvk0KaUEsPzTOFwwai2", "VtNm64xhGi2ykOwQsNrNjvy3255xiidS");
            // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
            // clientConfig中包含了设置region, https(默认http), 超时, 代理等set方法, 使用可参见源码或者接口文档FAQ中说明
            ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
            // 3 生成cos客户端
            COSClient cosClient = new COSClient(cred, clientConfig);
            // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
            String bucketName = "qbjpf-1258366811";
            File localFile = new File("D:/profile/avatar/1.jpg");
            String key = "/coupon/upoasdqw.png";
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            cosClient.getClientConfig();

            return "";
        }
        catch (Exception e){
        }
        return  "";
    }
}
