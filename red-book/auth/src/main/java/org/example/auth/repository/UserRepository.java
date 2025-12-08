package org.example.auth.repository;

import lombok.RequiredArgsConstructor;
import org.babyfish.jimmer.sql.JSqlClient;
import org.example.auth.domain.po.*;
import org.example.auth.dto.user.UserLoginReqInput;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Nyxcirea
 * @date 2025/12/8
 * @description: 用户Repository
 */
@Repository
@RequiredArgsConstructor
public class UserRepository {
	private final JSqlClient sqlClient;
	
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
	
	public long register(UserLoginReqInput userLoginReqInput) {
		// 注册用户并分配一个默认的角色
		TUser produce = TUserDraft.$.produce(draft -> draft.setPhone(userLoginReqInput.getPhone())
				.setPassword(userLoginReqInput.getPassword())
				.setNickname(userLoginReqInput.getPhone())
				.setStatus(0)
				// 默认角色为普通用户
        .addIntoRoles(role -> role.setId(1))
		);
		
		long userId = sqlClient.save(produce).getOriginalEntity().id();
		
		sqlClient.save(TRoleTable.$).getOriginalEntity().id();
		return userId;
	}
}
