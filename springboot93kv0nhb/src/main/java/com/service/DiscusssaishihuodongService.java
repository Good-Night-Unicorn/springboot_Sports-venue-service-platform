package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusssaishihuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusssaishihuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusssaishihuodongView;


/**
 * 赛事活动评论表
 *
 * @author 
 * @email 
 * @date 2024-12-31 10:14:15
 */
public interface DiscusssaishihuodongService extends IService<DiscusssaishihuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusssaishihuodongVO> selectListVO(Wrapper<DiscusssaishihuodongEntity> wrapper);
   	
   	DiscusssaishihuodongVO selectVO(@Param("ew") Wrapper<DiscusssaishihuodongEntity> wrapper);
   	
   	List<DiscusssaishihuodongView> selectListView(Wrapper<DiscusssaishihuodongEntity> wrapper);
   	
   	DiscusssaishihuodongView selectView(@Param("ew") Wrapper<DiscusssaishihuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusssaishihuodongEntity> wrapper);

   	

}

