package com.dao;

import com.entity.ChangguanguanliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChangguanguanliVO;
import com.entity.view.ChangguanguanliView;


/**
 * 场馆管理
 * 
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
public interface ChangguanguanliDao extends BaseMapper<ChangguanguanliEntity> {
	
	List<ChangguanguanliVO> selectListVO(@Param("ew") Wrapper<ChangguanguanliEntity> wrapper);
	
	ChangguanguanliVO selectVO(@Param("ew") Wrapper<ChangguanguanliEntity> wrapper);
	
	List<ChangguanguanliView> selectListView(@Param("ew") Wrapper<ChangguanguanliEntity> wrapper);

	List<ChangguanguanliView> selectListView(Pagination page,@Param("ew") Wrapper<ChangguanguanliEntity> wrapper);

	
	ChangguanguanliView selectView(@Param("ew") Wrapper<ChangguanguanliEntity> wrapper);
	

}
