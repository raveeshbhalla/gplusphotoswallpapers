package com.appsculture.gpluswallpapers;

import org.json.JSONObject;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.JsonObjectRequest;
import com.appsculture.utilities.RestUtils;
import com.appsculture.utilities.CommonUtils;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (RestUtils.isNetworkAvailable(this)) {
			JsonObjectRequest request = new JsonObjectRequest(Method.GET,
					Constants.API_URL, null, successfulRequestListener(),
					failedRequestListener());
			RestUtils.getRequestQueue().add(request);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private Response.Listener<JSONObject> successfulRequestListener() {
		return new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				TextView text = (TextView) findViewById(R.id.helloWorldTextView);
				text.setText(response.toString());
				CommonUtils.Log(TAG, response.toString(), false);
			}
		};
	}

	private Response.ErrorListener failedRequestListener() {
		return new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				error.printStackTrace();
			}
		};
	}

}
