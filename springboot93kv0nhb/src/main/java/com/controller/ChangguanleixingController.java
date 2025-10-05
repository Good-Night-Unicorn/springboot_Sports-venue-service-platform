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

import com.entity.ChangguanleixingEntity;
import com.entity.view.ChangguanleixingView;

import com.service.ChangguanleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 场馆类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
@RestController
@RequestMapping("/changguanleixing")
public class ChangguanleixingController {
    @Autowired
    private ChangguanleixingService changguanleixingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChangguanleixingEntity changguanleixing,
		HttpServletRequest request){
        EntityWrapper<ChangguanleixingEntity> ew = new EntityWrapper<ChangguanleixingEntity>();



		PageUtils page = changguanleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changguanleixing), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChangguanleixingEntity changguanleixing, 
		HttpServletRequest request){
        EntityWrapper<ChangguanleixingEntity> ew = new EntityWrapper<ChangguanleixingEntity>();

		PageUtils page = changguanleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changguanleixing), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChangguanleixingEntity changguanleixing){
       	EntityWrapper<ChangguanleixingEntity> ew = new EntityWrapper<ChangguanleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( changguanleixing, "changguanleixing")); 
        return R.ok().put("data", changguanleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangguanleixingEntity changguanleixing){
        EntityWrapper< ChangguanleixingEntity> ew = new EntityWrapper< ChangguanleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( changguanleixing, "changguanleixing")); 
		ChangguanleixingView changguanleixingView =  changguanleixingService.selectView(ew);
		return R.ok("查询场馆类型成功").put("data", changguanleixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChangguanleixingEntity changguanleixing = changguanleixingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(changguanleixing,deSens);
        return R.ok().put("data", changguanleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChangguanleixingEntity changguanleixing = changguanleixingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(changguanleixing,deSens);
        return R.ok().put("data", changguanleixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangguanleixingEntity changguanleixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(changguanleixing);
        changguanleixingService.insert(changguanleixing);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangguanleixingEntity changguanleixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(changguanleixing);
        changguanleixingService.insert(changguanleixing);
        return R.ok().put("data",changguanleixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChangguanleixingEntity changguanleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changguanleixing);
        //全部更新
        changguanleixingService.updateById(changguanleixing);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        changguanleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
