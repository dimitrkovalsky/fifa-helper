package com.liberty.fifahelper.crawler;


import com.liberty.fifahelper.model.FifaPlayerSuggestion;
import com.liberty.fifahelper.model.PlayerProfile;
import com.liberty.fifahelper.repository.PlayerProfileRepository;
import com.liberty.fifahelper.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Dmytro_Kovalskyi.
 * @since 16.05.2016.
 */
@Component
@Slf4j
public class CrawlerServiceImpl implements CrawlerService {

    @Autowired
    private FifaDatabaseProcessor processor;

    @Autowired
    private PlayerProfileRepository profileRepository;

    @Autowired
    private ImageService imageService;

    @Override
    public void fetchData(String playerId) {
        PlayerProfile profile = profileRepository.findOne(playerId);
        if (profile == null) {
            Optional<PlayerProfile> maybeProfile = processor.fetchInfo(playerId);
            if (!maybeProfile.isPresent()) {
                log.error("Can not fetch data for playerId : " + playerId);
                return;
            }
            profile = maybeProfile.get();
        }
        else {
            log.info("Player profile with id : " + playerId + " already exists");
        }
        profileRepository.save(profile);
        imageService.saveImage(profile.getHeadshotImgUrl(), playerId);
    }

    @Override
    public void fetchAllPlayers() {
        List<FifaPlayerSuggestion> suggestions = processor.readSuggestions();
        List<FifaPlayerSuggestion> players = suggestions;
        //    suggestions.stream()
        //        .filter(x -> x.getRating() >= 80)
        //        .collect(Collectors.toList());

        log.info("Trying to fetch data for : " + players.size() + " players");
        AtomicInteger counter = new AtomicInteger(0);
        players.parallelStream().forEach(p -> {
            fetchData(p.getId());
            log.info("Fetched " + counter.incrementAndGet() + " / " + players.size());
        });
    }

}
