package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UsersMapper;
import com.ruoyi.system.domain.Users;
import com.ruoyi.system.service.IUsersService;
import com.ruoyi.common.support.Convert;

/**
 * 用户 服务层实现
 * 
 * @author ruoyi
 * @date 2019-01-14
 */
@Service
public class UsersServiceImpl implements IUsersService 
{
	@Autowired
	private UsersMapper usersMapper;

	/**
     * 查询用户信息
     * 
     * @param id 用户ID
     * @return 用户信息
     */
    @Override
	public Users selectUsersById(String id)
	{
	    return usersMapper.selectUsersById(id);
	}
	
	/**
     * 查询用户列表
     * 
     * @param users 用户信息
     * @return 用户集合
     */
	@Override
	public List<Users> selectUsersList(Users users)
	{
	    return usersMapper.selectUsersList(users);
	}
	
    /**
     * 新增用户
     * 
     * @param users 用户信息
     * @return 结果
     */
	@Override
	public int insertUsers(Users users)
	{
	    return usersMapper.insertUsers(users);
	}
	
	/**
     * 修改用户
     * 
     * @param users 用户信息
     * @return 结果
     */
	@Override
	public int updateUsers(Users users)
	{
	    return usersMapper.updateUsers(users);
	}

	/**
     * 删除用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteUsersByIds(String ids)
	{
		return usersMapper.deleteUsersByIds(Convert.toStrArray(ids));
	}

	@Override
	public Users insertUsersWx(JSONObject json) {
			Users users = usersMapper.selectUsersById(json.get("userId").toString());
			if (users ==null) {
				users = new Users();
				users.setId(json.get("userId").toString());
				users.setName(json.get("name").toString());
				users.setPhoto(json.get("avatar").toString());
				users.setPhoto(json.get("avatar").toString());
				users.setLastLoginTime(new Date());
				usersMapper.insertUsers(users);
				return users;
			}
			else if (DateUtils.diffDays(users.getLastLoginTime(),new Date())>0){
				users.setId(json.get("userId").toString());
				users.setName(json.get("name").toString());
				users.setPhoto(json.get("avatar").toString());
				users.setLastLoginTime(new Date());
				usersMapper.updateUsers(users);
				return users;
			}
			else{
				return  null;
			}
	}

}
