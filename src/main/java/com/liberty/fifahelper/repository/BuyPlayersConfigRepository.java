package com.liberty.fifahelper.repository;

import com.liberty.fifahelper.model.BuyPlayersConfig;
import com.liberty.fifahelper.model.PlayerProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BuyPlayersConfigRepository extends MongoRepository<BuyPlayersConfig, String> {

}
