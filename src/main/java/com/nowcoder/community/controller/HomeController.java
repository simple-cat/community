package com.nowcoder.community.controller;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Nowuser;
import com.nowcoder.community.entity.Page;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.NowuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired(required = false)
    private DiscussPostService discussPostService;  //注意注入的是service

    @Autowired
    private NowuserService nowuserService;

    @RequestMapping(path="/index",method = RequestMethod.GET)  //方法的访问路径，因为此方法响应的是网页，就不加@@ResponseBody
    public String getIndexPage(Model model, Page page){   //此处也可以返回ModelAndView，但返回String，并用Model参数，比较简单方便。Page用于实现分页功能
        //方法调用之前，SpringMVC会自动实例化Model和Page，并将Page注入Model中.
        // 所以，在thymeleaf中，可以直接访问Page对象中的数据，就不用再用model.addAttribute将page对象装入model
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list=discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());  //主页查询所有用户的帖子，（此处在优化的时候再替换为动态的）
        List<Map<String,Object>> discussPosts=new ArrayList<>();  //因为list得到的是用户的id，而我们需要用户名显示，所以这里再定义一个List数组，将list对象遍历后组装一下
        if(list!=null){
            for(DiscussPost post:list){
                Map<String ,Object> map =new HashMap<>();  //结果装在Map里，然后再用add()放在discussPosts对象集合里
                map.put("post",post);
                Nowuser nowuser=nowuserService.findNowuserById(post.getUserId());
                map.put("nowuser",nowuser);
                discussPosts.add(map);  //把map得到的结果放在上面第二行定义的集合里，得到的discussPosts中是帖子和用户信息两份数据
            }
        }
        //最后将需要展示的内容装到model里
        model.addAttribute("discussPosts",discussPosts);
        return "/index";   //返回templates目录下的index.html模板的路径
        //controller完成以后，就可以去处理index（模板）了
    }

}
