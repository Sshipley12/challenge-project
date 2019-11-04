package com.example.challenge.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.challenge.models.Album;
import com.example.challenge.models.Song;

public interface SongRepository extends CrudRepository<Album, Long> {

	void save(Song newSong);

}
