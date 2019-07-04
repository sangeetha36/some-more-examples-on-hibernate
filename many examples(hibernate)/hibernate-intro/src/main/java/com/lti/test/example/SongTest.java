package com.lti.test.example;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.example.Album;
import com.lti.entity.example.Song;
import com.lti.service.SongService;

public class SongTest {

	@Test
	
		public void testOpenSong() {
			 
			SongService s=new SongService();
			 Song so= new  Song();
			 GenericDao dao=new GenericDao();		
			 so.setTitle("aathi");
			 so.setSinger("G.V prakash");
			 so.setDuration(4.45);
			 Album al=(Album) dao.fetchById(Album.class, 184);
			 so.setAlbum(al);
			 s.openSong(so);
			 
		}

}
