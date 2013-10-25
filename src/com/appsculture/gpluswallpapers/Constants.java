package com.appsculture.gpluswallpapers;

import android.content.Context;
import com.appsculture.utilities.CommonUtils;
import com.appsculture.utilities.RestUtils;

public class Constants {
	
	//Api related items
	public static String API_URL = "https://www.googleapis.com/plus/v1/people/108972862430615180924/activities/public?fields=updated,nextPageToken,title,items(object(actor(displayName,url),attachments(url,fullImage,objectType,displayName)))&key="+Key.PUBLIC_KEY;
	//Member functions
	private static boolean debugging = true;
	
	public static void init(Context context){
		CommonUtils.setDebugging(debugging);
		RestUtils.setRequestQueue(context);
	}

}
