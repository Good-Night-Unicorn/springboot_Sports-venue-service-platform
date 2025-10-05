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


import com.dao.YundongchangguanDao;
import com.entity.YundongchangguanEntity;
import com.service.YundongchangguanService;
import com.entity.vo.YundongchangguanVO;
import com.entity.view.YundongchangguanView;

@Service("yundongchangguanService")
public class YundongchangguanServiceImpl extends ServiceImpl<YundongchangguanDao, YundongchangguanEntity> implements YundongchangguanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YundongchangguanEntity> page = this.selectPage(
                new Query<YundongchangguanEntity>(params).getPage(),
                new EntityWrapper<YundongchangguanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YundongchangguanEntity> wrapper) {
		  Page<YundongchangguanView> page =new Query<YundongchangguanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YundongchangguanVO> selectListVO(Wrapper<YundongchangguanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YundongchangguanVO selectVO(Wrapper<YundongchangguanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YundongchangguanView> selectListView(Wrapper<YundongchangguanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YundongchangguanView selectView(Wrapper<YundongchangguanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
