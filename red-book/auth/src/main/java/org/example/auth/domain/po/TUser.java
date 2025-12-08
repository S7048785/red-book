package org.example.auth.domain.po;

import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.Id;
import org.babyfish.jimmer.sql.GeneratedValue;
import org.babyfish.jimmer.sql.Key;

import javax.validation.constraints.Null;

import org.babyfish.jimmer.sql.GenerationType;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 用户表
 */
@Entity
public interface TUser {
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY
	)
	BigInteger id();
	
	/**
	 * 小哈书号(唯一凭证)
	 */
	@Key
	String xiaohashuId();
	
	/**
	 * 密码
	 */
	@Null
	String password();
	
	/**
	 * 昵称
	 */
	String nickname();
	
	/**
	 * 头像
	 */
	@Null
	String avatar();
	
	/**
	 * 生日
	 */
	@Null
	LocalDate birthday();
	
	/**
	 * 背景图
	 */
	@Null
	String backgroundImg();
	
	/**
	 * 手机号
	 */
	@Key
	String phone();
	
	/**
	 * 性别(0：女 1：男)
	 */
	@Null
	Short sex();
	
	/**
	 * 状态(0：启用 1：禁用)
	 */
	Short status();
	
	/**
	 * 个人简介
	 */
	@Null
	String introduction();
	
	/**
	 * 创建时间
	 */
	LocalDateTime createTime();
	
	/**
	 * 更新时间
	 */
	LocalDateTime updateTime();
	
	/**
	 * 逻辑删除(0：未删除 1：已删除)
	 */
	Boolean deleted();
}

