package com.example.androiddemo;

import android.app.Application;

public class App extends Application {
	
	private final static String TAG = "App";
	
	public App() {
		Logger.setProject(Config.PROJECT_NAME, Config.DEBUD_MODE);
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		Logger.i(TAG, "onCreate");
	}
}
