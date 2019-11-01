package com.example.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")


public class ArtistController {

	@Autowired
	private ArtistRepository artistRepo;

	@GetMapping("/artists")
	@CrossOrigin
	public Iterable<Artist> findAllArtists() {
		return artistRepo.findAll();
	}
	
	@GetMapping("/artists/{id}")
	@CrossOrigin
	public Artist findOneArtist(@PathVariable Long id) {
		return artistRepo.findById(id).get();
	}
	
	@PostMapping("/artists")
	public Iterable<Artist> postOneArtist(@RequestBody Artist artist) {
		artistRepo.save(artist);
		return artistRepo.findAll();
	}

	
}




