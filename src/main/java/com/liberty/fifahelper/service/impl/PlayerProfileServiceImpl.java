package com.liberty.fifahelper.service.impl;

import com.google.common.collect.Lists;
import com.liberty.fifahelper.model.PlayerProfile;
import com.liberty.fifahelper.repository.PlayerProfileRepository;
import com.liberty.fifahelper.service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author Dmytro_Kovalskyi.
 * @since 12.10.2016.
 */
@Service
public class PlayerProfileServiceImpl implements PlayerProfileService {

    public static final int MAX_PLAYERS = 30;

    @Autowired
    private PlayerProfileRepository repository;

    @Autowired
    private MongoTemplate template;

    @Override
    public List<PlayerProfile> searchByPhrase(String phrase) {
        Query query = new Query();
        Criteria criteria = Criteria.where("name").regex(phrase, "i");
        query.limit(MAX_PLAYERS);
        query.addCriteria(criteria);
        query.with(new Sort(Sort.Direction.DESC, "rating"));

        List<PlayerProfile> playerProfiles = template.find(query, PlayerProfile.class);
        if (playerProfiles == null) {
            return Collections.emptyList();
        }
        return playerProfiles;
    }

    @Override
    public Page<PlayerProfile> findAllByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public PlayerProfile findOne(String id) {
        return repository.findOne(id);
    }

    @Override
    public List<PlayerProfile> getAll(List<String> ids) {
        if (CollectionUtils.isEmpty(ids))
            return Collections.emptyList();
        return Lists.newArrayList(repository.findAll(ids));
    }

}
