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

import com.entity.DiscussyundongchangguanEntity;
import com.entity.view.DiscussyundongchangguanView;

import com.service.DiscussyundongchangguanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 运动场馆评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-31 10:14:15
 */
@RestController
@RequestMapping("/discussyundongchangguan")
public class DiscussyundongchangguanController {
    @Autowired
    private DiscussyundongchangguanService discussyundongchangguanService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussyundongchangguanEntity discussyundongchangguan,
		HttpServletRequest request){
        EntityWrapper<DiscussyundongchangguanEntity> ew = new EntityWrapper<DiscussyundongchangguanEntity>();



		PageUtils page = discussyundongchangguanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyundongchangguan), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussyundongchangguanEntity discussyundongchangguan, 
		HttpServletRequest request){
        EntityWrapper<DiscussyundongchangguanEntity> ew = new EntityWrapper<DiscussyundongchangguanEntity>();

		PageUtils page = discussyundongchangguanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyundongchangguan), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussyundongchangguanEntity discussyundongchangguan){
       	EntityWrapper<DiscussyundongchangguanEntity> ew = new EntityWrapper<DiscussyundongchangguanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussyundongchangguan, "discussyundongchangguan")); 
        return R.ok().put("data", discussyundongchangguanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussyundongchangguanEntity discussyundongchangguan){
        EntityWrapper< DiscussyundongchangguanEntity> ew = new EntityWrapper< DiscussyundongchangguanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussyundongchangguan, "discussyundongchangguan")); 
		DiscussyundongchangguanView discussyundongchangguanView =  discussyundongchangguanService.selectView(ew);
		return R.ok("查询运动场馆评论表成功").put("data", discussyundongchangguanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussyundongchangguanEntity discussyundongchangguan = discussyundongchangguanService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(discussyundongchangguan,deSens);
        return R.ok().put("data", discussyundongchangguan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussyundongchangguanEntity discussyundongchangguan = discussyundongchangguanService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(discussyundongchangguan,deSens);
        return R.ok().put("data", discussyundongchangguan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussyundongchangguanEntity discussyundongchangguan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussyundongchangguan);
        discussyundongchangguanService.insert(discussyundongchangguan);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussyundongchangguanEntity discussyundongchangguan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussyundongchangguan);
        discussyundongchangguanService.insert(discussyundongchangguan);
        return R.ok().put("data",discussyundongchangguan.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussyundongchangguanEntity discussyundongchangguan = discussyundongchangguanService.selectOne(new EntityWrapper<DiscussyundongchangguanEntity>().eq("", username));
        return R.ok().put("data", discussyundongchangguan);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussyundongchangguanEntity discussyundongchangguan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyundongchangguan);
        //全部更新
        discussyundongchangguanService.updateById(discussyundongchangguan);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussyundongchangguanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussyundongchangguanEntity discussyundongchangguan, HttpServletRequest request,String pre){
        EntityWrapper<DiscussyundongchangguanEntity> ew = new EntityWrapper<DiscussyundongchangguanEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussyundongchangguanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyundongchangguan), params), params));
        return R.ok().put("data", page);
    }











}
