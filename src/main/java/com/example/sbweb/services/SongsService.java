package com.example.sbweb.services;

import java.util.List;

import com.example.sbweb.entities.Songs;

import ch.qos.logback.core.model.Model;

public interface SongsService {
	public String addSongs(Songs song);
	public boolean songExists(String name);
	public List<Songs> fetchAllSongs();
	List<Songs> viewSongs();
	//playlist
	public void updateSong(Songs song);

}
