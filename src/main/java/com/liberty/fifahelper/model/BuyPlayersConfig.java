package com.liberty.fifahelper.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Data
@Document(collection = "player_config")
public class BuyPlayersConfig {
    @Id
    private String userId;
    private Map<String, BuyPlayerInfo> players = new HashMap<>();

    public void addPlayer(BuyPlayerInfo info) {
        players.put(info.getPlayerId(), info);
    }
}
