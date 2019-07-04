package com.lti.test.example;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.entity.Account;
import com.lti.entity.example.Album;
import com.lti.service.AccountServices;
import com.lti.service.AlbumService;

public class AlbumTest {

	@Test
	
		public void testOpenAlbum() {
			 
			AlbumService albs=new AlbumService();
			 Album albb= new  Album();
			// albb.setId(1);
			 albb.setName("jazz");
			 albb.setCopyRight("WINK");
			 albb.setYear(2019);
			 albs.openAlbum(albb);
			 
		}

}
