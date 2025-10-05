package com.dao;

import com.entity.DiscusssaishihuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusssaishihuodongVO;
import com.entity.view.DiscusssaishihuodongView;


/**
 * 赛事活动评论表
 * 
 * @author 
 * @email 
 * @date 2024-12-31 10:14:15
 */
public interface DiscusssaishihuodongDao extends BaseMapper<DiscusssaishihuodongEntity> {
	
	List<DiscusssaishihuodongVO> selectListVO(@Param("ew") Wrapper<DiscusssaishihuodongEntity> wrapper);
	
	DiscusssaishihuodongVO selectVO(@Param("ew") Wrapper<DiscusssaishihuodongEntity> wrapper);
	
	List<DiscusssaishihuodongView> selectListView(@Param("ew") Wrapper<DiscusssaishihuodongEntity> wrapper);

	List<DiscusssaishihuodongView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusssaishihuodongEntity> wrapper);

	
	DiscusssaishihuodongView selectView(@Param("ew") Wrapper<DiscusssaishihuodongEntity> wrapper);
	

}
