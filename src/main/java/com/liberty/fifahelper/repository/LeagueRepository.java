package com.liberty.fifahelper.repository;

import com.liberty.fifahelper.model.League;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dmytro_Kovalskyi.
 * @since 11.10.2016.
 */
@Repository
public interface LeagueRepository extends MongoRepository<League, Long> {

    League findOneByAbbrName(String abbrName);
}
