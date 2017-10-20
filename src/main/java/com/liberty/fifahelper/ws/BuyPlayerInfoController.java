package com.liberty.fifahelper.ws;

import com.liberty.fifahelper.model.BuyPlayerInfo;
import com.liberty.fifahelper.model.PlayerMonitoring;
import com.liberty.fifahelper.service.BuyPlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/player/buy")
@CrossOrigin(origins = "*")
@Slf4j
public class BuyPlayerInfoController {
    @Autowired
    private BuyPlayerService buyPlayerService;

    @RequestMapping(path = "/get", method = RequestMethod.POST)
    public Map<String, BuyPlayerInfo> get(@RequestBody List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            log.info("Can not found info about player for empty ids");
            return Collections.emptyMap();
        }
        log.info("Trying to found info for {} players", ids.size());
        return buyPlayerService.getPlayerInfo(ids);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody @Valid BuyPlayerInfo info) {
        buyPlayerService.addPlayerForBuy("ADMIN", info);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, BuyPlayerInfo> getAll(@RequestParam String userId) {
        return buyPlayerService.getAllPlayers(userId);
    }

    @RequestMapping(path = "/full", method = RequestMethod.GET)
    public List<PlayerMonitoring> getFullPlayers(@RequestParam String userId) {
        return buyPlayerService.geMonitoringProfiles(userId);
    }
}
