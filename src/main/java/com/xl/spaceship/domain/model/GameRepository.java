package com.xl.spaceship.domain.model;

public interface GameRepository {

    void add(Game game);

    Game getById(GameId gameId);

    void update(Game game);
}
