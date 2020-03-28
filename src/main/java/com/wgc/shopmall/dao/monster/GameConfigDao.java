package com.wgc.shopmall.dao.monster;

import com.wgc.shopmall.model.monster.GameConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 3/26/2020
 **/
public interface GameConfigDao {
    List<GameConfig> listAllGameConfig();
}
