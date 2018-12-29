package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ToolsInfo;
import com.ruoyi.system.service.IToolsInfoService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 工具 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-12-29
 */
@Controller
@RequestMapping("/system/toolsInfo")
public class ToolsInfoController extends BaseController
{
    private String prefix = "system/toolsInfo";
	
	@Autowired
	private IToolsInfoService toolsInfoService;
	
	@RequiresPermissions("system:toolsInfo:view")
	@GetMapping()
	public String toolsInfo()
	{
	    return prefix + "/toolsInfo";
	}
	
	/**
	 * 查询工具列表
	 */
	@RequiresPermissions("system:toolsInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ToolsInfo toolsInfo)
	{
		startPage();
        List<ToolsInfo> list = toolsInfoService.selectToolsInfoList(toolsInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出工具列表
	 */
	@RequiresPermissions("system:toolsInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ToolsInfo toolsInfo)
    {
    	List<ToolsInfo> list = toolsInfoService.selectToolsInfoList(toolsInfo);
        ExcelUtil<ToolsInfo> util = new ExcelUtil<ToolsInfo>(ToolsInfo.class);
        return util.exportExcel(list, "toolsInfo");
    }
	
	/**
	 * 新增工具
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存工具
	 */
	@RequiresPermissions("system:toolsInfo:add")
	@Log(title = "工具", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ToolsInfo toolsInfo)
	{		
		return toAjax(toolsInfoService.insertToolsInfo(toolsInfo));
	}

	/**
	 * 修改工具
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		ToolsInfo toolsInfo = toolsInfoService.selectToolsInfoById(id);
		mmap.put("toolsInfo", toolsInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存工具
	 */
	@RequiresPermissions("system:toolsInfo:edit")
	@Log(title = "工具", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ToolsInfo toolsInfo)
	{		
		return toAjax(toolsInfoService.updateToolsInfo(toolsInfo));
	}
	
	/**
	 * 删除工具
	 */
	@RequiresPermissions("system:toolsInfo:remove")
	@Log(title = "工具", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(toolsInfoService.deleteToolsInfoByIds(ids));
	}
	
}
