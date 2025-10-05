package com.entity.vo;

import com.entity.SaishidongtaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 赛事动态
 * @author 
 * @email 
 * @date 2024-12-31 10:14:14
 */
public class SaishidongtaiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
