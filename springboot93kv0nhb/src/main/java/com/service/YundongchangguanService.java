package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YundongchangguanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YundongchangguanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YundongchangguanView;


/**
 * 运动场馆
 *
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
public interface YundongchangguanService extends IService<YundongchangguanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YundongchangguanVO> selectListVO(Wrapper<YundongchangguanEntity> wrapper);
   	
   	YundongchangguanVO selectVO(@Param("ew") Wrapper<YundongchangguanEntity> wrapper);
   	
   	List<YundongchangguanView> selectListView(Wrapper<YundongchangguanEntity> wrapper);
   	
   	YundongchangguanView selectView(@Param("ew") Wrapper<YundongchangguanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YundongchangguanEntity> wrapper);

   	

}

