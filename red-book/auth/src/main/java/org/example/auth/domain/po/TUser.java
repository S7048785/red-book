package org.example.auth.domain.po;

import jakarta.validation.constraints.Null;
import org.babyfish.jimmer.sql.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Nyxcirea
 * @date 2025/12/8 19:45
 * @description: 用户表
 */
@Table(name = "t_user")
@Entity
public interface TUser {
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY
	)
	long id();
	
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
	Integer sex();
	
	/**
	 * 状态(0：启用 1：禁用)
	 */
	int status();
	
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
	
	@ManyToMany
	@JoinTable(
			name = "t_user_role_rel",
								joinColumns = @JoinColumn(name = "user_id"),
								inverseJoinColumns = @JoinColumn(name = "roleId")
	)
	List<TRole> roles();
	
	/**
	 * 逻辑删除(0：未删除 1：已删除)
	 */
	@LogicalDeleted("true")
	boolean deleted();
}

