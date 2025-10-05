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


import com.dao.SaishidongtaiDao;
import com.entity.SaishidongtaiEntity;
import com.service.SaishidongtaiService;
import com.entity.vo.SaishidongtaiVO;
import com.entity.view.SaishidongtaiView;

@Service("saishidongtaiService")
public class SaishidongtaiServiceImpl extends ServiceImpl<SaishidongtaiDao, SaishidongtaiEntity> implements SaishidongtaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SaishidongtaiEntity> page = this.selectPage(
                new Query<SaishidongtaiEntity>(params).getPage(),
                new EntityWrapper<SaishidongtaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SaishidongtaiEntity> wrapper) {
		  Page<SaishidongtaiView> page =new Query<SaishidongtaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<SaishidongtaiVO> selectListVO(Wrapper<SaishidongtaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SaishidongtaiVO selectVO(Wrapper<SaishidongtaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SaishidongtaiView> selectListView(Wrapper<SaishidongtaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SaishidongtaiView selectView(Wrapper<SaishidongtaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
