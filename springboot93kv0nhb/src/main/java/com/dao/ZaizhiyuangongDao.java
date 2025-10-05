package com.dao;

import com.entity.ZaizhiyuangongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZaizhiyuangongVO;
import com.entity.view.ZaizhiyuangongView;


/**
 * 在职员工
 * 
 * @author 
 * @email 
 * @date 2024-12-31 10:14:15
 */
public interface ZaizhiyuangongDao extends BaseMapper<ZaizhiyuangongEntity> {
	
	List<ZaizhiyuangongVO> selectListVO(@Param("ew") Wrapper<ZaizhiyuangongEntity> wrapper);
	
	ZaizhiyuangongVO selectVO(@Param("ew") Wrapper<ZaizhiyuangongEntity> wrapper);
	
	List<ZaizhiyuangongView> selectListView(@Param("ew") Wrapper<ZaizhiyuangongEntity> wrapper);

	List<ZaizhiyuangongView> selectListView(Pagination page,@Param("ew") Wrapper<ZaizhiyuangongEntity> wrapper);

	
	ZaizhiyuangongView selectView(@Param("ew") Wrapper<ZaizhiyuangongEntity> wrapper);
	

}
