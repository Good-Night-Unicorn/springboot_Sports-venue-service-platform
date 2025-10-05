package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SaishidongtaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SaishidongtaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SaishidongtaiView;


/**
 * 赛事动态
 *
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
public interface SaishidongtaiService extends IService<SaishidongtaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SaishidongtaiVO> selectListVO(Wrapper<SaishidongtaiEntity> wrapper);
   	
   	SaishidongtaiVO selectVO(@Param("ew") Wrapper<SaishidongtaiEntity> wrapper);
   	
   	List<SaishidongtaiView> selectListView(Wrapper<SaishidongtaiEntity> wrapper);
   	
   	SaishidongtaiView selectView(@Param("ew") Wrapper<SaishidongtaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SaishidongtaiEntity> wrapper);

   	

}

