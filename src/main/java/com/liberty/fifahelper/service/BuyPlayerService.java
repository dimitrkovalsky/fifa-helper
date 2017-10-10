package com.liberty.fifahelper.service;

import com.liberty.fifahelper.model.BuyPlayerInfo;

import java.util.List;
import java.util.Map;

public interface BuyPlayerService {
    Map<Long,BuyPlayerInfo> getPlayerInfo(List<Long> ids);
}
