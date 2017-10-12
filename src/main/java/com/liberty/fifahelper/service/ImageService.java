package com.liberty.fifahelper.service;


import com.liberty.fifahelper.model.Club;
import com.liberty.fifahelper.model.League;
import com.liberty.fifahelper.model.Nation;
import com.mongodb.gridfs.GridFSDBFile;

import java.util.Optional;

/**
 * @author Dmytro_Kovalskyi.
 * @since 11.10.2016.
 */
public interface ImageService {

    void saveImage(String url, String playerId);

    Optional<GridFSDBFile> getImage(String playerId);

    Optional<GridFSDBFile> getClubImage(long clubId);

    Optional<GridFSDBFile> getLeagueImage(long leagueId);

    Optional<GridFSDBFile> getNationImage(long nationId);

    void saveClubImage(Club club);

    void saveLeagueImage(League league);

    void saveNationImage(Nation nation);
}
