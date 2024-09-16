package com.tomasql.springdatajdbc.tennis_player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/* This class will have methods that execute various queries to
* manipulate rows of the Player table */
@Repository
public class PlayerDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    /* query method of JdbcTemplate is used to execute a SQL SELECT
    * query and map the result set to Java objects
    * it takes as parameters the sql query to execute, and an implementation
    * of the RowMapper inteface, wich map the rows from te result set to java
    * objects. Spring use BeanPropertyRowMapper
    *
    *  */
    public List<Player> getAllPlayers(){
        String sql = "SELECT * FROM PLAYER";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player> (Player.class));
    }

    public Player getPlayerById(int id) {
        String sql = "SELECT * FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<Player>(Player.class),
                new Object[] {id});
    }
    /*
    * The return type of the jdbcTemplate. method are an integer
    */
    public int insertPlayer(Player player) {
        String sql = "INSERT INTO PLAYER (ID, Nombre, Nacionalidad, Fecha_nacimiento, Titulos_ganados) " + "VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[] { player.getId(), player.getNombre(), player.getNacionalidad(), new Timestamp(player.getFecha_nacimiento().getTime()), player.getTitulos_ganados() });
    }

    public int updatePlayer(Player player){
        String sql = "UPDATE PLAYER " + "SET Nombre = ?, Nacionalidad = ?, Fecha_nacimiento = ?, Titulos_ganados = ?" +
                "WHERE ID = ?";
        return jdbcTemplate.update(sql, new Object[] {
                player.getNombre(),
                player.getNacionalidad(),
                new Timestamp(player.getFecha_nacimiento().getTime()),
                player.getTitulos_ganados(),
                player.getId()}
        );
    }

    public int deletePlayerById(int id) {
        String sql = "DELETE FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.update(sql, new Object[] {id});
    }
    /*
    * In a rare scenario we might want to create a table
    * this is part of Data Defintion Language
    */
    public void createTornamentTable() {
        String sql = "CREATE TABLE TOURNAMENT (ID INTEGER, Nombre VARCHAR(50), Ubicacion VARCHAR(50), PRIMARY KEY(ID))";
        jdbcTemplate.execute(sql);
        System.out.println("Tabla creada ...");
    }

    private static final class PlayerMapper implements RowMapper {
        @Override
        public Player mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Player player = new Player();
            player.setId(resultSet.getInt("id"));
            player.setNombre(resultSet.getString("Nombre"));
            player.setNacionalidad(resultSet.getString("Nacionalidad"));
            player.setFecha_nacimiento(resultSet.getDate("Fecha_nacimiento"));
            player.setTitulos_ganados(resultSet.getInt("Titulos_ganados"));
            return player;
        }
    }

    public List<Player> getPlayerByNacionalidad(String nacionalidad) {
        String sql = "SELECT * FROM PLAYER WHERE Nacionalidad = ?";
        return jdbcTemplate.query(sql, new PlayerMapper(), new Object[] {nacionalidad});
    }
}
