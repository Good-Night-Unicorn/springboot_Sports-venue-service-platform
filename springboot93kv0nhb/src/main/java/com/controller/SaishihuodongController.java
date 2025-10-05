package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import java.util.Collections;

import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.SaishihuodongEntity;
import com.entity.view.SaishihuodongView;

import com.service.SaishihuodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 赛事活动
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
@RestController
@RequestMapping("/saishihuodong")
public class SaishihuodongController {
    @Autowired
    private SaishihuodongService saishihuodongService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SaishihuodongEntity saishihuodong,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("changguanguanli")) {
			saishihuodong.setGuanlizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<SaishihuodongEntity> ew = new EntityWrapper<SaishihuodongEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);



		PageUtils page = saishihuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, saishihuodong), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SaishihuodongEntity saishihuodong, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<SaishihuodongEntity> ew = new EntityWrapper<SaishihuodongEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = saishihuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, saishihuodong), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SaishihuodongEntity saishihuodong){
       	EntityWrapper<SaishihuodongEntity> ew = new EntityWrapper<SaishihuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( saishihuodong, "saishihuodong")); 
        return R.ok().put("data", saishihuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SaishihuodongEntity saishihuodong){
        EntityWrapper< SaishihuodongEntity> ew = new EntityWrapper< SaishihuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( saishihuodong, "saishihuodong")); 
		SaishihuodongView saishihuodongView =  saishihuodongService.selectView(ew);
		return R.ok("查询赛事活动成功").put("data", saishihuodongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SaishihuodongEntity saishihuodong = saishihuodongService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(saishihuodong,deSens);
        return R.ok().put("data", saishihuodong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SaishihuodongEntity saishihuodong = saishihuodongService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(saishihuodong,deSens);
        return R.ok().put("data", saishihuodong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SaishihuodongEntity saishihuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(saishihuodong);
        saishihuodongService.insert(saishihuodong);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SaishihuodongEntity saishihuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(saishihuodong);
        saishihuodongService.insert(saishihuodong);
        return R.ok().put("data",saishihuodong.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SaishihuodongEntity saishihuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(saishihuodong);
        //全部更新
        saishihuodongService.updateById(saishihuodong);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        saishihuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
