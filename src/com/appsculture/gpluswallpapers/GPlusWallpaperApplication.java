package com.appsculture.gpluswallpapers;

import android.app.Application;

public class GPlusWallpaperApplication extends Application {

	@Override
	public void onCreate(){
		super.onCreate();
		Constants.init(this);
	}
}
