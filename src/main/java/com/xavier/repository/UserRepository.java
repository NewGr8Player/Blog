package com.xavier.repository;

import com.xavier.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * <p>用户的CRUD基本操作</p>
 *
 * @date 2017/10/06
 */
public interface UserRepository extends CrudRepository<User, String> {

    /**
     * <p>根据用户名查找用户</p>
     *
     * @see <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details"><b>Spring Data Jpa</b> - 3.4. Defining query methods</a>
     */
    User findByUsername(String username);
    User findUserById(String userId);
}
