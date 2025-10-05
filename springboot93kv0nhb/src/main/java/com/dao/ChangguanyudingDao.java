package com.dao;

import com.entity.ChangguanyudingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChangguanyudingVO;
import com.entity.view.ChangguanyudingView;


/**
 * 场馆预订
 * 
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
public interface ChangguanyudingDao extends BaseMapper<ChangguanyudingEntity> {
	
	List<ChangguanyudingVO> selectListVO(@Param("ew") Wrapper<ChangguanyudingEntity> wrapper);
	
	ChangguanyudingVO selectVO(@Param("ew") Wrapper<ChangguanyudingEntity> wrapper);
	
	List<ChangguanyudingView> selectListView(@Param("ew") Wrapper<ChangguanyudingEntity> wrapper);

	List<ChangguanyudingView> selectListView(Pagination page,@Param("ew") Wrapper<ChangguanyudingEntity> wrapper);

	
	ChangguanyudingView selectView(@Param("ew") Wrapper<ChangguanyudingEntity> wrapper);
	

}
