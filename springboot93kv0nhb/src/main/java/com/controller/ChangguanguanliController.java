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
import com.entity.TokenEntity;
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

import com.entity.ChangguanguanliEntity;
import com.entity.view.ChangguanguanliView;

import com.service.ChangguanguanliService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 场馆管理
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
@RestController
@RequestMapping("/changguanguanli")
public class ChangguanguanliController {
    @Autowired
    private ChangguanguanliService changguanguanliService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		ChangguanguanliEntity u = changguanguanliService.selectOne(new EntityWrapper<ChangguanguanliEntity>().eq("guanlizhanghao", username));
        if(u!=null && u.getStatus().intValue()==1) {
            return R.error("账号已锁定，请联系管理员。");
        }
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"changguanguanli",  "管理员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ChangguanguanliEntity changguanguanli){
    	//ValidatorUtils.validateEntity(changguanguanli);
    	ChangguanguanliEntity u = changguanguanliService.selectOne(new EntityWrapper<ChangguanguanliEntity>().eq("guanlizhanghao", changguanguanli.getGuanlizhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		changguanguanli.setId(uId);
        changguanguanliService.insert(changguanguanli);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        ChangguanguanliEntity u = changguanguanliService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	ChangguanguanliEntity u = changguanguanliService.selectOne(new EntityWrapper<ChangguanguanliEntity>().eq("guanlizhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        changguanguanliService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChangguanguanliEntity changguanguanli,
		HttpServletRequest request){
        EntityWrapper<ChangguanguanliEntity> ew = new EntityWrapper<ChangguanguanliEntity>();



		PageUtils page = changguanguanliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changguanguanli), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChangguanguanliEntity changguanguanli, 
		HttpServletRequest request){
        EntityWrapper<ChangguanguanliEntity> ew = new EntityWrapper<ChangguanguanliEntity>();

		PageUtils page = changguanguanliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changguanguanli), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChangguanguanliEntity changguanguanli){
       	EntityWrapper<ChangguanguanliEntity> ew = new EntityWrapper<ChangguanguanliEntity>();
      	ew.allEq(MPUtil.allEQMapPre( changguanguanli, "changguanguanli")); 
        return R.ok().put("data", changguanguanliService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangguanguanliEntity changguanguanli){
        EntityWrapper< ChangguanguanliEntity> ew = new EntityWrapper< ChangguanguanliEntity>();
 		ew.allEq(MPUtil.allEQMapPre( changguanguanli, "changguanguanli")); 
		ChangguanguanliView changguanguanliView =  changguanguanliService.selectView(ew);
		return R.ok("查询场馆管理成功").put("data", changguanguanliView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChangguanguanliEntity changguanguanli = changguanguanliService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(changguanguanli,deSens);
        return R.ok().put("data", changguanguanli);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChangguanguanliEntity changguanguanli = changguanguanliService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(changguanguanli,deSens);
        return R.ok().put("data", changguanguanli);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangguanguanliEntity changguanguanli, HttpServletRequest request){
        if(changguanguanliService.selectCount(new EntityWrapper<ChangguanguanliEntity>().eq("guanlizhanghao", changguanguanli.getGuanlizhanghao()))>0) {
            return R.error("管理账号已存在");
        }
    	changguanguanli.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(changguanguanli);
    	ChangguanguanliEntity u = changguanguanliService.selectOne(new EntityWrapper<ChangguanguanliEntity>().eq("guanlizhanghao", changguanguanli.getGuanlizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		changguanguanli.setId(new Date().getTime());
        changguanguanliService.insert(changguanguanli);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangguanguanliEntity changguanguanli, HttpServletRequest request){
        if(changguanguanliService.selectCount(new EntityWrapper<ChangguanguanliEntity>().eq("guanlizhanghao", changguanguanli.getGuanlizhanghao()))>0) {
            return R.error("管理账号已存在");
        }
    	changguanguanli.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(changguanguanli);
    	ChangguanguanliEntity u = changguanguanliService.selectOne(new EntityWrapper<ChangguanguanliEntity>().eq("guanlizhanghao", changguanguanli.getGuanlizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		changguanguanli.setId(new Date().getTime());
        changguanguanliService.insert(changguanguanli);
        return R.ok().put("data",changguanguanli.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChangguanguanliEntity changguanguanli, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changguanguanli);
        if(changguanguanliService.selectCount(new EntityWrapper<ChangguanguanliEntity>().ne("id", changguanguanli.getId()).eq("guanlizhanghao", changguanguanli.getGuanlizhanghao()))>0) {
            return R.error("管理账号已存在");
        }
        //全部更新
        changguanguanliService.updateById(changguanguanli);
    if(null!=changguanguanli.getGuanlizhanghao())
    {
        // 修改token
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setUsername(changguanguanli.getGuanlizhanghao());
        tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", changguanguanli.getId()));
    }


        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        changguanguanliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
