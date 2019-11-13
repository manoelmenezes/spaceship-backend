package com.xl.spaceship.query.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class GameCreatedDto {

    @JsonProperty("user_id")
    private final String userId;

    @JsonProperty("full_name")
    private final String fullName;

    @JsonProperty("game_id")
    private final String gameId;

    private final String starting;

    public GameCreatedDto(String userId, String fullName, String gameId, String starting) {
        this.userId = userId;
        this.fullName = fullName;
        this.gameId = gameId;
        this.starting = starting;
    }

    public String getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGameId() {
        return gameId;
    }

    public String getStarting() {
        return starting;
    }
}
