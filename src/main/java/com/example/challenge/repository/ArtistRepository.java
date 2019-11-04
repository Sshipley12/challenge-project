package com.example.challenge.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.challenge.models.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long> {

}
