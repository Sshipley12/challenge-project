package com.example.challenge;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import org.aspectj.lang.annotation.Before;
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
	
	private Artist testArtist;
	private Album testAlbum;
	

    
	@Test
	public void artistShouldHaveAlbums() throws Exception {
		Artist testArtist = new Artist("Test Name");
		Album testAlbum = new Album("Test Name", testArtist);
  		testArtist = artistRepo.save(testArtist);
	    testAlbum = albumRepo.save(testAlbum);
        entityManager.flush();	
	    entityManager.clear();
	   Artist retrievedArtist = artistRepo.findById(testArtist.getId()).get();
	  assertThat(retrievedArtist.getAlbums(), contains(testAlbum));	}
	
	  @Test
	  public void shouldStartJPATestFrameWork() {

	}
	

}
