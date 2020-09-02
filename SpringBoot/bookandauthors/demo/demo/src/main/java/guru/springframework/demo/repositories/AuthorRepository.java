package guru.springframework.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.demo.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
    
}
