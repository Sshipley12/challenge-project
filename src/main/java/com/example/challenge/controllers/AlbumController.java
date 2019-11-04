package com.example.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.challenge.models.Album;
import com.example.challenge.repository.AlbumRepository;

@RestController
@RequestMapping("/api")

public class AlbumController {

	@Autowired
	private AlbumRepository albumRepo;

	@GetMapping("/albums")
	@CrossOrigin
	public Iterable<Album> findAllAlbums() {
		return albumRepo.findAll();
	}

	@GetMapping("/albums/{id}")
	@CrossOrigin
	public Album findOneAlbum(@PathVariable Long id) {
		return albumRepo.findById(id).get();
	}

	@PostMapping("/albums")
	public Iterable<Album> postOneAlbum(Album album) {
		albumRepo.save(album);
		return albumRepo.findAll();
	}

}
