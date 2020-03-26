package com.wgc.shopmall.service.impl;

import com.wgc.shopmall.dao.monster.GameConfigDao;
import com.wgc.shopmall.model.monster.GameConfig;
import com.wgc.shopmall.service.IGameConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 3/26/2020
 **/
@Service
public class GameConfigImpl implements IGameConfigService {
    @Autowired
    private GameConfigDao gameConfigDao;

    @Override
    public List<GameConfig> listAllGameConfig() {
        return gameConfigDao.listAllGameConfig();
    }
}
