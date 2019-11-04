package com.example.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.challenge.models.Album;
import com.example.challenge.models.Artist;
import com.example.challenge.models.Song;
import com.example.challenge.repository.AlbumRepository;
import com.example.challenge.repository.ArtistRepository;
import com.example.challenge.repository.SongRepository;

@Service
public class Initializer implements CommandLineRunner {

	@Autowired
	SongRepository songRepository;

	@Autowired
	AlbumRepository albumRepository;

	@Autowired
	ArtistRepository artistRepository;

	Artist Blake;
	Artist Keith;
	Artist Darius;

	Album blakeAlbum;
	Album keithAlbum;
	Album dariusAlbum;

	@Override
	public void run(String... args) throws Exception {
		populateArtists();
		populateAlbums();
		populateSongs();
	}

	private void populateSongs() {

		Song blakeSong1 = new Song(blakeAlbum, "Gods Country");
		songRepository.save(blakeSong1);

		Song blakeSong2 = new Song(blakeAlbum, "Came Here to Forget");
		songRepository.save(blakeSong2);

		Song blakeSong3 = new Song(blakeAlbum, "I Lived It");
		songRepository.save(blakeSong3);

		Song keithSong1 = new Song(keithAlbum, "Drop Top");
		songRepository.save(keithSong1);

		Song keithSong2 = new Song(keithAlbum, "Female");
		songRepository.save(keithSong2);

		Song keithSong3 = new Song(keithAlbum, "Way Too Long");
		songRepository.save(keithSong3);

		Song dariusSong1 = new Song(dariusAlbum, "For the First Time");
		songRepository.save(dariusSong1);

		Song dariusSong2 = new Song(dariusAlbum, "Bring it On");
		songRepository.save(dariusSong2);

		Song dariusSong3 = new Song(blakeAlbum, "She");
		songRepository.save(dariusSong3);

	}

	private void populateAlbums() {

		Album blakeAlbum1 = new Album("Gods Country");
		albumRepository.save(blakeAlbum1);

		Album keithAlbum1 = new Album("Graffiti U");
		albumRepository.save(keithAlbum1);

		Album dariusAlbum1 = new Album("When Was the Last Time");
		albumRepository.save(dariusAlbum1);

	}

	private void populateArtists() {

		Artist blake = new Artist("Blake Shelton");
		artistRepository.save(blake);

		Artist keith = new Artist("Keith Urban");
		artistRepository.save(keith);

		Artist darius = new Artist("Darius Rucker");
		artistRepository.save(darius);
	}

	;
}
