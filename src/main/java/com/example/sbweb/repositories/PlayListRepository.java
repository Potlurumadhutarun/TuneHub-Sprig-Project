package com.example.sbweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.sbweb.entities.Playlist;

public interface PlayListRepository extends JpaRepository<Playlist,Integer>{

}
