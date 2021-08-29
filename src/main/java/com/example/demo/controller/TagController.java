package com.example.demo.controller;

import com.example.demo.entity.Tag;
import com.example.demo.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class TagController {
    @Autowired
    ITagService tagService;

    @GetMapping("/tags")
    public ResponseEntity<?> getAllTag() {
        List<Tag> tagList = (List<Tag>) tagService.findAll();
        if (tagList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tagList, HttpStatus.OK);
    }


    @GetMapping("/tags/{id}")
    public ResponseEntity<?> getTagById(@PathVariable Long id) {
        Optional<Tag> tag = tagService.findById(id);
        if (tag.isPresent()) {
            return new ResponseEntity<>(tag, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/tags")
    public ResponseEntity<?> createTag(@RequestBody Tag tag) {
        tagService.save(tag);
        return new ResponseEntity<>(tag, HttpStatus.CREATED);
    }

    @PutMapping("/tags/{id}")
    public ResponseEntity<?> updateTag(@RequestBody Tag tag, @PathVariable Long id) {
        Optional<Tag> tag1 = tagService.findById(id);
        if (tag1.isPresent()) {
            tag1.get().setName(tag.getName());
            tagService.save(tag1.get());
            return new ResponseEntity<>(tag1, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/tags/{id}")
    public ResponseEntity<?> deleteTag(@PathVariable Long id) {
        Optional<Tag> tag = tagService.findById(id);
        if (tag.isPresent()) {
            tagService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}