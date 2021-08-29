package com.example.demo.service.impl;


import com.example.demo.entity.Tag;
import com.example.demo.repository.ITagRepository;
import com.example.demo.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagServiceImpl implements ITagService {
    @Autowired
    ITagRepository tagRepository;

    @Override
    public Iterable<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> findById(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public Iterable<Tag> findTagsByName(String tag_name) {
        return tagRepository.findTagsByName(tag_name);
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void delete(Long id) {
        tagRepository.deleteById(id);
    }
}