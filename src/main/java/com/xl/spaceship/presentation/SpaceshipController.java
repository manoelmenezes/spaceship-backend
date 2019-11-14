package com.xl.spaceship.presentation;

import com.xl.spaceship.application.GameApplicationService;
import com.xl.spaceship.application.command.CreateGameCmd;
import com.xl.spaceship.domain.model.GameId;
import com.xl.spaceship.query.model.GameCreatedDto;
import com.xl.spaceship.application.command.ReceiveSalvoCmd;
import com.xl.spaceship.query.model.SalvoResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xl-spaceship/protocol")
public final class SpaceshipController {

    private final GameApplicationService gameApplicationService;

    public SpaceshipController(GameApplicationService gameApplicationService) {
        this.gameApplicationService = gameApplicationService;
    }

    @PostMapping("/game/new")
    public ResponseEntity<GameCreatedDto> createGame(@RequestBody CreateGameCmd cmd) {
        GameCreatedDto gameCreatedDto = gameApplicationService.create(cmd);

        return ResponseEntity.ok(gameCreatedDto);
    }

    @PutMapping("/game/{gameId}")
    public ResponseEntity<SalvoResponseDto> receiveSalvo(@PathVariable String gameId, @RequestBody ReceiveSalvoCmd cmd) {
        SalvoResponseDto salvoResponseDto = gameApplicationService.receiveSalvo(GameId.of(gameId), cmd);

        return ResponseEntity.ok(salvoResponseDto);
    }

    @GetMapping
    public ResponseEntity<String> getOk() {
        return ResponseEntity.ok("ok");
    }

}
