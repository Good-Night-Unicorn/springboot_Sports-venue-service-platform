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

import com.entity.SaishidongtaiEntity;
import com.entity.view.SaishidongtaiView;

import com.service.SaishidongtaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 赛事动态
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
@RestController
@RequestMapping("/saishidongtai")
public class SaishidongtaiController {
    @Autowired
    private SaishidongtaiService saishidongtaiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SaishidongtaiEntity saishidongtai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("changguanguanli")) {
			saishidongtai.setGuanlizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<SaishidongtaiEntity> ew = new EntityWrapper<SaishidongtaiEntity>();



		PageUtils page = saishidongtaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, saishidongtai), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SaishidongtaiEntity saishidongtai, 
		HttpServletRequest request){
        EntityWrapper<SaishidongtaiEntity> ew = new EntityWrapper<SaishidongtaiEntity>();

		PageUtils page = saishidongtaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, saishidongtai), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SaishidongtaiEntity saishidongtai){
       	EntityWrapper<SaishidongtaiEntity> ew = new EntityWrapper<SaishidongtaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( saishidongtai, "saishidongtai")); 
        return R.ok().put("data", saishidongtaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SaishidongtaiEntity saishidongtai){
        EntityWrapper< SaishidongtaiEntity> ew = new EntityWrapper< SaishidongtaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( saishidongtai, "saishidongtai")); 
		SaishidongtaiView saishidongtaiView =  saishidongtaiService.selectView(ew);
		return R.ok("查询赛事动态成功").put("data", saishidongtaiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SaishidongtaiEntity saishidongtai = saishidongtaiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(saishidongtai,deSens);
        return R.ok().put("data", saishidongtai);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SaishidongtaiEntity saishidongtai = saishidongtaiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(saishidongtai,deSens);
        return R.ok().put("data", saishidongtai);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SaishidongtaiEntity saishidongtai, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(saishidongtai);
        saishidongtaiService.insert(saishidongtai);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SaishidongtaiEntity saishidongtai, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(saishidongtai);
        saishidongtaiService.insert(saishidongtai);
        return R.ok().put("data",saishidongtai.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SaishidongtaiEntity saishidongtai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(saishidongtai);
        //全部更新
        saishidongtaiService.updateById(saishidongtai);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        saishidongtaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
