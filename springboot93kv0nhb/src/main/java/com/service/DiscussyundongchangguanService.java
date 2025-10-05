package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyundongchangguanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyundongchangguanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyundongchangguanView;


/**
 * 运动场馆评论表
 *
 * @author 
 * @email 
 * @date 2024-12-31 10:14:15
 */
public interface DiscussyundongchangguanService extends IService<DiscussyundongchangguanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyundongchangguanVO> selectListVO(Wrapper<DiscussyundongchangguanEntity> wrapper);
   	
   	DiscussyundongchangguanVO selectVO(@Param("ew") Wrapper<DiscussyundongchangguanEntity> wrapper);
   	
   	List<DiscussyundongchangguanView> selectListView(Wrapper<DiscussyundongchangguanEntity> wrapper);
   	
   	DiscussyundongchangguanView selectView(@Param("ew") Wrapper<DiscussyundongchangguanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyundongchangguanEntity> wrapper);

   	

}

