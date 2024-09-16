package com.tomasql.springdatajdbc.tennis_player;

import java.sql.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerDao dao;

	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        dao.createTornamentTable();
        logger.info("\nDatos de todos los jugadores: {}", dao.getAllPlayers());
        logger.info("\nJugador con id 3: {}", dao.getPlayerById(3));
        /* The insertPlayer method return 1, wich means that 1 ROW has been
         * affected by the query (in the run app) */
        logger.info("\nInsertando el jugador 4: {}", dao.insertPlayer(
                new Player(4, "Thiem", "Austria", new Date(System.currentTimeMillis()), 17 )));
        logger.info("\nDatos de todos los jugadores: {}", dao.getAllPlayers());
        logger.info("\nActualizando al jugaor con ID 4: {}", dao.updatePlayer(
                new Player(4, "Thiem", "Austria",
                        Date.valueOf("1993-09-03"), 17
        )));
        logger.info("\nJugador con ID 4: {}", dao.getPlayerById(4));
        logger.info("\nEliminando al Jugador con ID 2: {}", dao.deletePlayerById(2));
        logger.info("\nDatos de todos los Jugadores: {}", dao.getAllPlayers());
        logger.info("\nInsertando el jugador 4: {}", dao.insertPlayer(
                new Player(2, "Jugador X", "France", new Date(System.currentTimeMillis()), 2 )));
        logger.info("\nLos jugadores Franceses son: {}", dao.getPlayerByNacionalidad("France"));
    }
}
