package com.example.sbweb.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sbweb.entities.Playlist;
import com.example.sbweb.entities.Songs;
import com.example.sbweb.services.PlayListService;
import com.example.sbweb.services.SongsService;

@Controller
public class PlayListController {
	@Autowired
	PlayListService pserv;
	
	@Autowired
	SongsService sserv;
	
	@GetMapping("createplaylist")
	public String createPlayList(Model model) {
		//Fetching the songs using songs service
		List<Songs> songslist=sserv.fetchAllSongs();
		//adding songs in the model
		model.addAttribute("songslist", songslist);
		//sending create playlist
		return "createplaylist";
		
	}
	@PostMapping("addplaylist")
	public String addPlayList(@ModelAttribute Playlist playlist) {
		//adding playlist
		pserv.addPlaylist(playlist);
		//updating song table
		
		List<Songs> songsList=playlist.getSongs();
		for(Songs song : songsList) {
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
		}
		return "playlistsuccess";
	}
	@GetMapping("/viewplaylists")
	public String viewPlaylists(Model model) {
		List<Playlist> plist=pserv.fetchPlaylists();
		model.addAttribute("plist",plist);
		return "viewplaylists";
	}


}
