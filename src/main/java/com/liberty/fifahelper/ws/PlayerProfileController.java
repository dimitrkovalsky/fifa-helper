package com.liberty.fifahelper.ws;

import com.liberty.fifahelper.model.PlayerProfile;
import com.liberty.fifahelper.service.PlayerProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/profiles")
@CrossOrigin(origins = "*")
@Slf4j
public class PlayerProfileController {
    @Autowired
    private PlayerProfileService playerProfileService;

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public List<PlayerProfile> getAll(@RequestParam @NotNull String phrase) {
        return playerProfileService.searchByPhrase(phrase);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    public PlayerProfile get(@PathVariable String id) {
        return playerProfileService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<PlayerProfile> getAllPageable(@RequestParam Pageable pageable) {
        return playerProfileService.findAllByPage(pageable);
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<PlayerProfile> getByIds(@RequestBody @NotNull List<String> ids) {
        return playerProfileService.getAll(ids);
    }
}
