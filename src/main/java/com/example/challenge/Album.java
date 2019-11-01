package com.example.challenge;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Album {
	@Id
	@GeneratedValue Long id;
	
	@ManyToOne
	@JsonIgnore
	private Artist artist;
	
	
	
	private String name;

	
	
	@OneToMany(mappedBy="album")
	private Collection<Song> songs;
	public Album(String name, Artist artist) {
		this.artist = artist;
	
	}
	public Album(String name) {
		this.name = name;
	}
	
	
	@SuppressWarnings("unused")
	private Album() {
	}
	
	
	public Long getId() {
		return id;
	}
	public Collection<Song> getSongs() {
		return songs;
	}


	public String getName() {
		return name;
	}

	public Artist getArtist() {
		return artist;
	}
	public void addSong(Song song) {
		if (doesNotContainSong(song)) {
			this.songs.add(song);
		}
	}
	private boolean doesNotContainSong(Song song) {
		return false;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((songs == null) ? 0 : songs.hashCode());
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
		Album other = (Album) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
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
		if (songs == null) {
			if (other.songs != null)
				return false;
		} else if (!songs.equals(other.songs))
			return false;
		return true;
	}

	
}
