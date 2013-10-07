package com.example.androiddemo;

public class Config {

	public final static boolean DEBUD_MODE = true;
	public final static String PROJECT_NAME = "AndroidDemo";
	
	public final static String FLICKR_KEY = "";
	public final static String FLICKR_SCERT = "";
	
	public final static int MEMORY_CACHE_SIZE = 5 * 1024 * 1024;
	
	public final static String USER_ID = "38039613@N08";
	public final static String API_URL = "http://api.flickr.com/services/rest/?method=%s&api_key=%s&user_id=%s&format=json&nojsoncallback=1";
	public final static String FETCH_IMAGE = "flickr.people.getPublicPhotos";
	
	/* http://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}_[mstzb].jpg */
	public final static String IMAGE_URL = "http://farm%s.staticflickr.com/%s/%s_%s_m.jpg";
}
