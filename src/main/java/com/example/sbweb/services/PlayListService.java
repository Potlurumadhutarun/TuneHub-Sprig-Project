package com.example.sbweb.services;

import java.util.List;

import com.example.sbweb.entities.Playlist;

public interface PlayListService {
	

	public void addPlaylist(Playlist playlist);

	List<Playlist> fetchPlaylists();

}
