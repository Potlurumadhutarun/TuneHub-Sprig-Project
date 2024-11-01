package com.example.sbweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.sbweb.entities.Songs;

public interface SongsRepository extends JpaRepository<Songs,Integer>{
	public Songs findByName(String name);
	
}
