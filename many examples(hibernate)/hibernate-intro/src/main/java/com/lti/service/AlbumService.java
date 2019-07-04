package com.lti.service;

import com.lti.dao.AccountDao;
import com.lti.dao.GenericDao;
import com.lti.entity.Account;
import com.lti.entity.example.Album;

public class AlbumService {
	    
		public void openAlbum(Album album1) {
			 GenericDao dao= new GenericDao();
			 dao.save(album1);
}
}