package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Nowuser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NowuserMapper {
    //根据用户id查询单个记录
    Nowuser selectById(int id);
    //根据email查询单个记录
    Nowuser selectByEmail(String email);
    //根据姓名查询单个记录
    Nowuser selectByName(String username);
    //插入记录
    int insertNowuser(Nowuser nowuser);
    //修改记录
    int updateStatus(int id,int userStatus);
    int updateHeader(int id,String headerUrl);
    int updateUserpass(int id,String userpass);

}
