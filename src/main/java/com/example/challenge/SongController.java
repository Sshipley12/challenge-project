package com.example.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class SongController {
	@Autowired
	private SongRepository songRepo;

	@GetMapping("/songs")
	@CrossOrigin
	public Iterable<Album> findAllSongs() {
		return songRepo.findAll();
	}

	
	@GetMapping("/songs/{id}")
	@CrossOrigin
	public Album findOneSong(@PathVariable Long id) {
		return songRepo.findById(id).get();
	}

	@PostMapping("/songs")
	public Iterable<Album> postOneSong(Song song) {
		songRepo.save(song);
		return songRepo.findAll();
	}
	
	

}
