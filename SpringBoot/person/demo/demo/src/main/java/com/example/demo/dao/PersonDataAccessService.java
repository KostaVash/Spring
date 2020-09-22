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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insertPerson(final UUID id, final Person person) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
         String sql = "SELECT id, name FROM person";
         return jdbcTemplate.query(sql, (resultSet, i) -> {
             UUID id = UUID.fromString(resultSet.getString("id"));
             String name = resultSet.getString("name");
            return new Person(id, name);
        });

    }

    @Override
    public Optional<Person> selectPersonById(final UUID id) {
        String sql = "SELECT id, name FROM person WHERE id = ?";
         Person person = jdbcTemplate.queryForObject(sql, new Object[]{id},
            (resultSet, i) -> {
             UUID personId = UUID.fromString(resultSet.getString("id"));
             String name = resultSet.getString("name");
            return new Person(personId, name);
        });
        return Optional.ofNullable(person);
    }

    @Override
    public int updatePersonById(final UUID id, final Person person) {
        // TODO Auto-generated method stub
        return 0;
    }

   

    
}
