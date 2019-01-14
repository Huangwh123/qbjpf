package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Users;
import java.util.List;	

/**
 * 用户 数据层
 * 
 * @author ruoyi
 * @date 2019-01-14
 */
public interface UsersMapper 
{
	/**
     * 查询用户信息
     * 
     * @param id 用户ID
     * @return 用户信息
     */
	public Users selectUsersById(Long id);
	
	/**
     * 查询用户列表
     * 
     * @param users 用户信息
     * @return 用户集合
     */
	public List<Users> selectUsersList(Users users);
	
	/**
     * 新增用户
     * 
     * @param users 用户信息
     * @return 结果
     */
	public int insertUsers(Users users);
	
	/**
     * 修改用户
     * 
     * @param users 用户信息
     * @return 结果
     */
	public int updateUsers(Users users);
	
	/**
     * 删除用户
     * 
     * @param id 用户ID
     * @return 结果
     */
	public int deleteUsersById(Long id);
	
	/**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteUsersByIds(String[] ids);
	
}