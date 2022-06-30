package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    //为什么不直接调用Mapper?
    //1.即便当前业务方法很简单，没有任何的处理，但或许以后需要对查询结果在业务层面，进行一些必要的处理，如果没有这一方法就难加代码
    //2.代码的层次应严格按照结构要求，若跨层次调用，可能造成后续在处理程序的安全性等各个方面遇到麻烦
    //所以即便service中方法再简单，也需要controller去调用service，而不要直接去调用mapper

    //注入依赖
    @Autowired(required = false)
    private DiscussPostMapper discussPostMapper;
    //查询帖子
    public List<DiscussPost> findDiscussPosts(int userId,int offset,int limit){
        return discussPostMapper.selectDiscussPosts(userId,offset,limit);
    }
    //查询行数
    public int findDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
