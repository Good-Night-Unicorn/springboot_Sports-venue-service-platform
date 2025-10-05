package com.entity.view;

import com.entity.SaishidongtaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 赛事动态
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
@TableName("saishidongtai")
public class SaishidongtaiView  extends SaishidongtaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public SaishidongtaiView(){
	}
 
 	public SaishidongtaiView(SaishidongtaiEntity saishidongtaiEntity){
 	try {
			BeanUtils.copyProperties(this, saishidongtaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
