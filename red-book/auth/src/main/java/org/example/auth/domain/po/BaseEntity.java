package org.example.auth.domain.po;

import org.babyfish.jimmer.sql.MappedSuperclass;

import java.time.LocalDateTime;
/**
 * @author Nyxcirea
 * @date 2025/12/8 19:45
 * @description: 基础实体类
 */
@MappedSuperclass
public interface BaseEntity {

    LocalDateTime createTime();

    LocalDateTime updateTime();
}