package com.liberty.fifahelper.service.impl;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.liberty.fifahelper.model.BuyPlayerInfo;
import com.liberty.fifahelper.service.BuyPlayerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BuyPlayerServiceImpl implements BuyPlayerService {

    @Override
    public Map<Long, BuyPlayerInfo> getPlayerInfo(List<Long> ids) {
        return ImmutableMap.of(1L, new BuyPlayerInfo(1L, "test", 1000L));
    }
}
