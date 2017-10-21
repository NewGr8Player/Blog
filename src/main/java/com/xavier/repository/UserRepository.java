package com.xavier.repository;

import com.xavier.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * <p>用户的CRUD基本操作</p>
 *
 * @date 2017/10/06
 * @see <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details"><b>Spring Data Jpa</b> - 3.4. Defining query methods</a>
 */
public interface UserRepository extends CrudRepository<User, String> {

    /**
     * <p>根据用户名查找用户</p>
     *
     * @param username 用户名
     * @return User User实体
     */
    User findFirstByUsername(String username);
}
