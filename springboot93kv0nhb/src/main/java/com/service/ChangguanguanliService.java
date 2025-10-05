package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChangguanguanliEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChangguanguanliVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChangguanguanliView;


/**
 * 场馆管理
 *
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
public interface ChangguanguanliService extends IService<ChangguanguanliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChangguanguanliVO> selectListVO(Wrapper<ChangguanguanliEntity> wrapper);
   	
   	ChangguanguanliVO selectVO(@Param("ew") Wrapper<ChangguanguanliEntity> wrapper);
   	
   	List<ChangguanguanliView> selectListView(Wrapper<ChangguanguanliEntity> wrapper);
   	
   	ChangguanguanliView selectView(@Param("ew") Wrapper<ChangguanguanliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChangguanguanliEntity> wrapper);

   	

}

