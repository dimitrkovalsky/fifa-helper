package com.liberty.fifahelper.service.impl;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.liberty.fifahelper.model.BuyPlayerInfo;
import com.liberty.fifahelper.service.BuyPlayerService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuyPlayerServiceImpl implements BuyPlayerService {

    @Override
    public Map<Long, BuyPlayerInfo> getPlayerInfo(List<Long> ids) {
        Map<Long, BuyPlayerInfo> map = new HashMap<>();
        ids.forEach(id -> map.put(id, new BuyPlayerInfo(id, "pl_" + id, 1000L)));
        return map;
    }
}
