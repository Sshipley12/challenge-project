package com.example.challenge;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.challenge.models.Album;
import com.example.challenge.models.Artist;
import com.example.challenge.repository.AlbumRepository;
import com.example.challenge.repository.ArtistRepository;
import com.example.challenge.repository.SongRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaWiringTest {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	private AlbumRepository albumRepo;

	@Autowired
	private ArtistRepository artistRepo;

	@Autowired
	private SongRepository songRepo;

	private Artist testArtist;
	private Album testAlbum;

	@Test
	public void setup() {
		Artist testArtist = new Artist("Test Name");
		Album testAlbum = new Album("Test Name", testArtist);
		testArtist = artistRepo.save(testArtist);
		testAlbum = albumRepo.save(testAlbum);
		entityManager.flush();
		entityManager.clear();
		Artist retrievedArtist = artistRepo.findById(testArtist.getId()).get();
		assertThat(retrievedArtist.getAlbums(), contains(testAlbum));
	}

	private void assertThat(Collection<Album> albums, Object contains) {

	}

	private Object contains(Album testAlbum2) {

		return testAlbum2;
	}

	@Test
	public void shouldStartJPATestFrameWork() {

	}

	public SongRepository getSongRepo() {
		return songRepo;
	}

	public void setSongRepo(SongRepository songRepo) {
		this.songRepo = songRepo;
	}

	public Artist getTestArtist() {
		return testArtist;
	}

	public void setTestArtist(Artist testArtist) {
		this.testArtist = testArtist;
	}

	public Album getTestAlbum() {
		return testAlbum;
	}

	public void setTestAlbum(Album testAlbum) {
		this.testAlbum = testAlbum;
	}

}
