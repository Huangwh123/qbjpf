package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.CouponInfo;
import com.ruoyi.system.service.ICouponInfoService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 优惠劵 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-12-22
 */
@Controller
@RequestMapping("/system/couponInfo")
public class CouponInfoController extends BaseController
{
    private String prefix = "system/couponInfo";
	
	@Autowired
	private ICouponInfoService couponInfoService;
	
	@RequiresPermissions("system:couponInfo:view")
	@GetMapping()
	public String couponInfo()
	{
	    return prefix + "/couponInfo";
	}
	
	/**
	 * 查询优惠劵列表
	 */
	@RequiresPermissions("system:couponInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CouponInfo couponInfo)
	{
		startPage();
        List<CouponInfo> list = couponInfoService.selectCouponInfoList(couponInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出优惠劵列表
	 */
	@RequiresPermissions("system:couponInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CouponInfo couponInfo)
    {
    	List<CouponInfo> list = couponInfoService.selectCouponInfoList(couponInfo);
        ExcelUtil<CouponInfo> util = new ExcelUtil<CouponInfo>(CouponInfo.class);
        return util.exportExcel(list, "couponInfo");
    }
	
	/**
	 * 新增优惠劵
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存优惠劵
	 */
	@RequiresPermissions("system:couponInfo:add")
	@Log(title = "优惠劵", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CouponInfo couponInfo)
	{		
		return toAjax(couponInfoService.insertCouponInfo(couponInfo));
	}

	/**
	 * 修改优惠劵
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		CouponInfo couponInfo = couponInfoService.selectCouponInfoById(id);
		mmap.put("couponInfo", couponInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存优惠劵
	 */
	@RequiresPermissions("system:couponInfo:edit")
	@Log(title = "优惠劵", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CouponInfo couponInfo)
	{		
		return toAjax(couponInfoService.updateCouponInfo(couponInfo));
	}
	
	/**
	 * 删除优惠劵
	 */
	@RequiresPermissions("system:couponInfo:remove")
	@Log(title = "优惠劵", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(couponInfoService.deleteCouponInfoByIds(ids));
	}


	@GetMapping("/couponInfoIndex")
	public String query(Model model,CouponInfo couponInfo ){

		List<CouponInfo> couponList = couponInfoService.selectCouponInfoList(couponInfo);
		model.addAttribute("couponList",couponList);
		return "web/coupon/couponIndex";
	}
	@GetMapping("/lists")
	@ResponseBody
	public List<CouponInfo> lists(CouponInfo couponInfo)
	{
		startPage();
		List<CouponInfo> list = couponInfoService.selectCouponInfoList(couponInfo);
		return list;
	}
}
