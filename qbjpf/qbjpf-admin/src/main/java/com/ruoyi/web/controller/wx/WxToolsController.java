package com.ruoyi.web.controller.wx;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.Arith;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.FileUploadUtils;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.ToolsInfo;
import com.ruoyi.system.service.IToolsInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Controller
@RequestMapping("/wx")
public class WxToolsController  extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(WxToolsController.class);

    @Autowired
    private IToolsInfoService toolsInfoService;
    /**
     * 微信页面出租工具列表
     * */
    @GetMapping("/toolsIndex")
    public String queryCouponList(){
        return "web/tools/toolsIndex";
    }

    @GetMapping("/toolList")
    @ResponseBody
    public List<ToolsInfo> lists(ToolsInfo toolsInfo)
    {
	/*	response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");*/
        startPage();
        List<ToolsInfo> list = toolsInfoService.selectToolsInfoList(toolsInfo);
        return list;
    }
    /**
     * 删除文件
     * @param key
     */
    @RequestMapping("/deleteFile")
    @ResponseBody
    public  AjaxResult deleteFile(String key) {
        try {
            if (StringUtils.isNotBlank(key)){
                key = "coupon/"+key.substring(62);
                AjaxResult ajaxResult = FileUploadUtils.deleteImgCos(key);
                return ajaxResult;
            }
            return error();
        }catch (Exception e) {
            log.error("上传工具图片失败！", e);
            return error(e.getMessage());
        }
    }
    /**
     * 上传文件
     * @param file
     * @param type(1 图片、2 文本、3 视频、4 音频、5 表格)
     */
    @RequestMapping("/uploaToolFile")
    @ResponseBody
    public  AjaxResult uploadFile(@RequestParam("file") MultipartFile file, int type) {
        try {
            if (!file.isEmpty()) {
                String avatar = FileUploadUtils.uploadImgCos(file);
                if (StringUtils.isNotBlank(avatar)) {
                    AjaxResult fileInfo = new AjaxResult();
                    fileInfo.put("fileType", "png");
                    fileInfo.put("size", Arith.div(file.getSize(), 1024, 2));
                    fileInfo.put("fileName", avatar);
                    fileInfo.put("code", 0);
                    return fileInfo;
                }
                else{
                    return error();
                }
            }
            return error();
        }catch (Exception e) {
            log.error("上传工具图片失败！", e);
            return error(e.getMessage());
        }

    }

    /**
     * 微信工具类详情
     * */
    @GetMapping("/detailsTools/{id}")
    public String detailsCoupon(@PathVariable("id") Long id, ModelMap mmap)
    {
        ToolsInfo toolsInfo = toolsInfoService.selectToolsInfoById(id);
        mmap.put("toolsInfo", toolsInfo);
        return "web/tools/toolsDetails";
    }
}
