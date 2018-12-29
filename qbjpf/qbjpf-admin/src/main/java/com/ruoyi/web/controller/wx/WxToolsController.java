package com.ruoyi.web.controller.wx;

import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.system.domain.ToolsInfo;
import com.ruoyi.system.service.IToolsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/wx")
public class WxToolsController  extends BaseController {
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
}
