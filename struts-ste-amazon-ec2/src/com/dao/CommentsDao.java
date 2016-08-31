package com.dao;

import com.domain.Comment;

/**
 * Created by IntelliJ IDEA.
 * User: epsi
 * Date: 24-Jan-2012
 * Time: 22:06:35
 * To change this template use File | Settings | File Templates.
 */
public interface CommentsDao {

    void addComment(Comment comment);
}
