package com.liberty.fifahelper.service;


import com.liberty.fifahelper.model.PlayerProfile;

import java.util.List;

/**
 * @author Dmytro_Kovalskyi.
 * @since 12.10.2016.
 */

public interface PlayerProfileService {

    List<PlayerProfile> searchByPhrase(String phrase);

    PlayerProfile findOne(String id);

    List<PlayerProfile> getAll(List<String> ids);
}
