package org.example.auth.domain.po;

import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.Id;
import org.babyfish.jimmer.sql.GeneratedValue;
import org.babyfish.jimmer.sql.GenerationType;

import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * 用户角色表
 */
@Entity
public interface TUserRoleRel {
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY
	)
	BigInteger id();
	
	/**
	 * 用户ID
	 */
	BigInteger userId();
	
	/**
	 * 角色ID
	 */
	BigInteger roleId();
	
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

