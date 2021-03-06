package com.liberty.fifahelper.repository;

import com.liberty.fifahelper.model.PlayerProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dmytro_Kovalskyi.
 * @since 17.05.2016.
 */
@Repository
public interface PlayerProfileRepository extends MongoRepository<PlayerProfile, String> {

    @Query(value = "{'name': {$regex : ?0, $options: 'i'}}")
    List<PlayerProfile> findByName(String phrase);

    List<PlayerProfile> findAllByLeagueId(Long leagueId);
}
