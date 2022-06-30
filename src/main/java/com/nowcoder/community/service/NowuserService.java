package com.nowcoder.community.service;

import com.nowcoder.community.dao.NowuserMapper;
import com.nowcoder.community.entity.Nowuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NowuserService {
    @Autowired(required = false)
    private NowuserMapper nowuserMapper;

    //根据id查询用户（只返回一个，所以用Nowuser就可以了）
    public Nowuser findNowuserById(int id){
        return nowuserMapper.selectById(id);
    }

}
