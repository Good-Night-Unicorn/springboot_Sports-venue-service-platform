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


import com.dao.ZaizhiyuangongDao;
import com.entity.ZaizhiyuangongEntity;
import com.service.ZaizhiyuangongService;
import com.entity.vo.ZaizhiyuangongVO;
import com.entity.view.ZaizhiyuangongView;

@Service("zaizhiyuangongService")
public class ZaizhiyuangongServiceImpl extends ServiceImpl<ZaizhiyuangongDao, ZaizhiyuangongEntity> implements ZaizhiyuangongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZaizhiyuangongEntity> page = this.selectPage(
                new Query<ZaizhiyuangongEntity>(params).getPage(),
                new EntityWrapper<ZaizhiyuangongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZaizhiyuangongEntity> wrapper) {
		  Page<ZaizhiyuangongView> page =new Query<ZaizhiyuangongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZaizhiyuangongVO> selectListVO(Wrapper<ZaizhiyuangongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZaizhiyuangongVO selectVO(Wrapper<ZaizhiyuangongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZaizhiyuangongView> selectListView(Wrapper<ZaizhiyuangongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZaizhiyuangongView selectView(Wrapper<ZaizhiyuangongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
