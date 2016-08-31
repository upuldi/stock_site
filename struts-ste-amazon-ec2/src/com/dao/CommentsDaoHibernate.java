package com.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.domain.Comment;

/**
 * Created by IntelliJ IDEA.
 * User: epsi
 * Date: 24-Jan-2012
 * Time: 22:06:51
 * To change this template use File | Settings | File Templates.
 */
public class CommentsDaoHibernate extends HibernateDaoSupport implements CommentsDao {

    public void addComment(Comment comment) {
        getHibernateTemplate().save(comment);
    }
}
