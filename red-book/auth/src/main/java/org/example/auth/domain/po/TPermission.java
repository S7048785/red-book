package org.example.auth.domain.po;

import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.Id;
import org.babyfish.jimmer.sql.GeneratedValue;

import javax.validation.constraints.Null;

import org.babyfish.jimmer.sql.GenerationType;

import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * 权限表
 */
@Entity
public interface TPermission {
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY
	)
	BigInteger id();
	
	/**
	 * 父ID
	 */
	BigInteger parentId();
	
	/**
	 * 权限名称
	 */
	String name();
	
	/**
	 * 类型(1：目录 2：菜单 3：按钮)
	 */
	@Null
	Object type();
	
	/**
	 * 菜单路由
	 */
	String menuUrl();
	
	/**
	 * 菜单图标
	 */
	String menuIcon();
	
	/**
	 * 管理系统中的显示顺序
	 */
	Long sort();
	
	/**
	 * 权限标识
	 */
	String permissionKey();
	
	/**
	 * 状态(0：启用；1：禁用)
	 */
	@Null
	Object status();
	
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

