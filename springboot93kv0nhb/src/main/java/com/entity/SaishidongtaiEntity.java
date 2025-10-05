package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 赛事动态
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
@TableName("saishidongtai")
public class SaishidongtaiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public SaishidongtaiEntity() {
		
	}
	
	public SaishidongtaiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 赛事名称
	 */
					
	private String saishimingcheng;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 赛事安排
	 */
					
	private String saishianpai;
	
	/**
	 * 对阵表
	 */
					
	private String duizhenbiao;
	
	/**
	 * 比分结果
	 */
					
	private String bifenjieguo;
	
	/**
	 * 视频
	 */
					
	private String shipin;
	
	/**
	 * 赛事动态
	 */
					
	private String saishidongtai;
	
	/**
	 * 管理账号
	 */
					
	private String guanlizhanghao;
	
	/**
	 * 管理姓名
	 */
					
	private String guanlixingming;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：赛事名称
	 */
	public void setSaishimingcheng(String saishimingcheng) {
		this.saishimingcheng = saishimingcheng;
	}
	/**
	 * 获取：赛事名称
	 */
	public String getSaishimingcheng() {
		return saishimingcheng;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：赛事安排
	 */
	public void setSaishianpai(String saishianpai) {
		this.saishianpai = saishianpai;
	}
	/**
	 * 获取：赛事安排
	 */
	public String getSaishianpai() {
		return saishianpai;
	}
	/**
	 * 设置：对阵表
	 */
	public void setDuizhenbiao(String duizhenbiao) {
		this.duizhenbiao = duizhenbiao;
	}
	/**
	 * 获取：对阵表
	 */
	public String getDuizhenbiao() {
		return duizhenbiao;
	}
	/**
	 * 设置：比分结果
	 */
	public void setBifenjieguo(String bifenjieguo) {
		this.bifenjieguo = bifenjieguo;
	}
	/**
	 * 获取：比分结果
	 */
	public String getBifenjieguo() {
		return bifenjieguo;
	}
	/**
	 * 设置：视频
	 */
	public void setShipin(String shipin) {
		this.shipin = shipin;
	}
	/**
	 * 获取：视频
	 */
	public String getShipin() {
		return shipin;
	}
	/**
	 * 设置：赛事动态
	 */
	public void setSaishidongtai(String saishidongtai) {
		this.saishidongtai = saishidongtai;
	}
	/**
	 * 获取：赛事动态
	 */
	public String getSaishidongtai() {
		return saishidongtai;
	}
	/**
	 * 设置：管理账号
	 */
	public void setGuanlizhanghao(String guanlizhanghao) {
		this.guanlizhanghao = guanlizhanghao;
	}
	/**
	 * 获取：管理账号
	 */
	public String getGuanlizhanghao() {
		return guanlizhanghao;
	}
	/**
	 * 设置：管理姓名
	 */
	public void setGuanlixingming(String guanlixingming) {
		this.guanlixingming = guanlixingming;
	}
	/**
	 * 获取：管理姓名
	 */
	public String getGuanlixingming() {
		return guanlixingming;
	}

}
