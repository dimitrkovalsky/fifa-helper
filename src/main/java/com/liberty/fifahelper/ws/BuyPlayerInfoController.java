package com.liberty.fifahelper.ws;

import com.liberty.fifahelper.model.BuyPlayerInfo;
import com.liberty.fifahelper.service.BuyPlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/get", method = RequestMethod.POST)
    public Map<String, BuyPlayerInfo> get(@RequestBody List<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            log.info("Can not found info about player for empty ids");
            return Collections.emptyMap();
        }
        log.info("Trying to found info for {} players", ids.size());
        return buyPlayerService.getPlayerInfo(ids);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping( method = RequestMethod.GET)
    public String info() {
        log.info("Server is app");
        return "Server is app";
    }
}
