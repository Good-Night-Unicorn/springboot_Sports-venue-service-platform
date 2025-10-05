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


import com.dao.DiscussyundongchangguanDao;
import com.entity.DiscussyundongchangguanEntity;
import com.service.DiscussyundongchangguanService;
import com.entity.vo.DiscussyundongchangguanVO;
import com.entity.view.DiscussyundongchangguanView;

@Service("discussyundongchangguanService")
public class DiscussyundongchangguanServiceImpl extends ServiceImpl<DiscussyundongchangguanDao, DiscussyundongchangguanEntity> implements DiscussyundongchangguanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyundongchangguanEntity> page = this.selectPage(
                new Query<DiscussyundongchangguanEntity>(params).getPage(),
                new EntityWrapper<DiscussyundongchangguanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyundongchangguanEntity> wrapper) {
		  Page<DiscussyundongchangguanView> page =new Query<DiscussyundongchangguanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussyundongchangguanVO> selectListVO(Wrapper<DiscussyundongchangguanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyundongchangguanVO selectVO(Wrapper<DiscussyundongchangguanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyundongchangguanView> selectListView(Wrapper<DiscussyundongchangguanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyundongchangguanView selectView(Wrapper<DiscussyundongchangguanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
