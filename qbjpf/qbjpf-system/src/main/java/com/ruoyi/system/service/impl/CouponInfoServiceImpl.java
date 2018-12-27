package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CouponInfoMapper;
import com.ruoyi.system.domain.CouponInfo;
import com.ruoyi.system.service.ICouponInfoService;
import com.ruoyi.common.support.Convert;

/**
 * 优惠劵 服务层实现
 * 
 * @author ruoyi
 * @date 2018-12-22
 */
@Service
public class CouponInfoServiceImpl implements ICouponInfoService 
{
	@Autowired
	private CouponInfoMapper couponInfoMapper;

	/**
     * 查询优惠劵信息
     * 
     * @param id 优惠劵ID
     * @return 优惠劵信息
     */
    @Override
	public CouponInfo selectCouponInfoById(Long id)
	{
	    return couponInfoMapper.selectCouponInfoById(id);
	}
	
	/**
     * 查询优惠劵列表
     * 
     * @param couponInfo 优惠劵信息
     * @return 优惠劵集合
     */
	@Override
	public List<CouponInfo> selectCouponInfoList(CouponInfo couponInfo)
	{
	    return couponInfoMapper.selectCouponInfoList(couponInfo);
	}
	
    /**
     * 新增优惠劵
     * 
     * @param couponInfo 优惠劵信息
     * @return 结果
     */
	@Override
	public int insertCouponInfo(CouponInfo couponInfo)
	{
	    return couponInfoMapper.insertCouponInfo(couponInfo);
	}
	
	/**
     * 修改优惠劵
     * 
     * @param couponInfo 优惠劵信息
     * @return 结果
     */
	@Override
	public int updateCouponInfo(CouponInfo couponInfo)
	{
	    return couponInfoMapper.updateCouponInfo(couponInfo);
	}

	/**
     * 删除优惠劵对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCouponInfoByIds(String ids)
	{
		return couponInfoMapper.deleteCouponInfoByIds(Convert.toStrArray(ids));
	}
	
}
