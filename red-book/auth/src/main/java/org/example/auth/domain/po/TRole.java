package org.example.auth.domain.po;

import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.Id;
import org.babyfish.jimmer.sql.GeneratedValue;
import org.babyfish.jimmer.sql.Key;

import javax.validation.constraints.Null;

import org.babyfish.jimmer.sql.GenerationType;

import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * 角色表
 */
@Entity
public interface TRole {
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY
	)
	BigInteger id();
	
	/**
	 * 角色名
	 */
	String roleName();
	
	/**
	 * 角色唯一标识
	 */
	@Key
	String roleKey();
	
	/**
	 * 状态(0：启用 1：禁用)
	 */
	Short status();
	
	/**
	 * 管理系统中的显示顺序
	 */
	Long sort();
	
	/**
	 * 备注
	 */
	@Null
	String remark();
	
	/**
	 * 创建时间
	 */
	LocalDateTime createTime();
	
	/**
	 * 最后一次更新时间
	 */
	LocalDateTime updateTime();
	
	/**
	 * 逻辑删除(0：未删除 1：已删除)
	 */
	Boolean deleted();
}

