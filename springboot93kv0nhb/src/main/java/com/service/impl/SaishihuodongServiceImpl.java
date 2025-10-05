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


import com.dao.SaishihuodongDao;
import com.entity.SaishihuodongEntity;
import com.service.SaishihuodongService;
import com.entity.vo.SaishihuodongVO;
import com.entity.view.SaishihuodongView;

@Service("saishihuodongService")
public class SaishihuodongServiceImpl extends ServiceImpl<SaishihuodongDao, SaishihuodongEntity> implements SaishihuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SaishihuodongEntity> page = this.selectPage(
                new Query<SaishihuodongEntity>(params).getPage(),
                new EntityWrapper<SaishihuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SaishihuodongEntity> wrapper) {
		  Page<SaishihuodongView> page =new Query<SaishihuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<SaishihuodongVO> selectListVO(Wrapper<SaishihuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SaishihuodongVO selectVO(Wrapper<SaishihuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SaishihuodongView> selectListView(Wrapper<SaishihuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SaishihuodongView selectView(Wrapper<SaishihuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
