package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Nowuser;
import com.nowcoder.community.service.NowuserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)   //将运行的测试代码设置为以原来src中运行类为测试类
class CommunityApplicationTests implements ApplicationContextAware {
    //IoC的核心是Spring容器，而容器是被自动创建的。当我们想要获取到这个容器，那就实现这个接口

    private ApplicationContext applicationContext;  //定义一个记录容器的变量，方便后续使用

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;   //记录下容器
    }
    //当程序运行时application就自动被传进到变量中，在其他地方可使用

    @Autowired(required = false)
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectPosts(){
        //查询每一行的数据
        //List<DiscussPost> list=discussPostMapper.selectDiscussPosts(0,0,10);   //后两个参数：第一页数据行号从0开始，一页10行数据
        //for(DiscussPost post:list){
          //  System.out.println(post);
        //}
        //查询总行数
        int rows=discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }

    @Autowired(required = false)
    private NowuserService nowuserService;
    @Test
    public void testSelectNowuser(){
        Nowuser nowuser=nowuserService.findNowuserById(101);
        System.out.println(nowuser);
    }



}
