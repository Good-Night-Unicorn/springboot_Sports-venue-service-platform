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

import com.entity.DiscusssaishihuodongEntity;
import com.entity.view.DiscusssaishihuodongView;

import com.service.DiscusssaishihuodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 赛事活动评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-31 10:14:15
 */
@RestController
@RequestMapping("/discusssaishihuodong")
public class DiscusssaishihuodongController {
    @Autowired
    private DiscusssaishihuodongService discusssaishihuodongService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusssaishihuodongEntity discusssaishihuodong,
		HttpServletRequest request){
        EntityWrapper<DiscusssaishihuodongEntity> ew = new EntityWrapper<DiscusssaishihuodongEntity>();



		PageUtils page = discusssaishihuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusssaishihuodong), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusssaishihuodongEntity discusssaishihuodong, 
		HttpServletRequest request){
        EntityWrapper<DiscusssaishihuodongEntity> ew = new EntityWrapper<DiscusssaishihuodongEntity>();

		PageUtils page = discusssaishihuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusssaishihuodong), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusssaishihuodongEntity discusssaishihuodong){
       	EntityWrapper<DiscusssaishihuodongEntity> ew = new EntityWrapper<DiscusssaishihuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusssaishihuodong, "discusssaishihuodong")); 
        return R.ok().put("data", discusssaishihuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusssaishihuodongEntity discusssaishihuodong){
        EntityWrapper< DiscusssaishihuodongEntity> ew = new EntityWrapper< DiscusssaishihuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusssaishihuodong, "discusssaishihuodong")); 
		DiscusssaishihuodongView discusssaishihuodongView =  discusssaishihuodongService.selectView(ew);
		return R.ok("查询赛事活动评论表成功").put("data", discusssaishihuodongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusssaishihuodongEntity discusssaishihuodong = discusssaishihuodongService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(discusssaishihuodong,deSens);
        return R.ok().put("data", discusssaishihuodong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusssaishihuodongEntity discusssaishihuodong = discusssaishihuodongService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(discusssaishihuodong,deSens);
        return R.ok().put("data", discusssaishihuodong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusssaishihuodongEntity discusssaishihuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discusssaishihuodong);
        discusssaishihuodongService.insert(discusssaishihuodong);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusssaishihuodongEntity discusssaishihuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discusssaishihuodong);
        discusssaishihuodongService.insert(discusssaishihuodong);
        return R.ok().put("data",discusssaishihuodong.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscusssaishihuodongEntity discusssaishihuodong = discusssaishihuodongService.selectOne(new EntityWrapper<DiscusssaishihuodongEntity>().eq("", username));
        return R.ok().put("data", discusssaishihuodong);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscusssaishihuodongEntity discusssaishihuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusssaishihuodong);
        //全部更新
        discusssaishihuodongService.updateById(discusssaishihuodong);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusssaishihuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscusssaishihuodongEntity discusssaishihuodong, HttpServletRequest request,String pre){
        EntityWrapper<DiscusssaishihuodongEntity> ew = new EntityWrapper<DiscusssaishihuodongEntity>();
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
		PageUtils page = discusssaishihuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusssaishihuodong), params), params));
        return R.ok().put("data", page);
    }











}
