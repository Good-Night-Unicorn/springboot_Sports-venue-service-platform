package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChangguanyudingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChangguanyudingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChangguanyudingView;


/**
 * 场馆预订
 *
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
public interface ChangguanyudingService extends IService<ChangguanyudingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChangguanyudingVO> selectListVO(Wrapper<ChangguanyudingEntity> wrapper);
   	
   	ChangguanyudingVO selectVO(@Param("ew") Wrapper<ChangguanyudingEntity> wrapper);
   	
   	List<ChangguanyudingView> selectListView(Wrapper<ChangguanyudingEntity> wrapper);
   	
   	ChangguanyudingView selectView(@Param("ew") Wrapper<ChangguanyudingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChangguanyudingEntity> wrapper);

   	

}

