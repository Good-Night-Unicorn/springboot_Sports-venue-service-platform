package com.entity.view;

import com.entity.DiscusssaishihuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 赛事活动评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-12-31 10:14:15
 */
@TableName("discusssaishihuodong")
public class DiscusssaishihuodongView  extends DiscusssaishihuodongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusssaishihuodongView(){
	}
 
 	public DiscusssaishihuodongView(DiscusssaishihuodongEntity discusssaishihuodongEntity){
 	try {
			BeanUtils.copyProperties(this, discusssaishihuodongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
