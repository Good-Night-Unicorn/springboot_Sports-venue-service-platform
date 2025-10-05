package com.dao;

import com.entity.SaishidongtaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SaishidongtaiVO;
import com.entity.view.SaishidongtaiView;


/**
 * 赛事动态
 * 
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
public interface SaishidongtaiDao extends BaseMapper<SaishidongtaiEntity> {
	
	List<SaishidongtaiVO> selectListVO(@Param("ew") Wrapper<SaishidongtaiEntity> wrapper);
	
	SaishidongtaiVO selectVO(@Param("ew") Wrapper<SaishidongtaiEntity> wrapper);
	
	List<SaishidongtaiView> selectListView(@Param("ew") Wrapper<SaishidongtaiEntity> wrapper);

	List<SaishidongtaiView> selectListView(Pagination page,@Param("ew") Wrapper<SaishidongtaiEntity> wrapper);

	
	SaishidongtaiView selectView(@Param("ew") Wrapper<SaishidongtaiEntity> wrapper);
	

}
