package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SaishihuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SaishihuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SaishihuodongView;


/**
 * 赛事活动
 *
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
public interface SaishihuodongService extends IService<SaishihuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SaishihuodongVO> selectListVO(Wrapper<SaishihuodongEntity> wrapper);
   	
   	SaishihuodongVO selectVO(@Param("ew") Wrapper<SaishihuodongEntity> wrapper);
   	
   	List<SaishihuodongView> selectListView(Wrapper<SaishihuodongEntity> wrapper);
   	
   	SaishihuodongView selectView(@Param("ew") Wrapper<SaishihuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SaishihuodongEntity> wrapper);

   	

}

