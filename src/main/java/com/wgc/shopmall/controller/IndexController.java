package com.wgc.shopmall.controller;

import com.wgc.shopmall.model.Book;
import com.wgc.shopmall.model.User;
import com.wgc.shopmall.model.monster.GameConfig;
import com.wgc.shopmall.service.IBookService;
import com.wgc.shopmall.service.IGameConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 3/25/2020
 **/
@Controller
@RequestMapping("/index/")
public class IndexController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IGameConfigService gameConfigService;

    @RequestMapping("getThymeleaf")
    public String thymeleafTest(@RequestParam(defaultValue = "world", required = false) String name, Model model){
        model.addAttribute("name",name);
        return "thymeleaf/index";
    }

    @RequestMapping("freemarker")
    public String freeMarkerTest(Model model){
        User user = new User();
        user.setUsername("yukong");
        user.setPassword("abc123");
        user.setAge(18);
        user.setSex(1);
        model.addAttribute("user", user);
        return "freemarker/index";
    }

    @RequestMapping("listAllBook")
    @ResponseBody
    public List<Book> listAllBook(){
        return bookService.listAllBook();
    }

    @RequestMapping("listAllGameConfig")
    @ResponseBody
    public List<GameConfig> listAllGameConfig(){
        return gameConfigService.listAllGameConfig();
    }


}
