package com.example.challenge;

import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Album, Long> {

	void save(Song newSong);

}
