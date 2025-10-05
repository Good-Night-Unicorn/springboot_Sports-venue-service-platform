package com.dao;

import com.entity.YundongchangguanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YundongchangguanVO;
import com.entity.view.YundongchangguanView;


/**
 * 运动场馆
 * 
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
public interface YundongchangguanDao extends BaseMapper<YundongchangguanEntity> {
	
	List<YundongchangguanVO> selectListVO(@Param("ew") Wrapper<YundongchangguanEntity> wrapper);
	
	YundongchangguanVO selectVO(@Param("ew") Wrapper<YundongchangguanEntity> wrapper);
	
	List<YundongchangguanView> selectListView(@Param("ew") Wrapper<YundongchangguanEntity> wrapper);

	List<YundongchangguanView> selectListView(Pagination page,@Param("ew") Wrapper<YundongchangguanEntity> wrapper);

	
	YundongchangguanView selectView(@Param("ew") Wrapper<YundongchangguanEntity> wrapper);
	

}
