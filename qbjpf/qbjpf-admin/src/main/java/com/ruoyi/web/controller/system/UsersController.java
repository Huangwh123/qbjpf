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
import com.ruoyi.system.domain.Users;
import com.ruoyi.system.service.IUsersService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 用户 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-01-14
 */
@Controller
@RequestMapping("/system/users")
public class UsersController extends BaseController
{
    private String prefix = "system/users";
	
	@Autowired
	private IUsersService usersService;
	
	@RequiresPermissions("system:users:view")
	@GetMapping()
	public String users()
	{
	    return prefix + "/users";
	}
	
	/**
	 * 查询用户列表
	 */
	@RequiresPermissions("system:users:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Users users)
	{
		startPage();
        List<Users> list = usersService.selectUsersList(users);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户列表
	 */
	@RequiresPermissions("system:users:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Users users)
    {
    	List<Users> list = usersService.selectUsersList(users);
        ExcelUtil<Users> util = new ExcelUtil<Users>(Users.class);
        return util.exportExcel(list, "users");
    }
	
	/**
	 * 新增用户
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户
	 */
	@RequiresPermissions("system:users:add")
	@Log(title = "用户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Users users)
	{		
		return toAjax(usersService.insertUsers(users));
	}

	/**
	 * 修改用户
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		Users users = usersService.selectUsersById(id);
		mmap.put("users", users);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户
	 */
	@RequiresPermissions("system:users:edit")
	@Log(title = "用户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Users users)
	{		
		return toAjax(usersService.updateUsers(users));
	}
	
	/**
	 * 删除用户
	 */
	@RequiresPermissions("system:users:remove")
	@Log(title = "用户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(usersService.deleteUsersByIds(ids));
	}
	
}
