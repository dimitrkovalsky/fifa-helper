package easports.client;


import easports.model.PlayerPriceLimits;

public interface EaSportsClient {

    PlayerPriceLimits getPriceLimits(String playerId);
}
