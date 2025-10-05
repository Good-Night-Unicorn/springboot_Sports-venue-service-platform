package com.dao;

import com.entity.DiscussyundongchangguanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyundongchangguanVO;
import com.entity.view.DiscussyundongchangguanView;


/**
 * 运动场馆评论表
 * 
 * @author 
 * @email 
 * @date 2024-12-31 10:14:15
 */
public interface DiscussyundongchangguanDao extends BaseMapper<DiscussyundongchangguanEntity> {
	
	List<DiscussyundongchangguanVO> selectListVO(@Param("ew") Wrapper<DiscussyundongchangguanEntity> wrapper);
	
	DiscussyundongchangguanVO selectVO(@Param("ew") Wrapper<DiscussyundongchangguanEntity> wrapper);
	
	List<DiscussyundongchangguanView> selectListView(@Param("ew") Wrapper<DiscussyundongchangguanEntity> wrapper);

	List<DiscussyundongchangguanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyundongchangguanEntity> wrapper);

	
	DiscussyundongchangguanView selectView(@Param("ew") Wrapper<DiscussyundongchangguanEntity> wrapper);
	

}
