package com.example.challenge;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AlbumControllerTest {

	@InjectMocks
	private AlbumController underTest;
	@Mock
	private AlbumRepository albumRepo;
	@Mock
	private Album mockAlbum;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

}
