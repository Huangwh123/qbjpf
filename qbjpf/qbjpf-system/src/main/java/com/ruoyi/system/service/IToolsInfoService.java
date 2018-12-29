package com.ruoyi.system.service;

import com.ruoyi.system.domain.ToolsInfo;
import java.util.List;

/**
 * 工具 服务层
 * 
 * @author ruoyi
 * @date 2018-12-29
 */
public interface IToolsInfoService 
{
	/**
     * 查询工具信息
     * 
     * @param id 工具ID
     * @return 工具信息
     */
	public ToolsInfo selectToolsInfoById(Long id);
	
	/**
     * 查询工具列表
     * 
     * @param toolsInfo 工具信息
     * @return 工具集合
     */
	public List<ToolsInfo> selectToolsInfoList(ToolsInfo toolsInfo);
	
	/**
     * 新增工具
     * 
     * @param toolsInfo 工具信息
     * @return 结果
     */
	public int insertToolsInfo(ToolsInfo toolsInfo);
	
	/**
     * 修改工具
     * 
     * @param toolsInfo 工具信息
     * @return 结果
     */
	public int updateToolsInfo(ToolsInfo toolsInfo);
		
	/**
     * 删除工具信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteToolsInfoByIds(String ids);
	
}
