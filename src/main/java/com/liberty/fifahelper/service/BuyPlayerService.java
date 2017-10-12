package com.liberty.fifahelper.service;

import com.liberty.fifahelper.model.BuyPlayerInfo;

import java.util.List;
import java.util.Map;

public interface BuyPlayerService {
    Map<String, BuyPlayerInfo> getPlayerInfo(List<String> ids);

    Map<String, BuyPlayerInfo> getAllPlayers(String userId);

    // todo: add validation
    void addPlayerForBuy(String userId, BuyPlayerInfo info);
}
