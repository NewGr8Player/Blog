package com.xavier.repository;

import com.xavier.domain.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * <p>文章CRUD</p>
 *
 * @author NewGr8player
 * @date 2017/10/21
 */
public interface ArticleRepository extends CrudRepository<Article, String> {

    /**
     * <p>根据文章标题模糊查询</p>
     *
     * @param title 文章标题
     * @return List&lt;Article&gt;
     */
    List<Article> findAllByTitleIsLike(String title);

    /**
     * <p>根据更新时间区间查询</p>
     *
     * @param startDate 日期区间开始
     * @param endDate   日期区间结束
     * @return List&lt;Article&gt;
     */
    List<Article> findAllByEditDateBetween(Date startDate, Date endDate);
}
