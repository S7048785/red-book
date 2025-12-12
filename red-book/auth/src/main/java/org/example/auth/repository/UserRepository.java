package org.example.auth.repository;

import cn.hutool.json.JSONUtil;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.babyfish.jimmer.sql.JSqlClient;
import org.example.auth.constant.RedisKeyConstant;
import org.example.auth.constant.RoleConstant;
import org.example.auth.domain.po.TUser;
import org.example.auth.domain.po.TUserDraft;
import org.example.auth.domain.po.TUserTable;
import org.example.auth.dto.user.UserLoginReqInput;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nyxcirea
 * @date 2025/12/8
 * @description: 用户Repository
 */
@Repository
@RequiredArgsConstructor
public class UserRepository {
	private final JSqlClient sqlClient;
	private final StringRedisTemplate redisTemplate;
	
	/**
	 * 根据手机号查询用户
	 * @param phone 手机号
	 * @return 用户信息
	 */
	public TUser findByPhone(String phone) {
		return sqlClient.createQuery(TUserTable.$)
				       .where(TUserTable.$.phone().eq(phone))
				       .select(TUserTable.$)
				       .fetchOneOrNull();
	}
	
	@Transactional
	public long register(UserLoginReqInput userLoginReqInput) {
		String phone = userLoginReqInput.getPhone();
		// 获取全局自增的 ID
		Long redBookId = redisTemplate.opsForValue().increment(RedisKeyConstant.buildUserRoleKey(phone));
		
		// 注册用户并分配一个默认的角色
		TUser produce = TUserDraft.$.produce(draft -> {
					assert redBookId != null;
					draft.setRedBookId(redBookId.toString())
							.setPhone(phone)
							.setPassword(userLoginReqInput.getPassword())
							.setNickname(phone)
							.setStatus(0)
							// 默认角色为普通用户
			        .addIntoRoles(role -> role.setId(RoleConstant.COMMON_USER_ROLE_ID));
				}
		);
		
		long userId = sqlClient.save(produce).getModifiedEntity().id();
		
		// 将该用户的角色 ID 存入 Redis 中
		var roles = Lists.newArrayList();
		roles.add(RoleConstant.COMMON_USER_ROLE_ID);
		redisTemplate.opsForValue().set(RedisKeyConstant.buildUserRoleKey(phone), JSONUtil.toJsonStr(roles));
		return userId;
	}
}
