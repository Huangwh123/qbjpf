package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.CouponInfo;
import java.util.List;	

/**
 * 优惠劵 数据层
 * 
 * @author ruoyi
 * @date 2018-12-22
 */
public interface CouponInfoMapper 
{
	/**
     * 查询优惠劵信息
     * 
     * @param id 优惠劵ID
     * @return 优惠劵信息
     */
	public CouponInfo selectCouponInfoById(Long id);
	
	/**
     * 查询优惠劵列表
     * 
     * @param couponInfo 优惠劵信息
     * @return 优惠劵集合
     */
	public List<CouponInfo> selectCouponInfoList(CouponInfo couponInfo);
	
	/**
     * 新增优惠劵
     * 
     * @param couponInfo 优惠劵信息
     * @return 结果
     */
	public int insertCouponInfo(CouponInfo couponInfo);
	
	/**
     * 修改优惠劵
     * 
     * @param couponInfo 优惠劵信息
     * @return 结果
     */
	public int updateCouponInfo(CouponInfo couponInfo);
	
	/**
     * 删除优惠劵
     * 
     * @param id 优惠劵ID
     * @return 结果
     */
	public int deleteCouponInfoById(Long id);
	
	/**
     * 批量删除优惠劵
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCouponInfoByIds(String[] ids);

    List<CouponInfo> selectWxCouponInfoList(Long tradeState);
}