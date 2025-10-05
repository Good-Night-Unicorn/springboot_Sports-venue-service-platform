package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ChangguanyudingDao;
import com.entity.ChangguanyudingEntity;
import com.service.ChangguanyudingService;
import com.entity.vo.ChangguanyudingVO;
import com.entity.view.ChangguanyudingView;

@Service("changguanyudingService")
public class ChangguanyudingServiceImpl extends ServiceImpl<ChangguanyudingDao, ChangguanyudingEntity> implements ChangguanyudingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChangguanyudingEntity> page = this.selectPage(
                new Query<ChangguanyudingEntity>(params).getPage(),
                new EntityWrapper<ChangguanyudingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChangguanyudingEntity> wrapper) {
		  Page<ChangguanyudingView> page =new Query<ChangguanyudingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChangguanyudingVO> selectListVO(Wrapper<ChangguanyudingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChangguanyudingVO selectVO(Wrapper<ChangguanyudingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChangguanyudingView> selectListView(Wrapper<ChangguanyudingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChangguanyudingView selectView(Wrapper<ChangguanyudingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
