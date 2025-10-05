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

import com.entity.SaishibaomingEntity;
import com.entity.view.SaishibaomingView;

import com.service.SaishibaomingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 赛事报名
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
@RestController
@RequestMapping("/saishibaoming")
public class SaishibaomingController {
    @Autowired
    private SaishibaomingService saishibaomingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SaishibaomingEntity saishibaoming,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			saishibaoming.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("changguanguanli")) {
			saishibaoming.setGuanlizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<SaishibaomingEntity> ew = new EntityWrapper<SaishibaomingEntity>();



		PageUtils page = saishibaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, saishibaoming), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SaishibaomingEntity saishibaoming, 
		HttpServletRequest request){
        EntityWrapper<SaishibaomingEntity> ew = new EntityWrapper<SaishibaomingEntity>();

		PageUtils page = saishibaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, saishibaoming), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SaishibaomingEntity saishibaoming){
       	EntityWrapper<SaishibaomingEntity> ew = new EntityWrapper<SaishibaomingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( saishibaoming, "saishibaoming")); 
        return R.ok().put("data", saishibaomingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SaishibaomingEntity saishibaoming){
        EntityWrapper< SaishibaomingEntity> ew = new EntityWrapper< SaishibaomingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( saishibaoming, "saishibaoming")); 
		SaishibaomingView saishibaomingView =  saishibaomingService.selectView(ew);
		return R.ok("查询赛事报名成功").put("data", saishibaomingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SaishibaomingEntity saishibaoming = saishibaomingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(saishibaoming,deSens);
        return R.ok().put("data", saishibaoming);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SaishibaomingEntity saishibaoming = saishibaomingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(saishibaoming,deSens);
        return R.ok().put("data", saishibaoming);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SaishibaomingEntity saishibaoming, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(saishibaoming);
        saishibaomingService.insert(saishibaoming);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SaishibaomingEntity saishibaoming, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(saishibaoming);
        saishibaomingService.insert(saishibaoming);
        return R.ok().put("data",saishibaoming.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SaishibaomingEntity saishibaoming, HttpServletRequest request){
        //ValidatorUtils.validateEntity(saishibaoming);
        //全部更新
        saishibaomingService.updateById(saishibaoming);

        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<SaishibaomingEntity> list = new ArrayList<SaishibaomingEntity>();
        for(Long id : ids) {
            SaishibaomingEntity saishibaoming = saishibaomingService.selectById(id);
            saishibaoming.setSfsh(sfsh);
            saishibaoming.setShhf(shhf);
            list.add(saishibaoming);
        }
        saishibaomingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        saishibaomingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
