package com.lti.service;

import com.lti.dao.GenericDao;

import com.lti.entity.example.Song;

public class SongService {

	    
		public void openSong(Song song1) {
			 GenericDao dao= new GenericDao();
			 dao.save(song1);
}
}


