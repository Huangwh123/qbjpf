package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ToolsInfoMapper;
import com.ruoyi.system.domain.ToolsInfo;
import com.ruoyi.system.service.IToolsInfoService;
import com.ruoyi.common.support.Convert;

/**
 * 工具 服务层实现
 * 
 * @author ruoyi
 * @date 2018-12-29
 */
@Service
public class ToolsInfoServiceImpl implements IToolsInfoService 
{
	@Autowired
	private ToolsInfoMapper toolsInfoMapper;

	/**
     * 查询工具信息
     * 
     * @param id 工具ID
     * @return 工具信息
     */
    @Override
	public ToolsInfo selectToolsInfoById(Long id)
	{
	    return toolsInfoMapper.selectToolsInfoById(id);
	}
	
	/**
     * 查询工具列表
     * 
     * @param toolsInfo 工具信息
     * @return 工具集合
     */
	@Override
	public List<ToolsInfo> selectToolsInfoList(ToolsInfo toolsInfo)
	{
	    return toolsInfoMapper.selectToolsInfoList(toolsInfo);
	}
	
    /**
     * 新增工具
     * 
     * @param toolsInfo 工具信息
     * @return 结果
     */
	@Override
	public int insertToolsInfo(ToolsInfo toolsInfo)
	{
	    return toolsInfoMapper.insertToolsInfo(toolsInfo);
	}
	
	/**
     * 修改工具
     * 
     * @param toolsInfo 工具信息
     * @return 结果
     */
	@Override
	public int updateToolsInfo(ToolsInfo toolsInfo)
	{
	    return toolsInfoMapper.updateToolsInfo(toolsInfo);
	}

	/**
     * 删除工具对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteToolsInfoByIds(String ids)
	{
		return toolsInfoMapper.deleteToolsInfoByIds(Convert.toStrArray(ids));
	}
	
}
