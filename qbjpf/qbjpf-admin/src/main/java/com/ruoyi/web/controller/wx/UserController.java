package com.ruoyi.web.controller.wx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wx")
public class UserController {
    /**
     * 微信页面优惠卷列表
     * */
    @GetMapping("/userIndex")
    public String queryCouponList(){
        return "web/untilAccount";
    }
}
