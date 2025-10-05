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

import com.entity.ZaizhiyuangongEntity;
import com.entity.view.ZaizhiyuangongView;

import com.service.ZaizhiyuangongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 在职员工
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-31 10:14:15
 */
@RestController
@RequestMapping("/zaizhiyuangong")
public class ZaizhiyuangongController {
    @Autowired
    private ZaizhiyuangongService zaizhiyuangongService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZaizhiyuangongEntity zaizhiyuangong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("changguanguanli")) {
			zaizhiyuangong.setGuanlizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZaizhiyuangongEntity> ew = new EntityWrapper<ZaizhiyuangongEntity>();



		PageUtils page = zaizhiyuangongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaizhiyuangong), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZaizhiyuangongEntity zaizhiyuangong, 
		HttpServletRequest request){
        EntityWrapper<ZaizhiyuangongEntity> ew = new EntityWrapper<ZaizhiyuangongEntity>();

		PageUtils page = zaizhiyuangongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaizhiyuangong), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZaizhiyuangongEntity zaizhiyuangong){
       	EntityWrapper<ZaizhiyuangongEntity> ew = new EntityWrapper<ZaizhiyuangongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zaizhiyuangong, "zaizhiyuangong")); 
        return R.ok().put("data", zaizhiyuangongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZaizhiyuangongEntity zaizhiyuangong){
        EntityWrapper< ZaizhiyuangongEntity> ew = new EntityWrapper< ZaizhiyuangongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zaizhiyuangong, "zaizhiyuangong")); 
		ZaizhiyuangongView zaizhiyuangongView =  zaizhiyuangongService.selectView(ew);
		return R.ok("查询在职员工成功").put("data", zaizhiyuangongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZaizhiyuangongEntity zaizhiyuangong = zaizhiyuangongService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zaizhiyuangong,deSens);
        return R.ok().put("data", zaizhiyuangong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZaizhiyuangongEntity zaizhiyuangong = zaizhiyuangongService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(zaizhiyuangong,deSens);
        return R.ok().put("data", zaizhiyuangong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZaizhiyuangongEntity zaizhiyuangong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zaizhiyuangong);
        zaizhiyuangongService.insert(zaizhiyuangong);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZaizhiyuangongEntity zaizhiyuangong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zaizhiyuangong);
        zaizhiyuangongService.insert(zaizhiyuangong);
        return R.ok().put("data",zaizhiyuangong.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZaizhiyuangongEntity zaizhiyuangong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zaizhiyuangong);
        //全部更新
        zaizhiyuangongService.updateById(zaizhiyuangong);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zaizhiyuangongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
