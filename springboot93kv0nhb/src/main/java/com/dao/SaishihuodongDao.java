package com.dao;

import com.entity.SaishihuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SaishihuodongVO;
import com.entity.view.SaishihuodongView;


/**
 * 赛事活动
 * 
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
public interface SaishihuodongDao extends BaseMapper<SaishihuodongEntity> {
	
	List<SaishihuodongVO> selectListVO(@Param("ew") Wrapper<SaishihuodongEntity> wrapper);
	
	SaishihuodongVO selectVO(@Param("ew") Wrapper<SaishihuodongEntity> wrapper);
	
	List<SaishihuodongView> selectListView(@Param("ew") Wrapper<SaishihuodongEntity> wrapper);

	List<SaishihuodongView> selectListView(Pagination page,@Param("ew") Wrapper<SaishihuodongEntity> wrapper);

	
	SaishihuodongView selectView(@Param("ew") Wrapper<SaishihuodongEntity> wrapper);
	

}
