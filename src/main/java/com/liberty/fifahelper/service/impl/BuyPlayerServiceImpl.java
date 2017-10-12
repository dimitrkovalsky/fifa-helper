package com.liberty.fifahelper.service.impl;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.liberty.fifahelper.model.BuyPlayerInfo;
import com.liberty.fifahelper.model.BuyPlayersConfig;
import com.liberty.fifahelper.repository.BuyPlayersConfigRepository;
import com.liberty.fifahelper.service.BuyPlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BuyPlayerServiceImpl implements BuyPlayerService {

    public static final String USER_ID = "ADMIN";
    @Autowired
    private BuyPlayersConfigRepository playersConfigRepository;

    @Override
    public Map<String, BuyPlayerInfo> getPlayerInfo(List<String> ids) {
        return getPlayerInfo(USER_ID, ids);
    }

    @Override
    public Map<String, BuyPlayerInfo> getAllPlayers(String userId) {
        return getUserConfig(userId).getPlayers();
    }

    private Map<String, BuyPlayerInfo> getPlayerInfo(String userId, List<String> ids) {
        BuyPlayersConfig one = getUserConfig(userId);
        Map<String, BuyPlayerInfo> map = new HashMap<>();
        for (String id : ids) {
            BuyPlayerInfo buyPlayerInfo = one.getPlayers().get(id);
            if (buyPlayerInfo != null) {
                map.put(id, buyPlayerInfo);
            }
        }
        return map;
    }

    private BuyPlayersConfig getUserConfig(String userId) {
        BuyPlayersConfig config = playersConfigRepository.findOne(userId);
        if (config == null) {
            log.warn("User with id : {} does not exist. Creating config");
            config = new BuyPlayersConfig();
            config.setUserId(userId);
            playersConfigRepository.save(config);
        }
        return config;
    }

    // todo: add validation
    @Override
    public void addPlayerForBuy(String userId, BuyPlayerInfo info) {
        BuyPlayersConfig config = playersConfigRepository.findOne(userId);
        if (config == null) {
            log.error("User with id : {} does not exist");
            return;
        }
        config.addPlayer(info);
        playersConfigRepository.save(config);
        log.info("Successfully updated player : {} info for user : {}", info.getPlayerId(), userId);
    }
}
