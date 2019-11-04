package com.example.challenge.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.challenge.models.Album;

public interface AlbumRepository extends CrudRepository<Album, Long> {

}
