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


import com.dao.ChangguanguanliDao;
import com.entity.ChangguanguanliEntity;
import com.service.ChangguanguanliService;
import com.entity.vo.ChangguanguanliVO;
import com.entity.view.ChangguanguanliView;

@Service("changguanguanliService")
public class ChangguanguanliServiceImpl extends ServiceImpl<ChangguanguanliDao, ChangguanguanliEntity> implements ChangguanguanliService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChangguanguanliEntity> page = this.selectPage(
                new Query<ChangguanguanliEntity>(params).getPage(),
                new EntityWrapper<ChangguanguanliEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChangguanguanliEntity> wrapper) {
		  Page<ChangguanguanliView> page =new Query<ChangguanguanliView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChangguanguanliVO> selectListVO(Wrapper<ChangguanguanliEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChangguanguanliVO selectVO(Wrapper<ChangguanguanliEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChangguanguanliView> selectListView(Wrapper<ChangguanguanliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChangguanguanliView selectView(Wrapper<ChangguanguanliEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
