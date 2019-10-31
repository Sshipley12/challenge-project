package com.example.challenge;

import java.util.Collection;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Artist {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	
	@OneToMany(mappedBy = "artist")
	private Collection<Album> albums;
	
	
	public Artist(String name) {
		this.name = name;
		this.albums = new ArrayList<Album>();
	}
	@SuppressWarnings("unused")
	private Artist() {
		
	}
	public String getName() {
		return name;
	}
	
	public Long getId() {
		return id;
	}

	public Collection<Album> getAlbums() {
		return albums;
	}
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((albums == null) ? 0 : albums.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artist other = (Artist) obj;
		if (albums == null) {
			if (other.albums != null)
				return false;
		} else if (!albums.equals(other.albums))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}