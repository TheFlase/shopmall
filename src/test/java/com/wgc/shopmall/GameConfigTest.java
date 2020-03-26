package com.wgc.shopmall;

import com.wgc.shopmall.model.monster.GameConfig;
import com.wgc.shopmall.service.IGameConfigService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 3/26/2020
 **/
@SpringBootTest
public class GameConfigTest {
    @Autowired
    private IGameConfigService gameConfigService;


    @Test
    public void listAllGameConfig(){
        List<GameConfig> configList = gameConfigService.listAllGameConfig();
        System.out.println(configList.toString());
    }
}
