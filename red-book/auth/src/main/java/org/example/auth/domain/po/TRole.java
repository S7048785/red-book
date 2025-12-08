package org.example.auth.domain.po;

import jakarta.validation.constraints.Null;
import org.babyfish.jimmer.sql.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Nyxcirea
 * @date 2024/5/23 15:40
 * @description: 角色表
 */
@Table(name = "t_role")
@Entity
public interface TRole {
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY
	)
	long id();
	
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
	int status();
	
	/**
	 * 管理系统中的显示顺序
	 */
	int sort();
	
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
	
	@ManyToMany
	@JoinTable(
			name = "t_role_permission_rel",
								joinColumns = @JoinColumn(name = "role_id"),
								inverseJoinColumns = @JoinColumn(name = "permission_id")
	)
	List<TPermission> permissions();
	
	/**
	 * 逻辑删除(0：未删除 1：已删除)
	 */
	@LogicalDeleted("true")
	boolean deleted();
}

