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


import com.dao.DiscusssaishihuodongDao;
import com.entity.DiscusssaishihuodongEntity;
import com.service.DiscusssaishihuodongService;
import com.entity.vo.DiscusssaishihuodongVO;
import com.entity.view.DiscusssaishihuodongView;

@Service("discusssaishihuodongService")
public class DiscusssaishihuodongServiceImpl extends ServiceImpl<DiscusssaishihuodongDao, DiscusssaishihuodongEntity> implements DiscusssaishihuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusssaishihuodongEntity> page = this.selectPage(
                new Query<DiscusssaishihuodongEntity>(params).getPage(),
                new EntityWrapper<DiscusssaishihuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusssaishihuodongEntity> wrapper) {
		  Page<DiscusssaishihuodongView> page =new Query<DiscusssaishihuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusssaishihuodongVO> selectListVO(Wrapper<DiscusssaishihuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusssaishihuodongVO selectVO(Wrapper<DiscusssaishihuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusssaishihuodongView> selectListView(Wrapper<DiscusssaishihuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusssaishihuodongView selectView(Wrapper<DiscusssaishihuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
