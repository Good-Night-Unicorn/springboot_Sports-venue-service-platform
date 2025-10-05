package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZaizhiyuangongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZaizhiyuangongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZaizhiyuangongView;


/**
 * 在职员工
 *
 * @author 
 * @email 
 * @date 2024-12-31 10:14:15
 */
public interface ZaizhiyuangongService extends IService<ZaizhiyuangongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZaizhiyuangongVO> selectListVO(Wrapper<ZaizhiyuangongEntity> wrapper);
   	
   	ZaizhiyuangongVO selectVO(@Param("ew") Wrapper<ZaizhiyuangongEntity> wrapper);
   	
   	List<ZaizhiyuangongView> selectListView(Wrapper<ZaizhiyuangongEntity> wrapper);
   	
   	ZaizhiyuangongView selectView(@Param("ew") Wrapper<ZaizhiyuangongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZaizhiyuangongEntity> wrapper);

   	

}

