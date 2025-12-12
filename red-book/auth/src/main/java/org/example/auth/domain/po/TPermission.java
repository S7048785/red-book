package org.example.auth.domain.po;

import org.babyfish.jimmer.sql.*;

import java.time.LocalDateTime;

/**
 * @author Nyxcirea
 * @date 2025/12/8 19:46
 * @description: 权限表
 */
@Table(name = "t_permission")
@Entity
public interface TPermission {
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY
	)
	long id();
	
	/**
	 * 父ID
	 */
	long parentId();
	
	/**
	 * 权限名称
	 */
	String name();
	
	/**
	 * 类型(1：目录 2：菜单 3：按钮)
	 */
	int type();
	
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
	int sort();
	
	/**
	 * 权限标识
	 */
	String permissionKey();
	
	/**
	 * 状态(0：启用；1：禁用)
	 */
	int status();
	
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
	@LogicalDeleted("true")
	boolean deleted();
}

