package com.springframework.repositories;

import com.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
