package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper   //使用@Mapper注解才能让容器识别，并自动装配
public interface DiscussPostMapper {
    //都为public 方法
    //1查询，后两个参数为帖子分页做准备。其中offset为页中起始行的行号，limit为页最大显示数量
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);
    //2查询帖子的行数（帖子分页用），userID为0时，查询所有帖子，@Param注解作用：给用户id添加的别名（此处设置别名相同）
    //注：如果需要在sql中动态地拼一个<if>条件，并且这个方法中有且只有这一个条件，就必须在这个参数前取一个别名，否则会报错
    int selectDiscussPostRows(@Param("userId") int userId);


}
