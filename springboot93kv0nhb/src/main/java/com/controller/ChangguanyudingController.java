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

import com.entity.ChangguanyudingEntity;
import com.entity.view.ChangguanyudingView;

import com.service.ChangguanyudingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 场馆预订
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
@RestController
@RequestMapping("/changguanyuding")
public class ChangguanyudingController {
    @Autowired
    private ChangguanyudingService changguanyudingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChangguanyudingEntity changguanyuding,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("changguanguanli")) {
			changguanyuding.setGuanlizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			changguanyuding.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChangguanyudingEntity> ew = new EntityWrapper<ChangguanyudingEntity>();



		PageUtils page = changguanyudingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changguanyuding), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChangguanyudingEntity changguanyuding, 
		HttpServletRequest request){
        EntityWrapper<ChangguanyudingEntity> ew = new EntityWrapper<ChangguanyudingEntity>();

		PageUtils page = changguanyudingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changguanyuding), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChangguanyudingEntity changguanyuding){
       	EntityWrapper<ChangguanyudingEntity> ew = new EntityWrapper<ChangguanyudingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( changguanyuding, "changguanyuding")); 
        return R.ok().put("data", changguanyudingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangguanyudingEntity changguanyuding){
        EntityWrapper< ChangguanyudingEntity> ew = new EntityWrapper< ChangguanyudingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( changguanyuding, "changguanyuding")); 
		ChangguanyudingView changguanyudingView =  changguanyudingService.selectView(ew);
		return R.ok("查询场馆预订成功").put("data", changguanyudingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChangguanyudingEntity changguanyuding = changguanyudingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(changguanyuding,deSens);
        return R.ok().put("data", changguanyuding);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChangguanyudingEntity changguanyuding = changguanyudingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(changguanyuding,deSens);
        return R.ok().put("data", changguanyuding);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangguanyudingEntity changguanyuding, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(changguanyuding);
        changguanyudingService.insert(changguanyuding);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangguanyudingEntity changguanyuding, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(changguanyuding);
        changguanyudingService.insert(changguanyuding);
        return R.ok().put("data",changguanyuding.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChangguanyudingEntity changguanyuding, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changguanyuding);
        //全部更新
        changguanyudingService.updateById(changguanyuding);

        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ChangguanyudingEntity> list = new ArrayList<ChangguanyudingEntity>();
        for(Long id : ids) {
            ChangguanyudingEntity changguanyuding = changguanyudingService.selectById(id);
            changguanyuding.setSfsh(sfsh);
            changguanyuding.setShhf(shhf);
            list.add(changguanyuding);
        }
        changguanyudingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        changguanyudingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
