package com.example.demo.repository;

import com.example.demo.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagRepository extends CrudRepository<Tag, Long> {
    Iterable<Tag> findTagsByName(String tag_name);
}