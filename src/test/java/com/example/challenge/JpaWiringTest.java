package com.example.challenge;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

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
	
	private Artist blake;
	private Album blakesAlbum;
	private Song blakesSong;
	
	@Before 
	public void setup() {
		blake = new Artist("blake","blakes album","blakes song");
		artistRepo.save(blake);
		blakesAlbum = new Album(blake, "blakes song")
		albumRepo.save(blakesSong);
		flushAndClearEntityManager();
	}
    
	@Test
	public void artistShouldHaveAlbums() throws Exception {
		Artist testArtist = new Artist("Test Name");
		Album testAlbum = new Album("Test Name", testArtist);
		testArtist = artistRepo.save(testArtist);
		testAlbum = albumRepo.save(testAlbum);
		entityManager.flush();
		entityManager.clear();
		Artist retrievedArtist = artistRepo.findById(testArtist.getId()).get();
		assertThat(retrievedArtist.getAlbums(), contains(testAlbum));
		
	}
	

}
