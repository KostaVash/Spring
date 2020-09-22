package com.example.demo.dao;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public PersonDataAccessService(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int deletePersonById(final UUID id) {
        String sql = "" +
        "DELETE FROM person " +
        "WHERE id = ?";
        return jdbcTemplate.update(sql, id);
            }

    @Override
    public int insertPerson(final UUID id, final Person person) {

        String sql = "INSERT INTO person (id,name) VALUES (? , ? )";
        return jdbcTemplate.update(sql, id , person.getName());
    }

    @Override
    public List<Person> selectAllPeople() {
         final String sql = "SELECT id, name FROM person";
         return jdbcTemplate.query(sql, (resultSet, i) -> {
             final UUID id = UUID.fromString(resultSet.getString("id"));
             final String name = resultSet.getString("name");
            return new Person(id, name);
        });

    }

    @Override
    public Optional<Person> selectPersonById(final UUID id) {
        final String sql = "SELECT id, name FROM person WHERE id = ?";
         final Person person = jdbcTemplate.queryForObject(sql, new Object[]{id},
            (resultSet, i) -> {
             final UUID personId = UUID.fromString(resultSet.getString("id"));
             final String name = resultSet.getString("name");
            return new Person(personId, name);
        });
        return Optional.ofNullable(person);
    }

    @Override
    public int updatePersonById(final UUID id, final Person person) {
     
        String sql = "" +
        "UPDATE person " +
        "SET name = ? " +
        "WHERE id = ?";
        return jdbcTemplate.update(sql,  person.getName(),id);
        
    }

   

    
}
