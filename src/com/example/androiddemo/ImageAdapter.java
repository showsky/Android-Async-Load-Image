package com.example.androiddemo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class ImageAdapter extends BaseAdapter {
	
	private final static String TAG = "ImageAdapter";
	private JSONArray jsonArray = null;
	private ImageLoader imageLoader = null;
	private LayoutInflater inflater = null;
	
	static class ViewHolder {
		
		public NetworkImageView imageView = null;
		public TextView imageTitle = null;
	}
	
	public ImageAdapter(Context context, ImageLoader imageLoader, JSONArray jsonArray) {
		inflater = LayoutInflater.from(context);
		this.jsonArray = jsonArray;
		this.imageLoader = imageLoader;
	}

	@Override
	public int getCount() {
		return jsonArray.length();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.row, parent, false);
			holder = new ViewHolder();
			holder.imageView = (NetworkImageView) convertView.findViewById(R.id.row_imageview);
			holder.imageTitle = (TextView) convertView.findViewById(R.id.row_title);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		try {
			JSONObject jsonPhoto = jsonArray.getJSONObject(position);
			String url = String.format(
				Config.IMAGE_URL,
				jsonPhoto.getString("farm"),
				jsonPhoto.getString("server"),
				jsonPhoto.getString("id"),
				jsonPhoto.getString("secret")
			);
			Logger.d(TAG, "Url: ", url);
			holder.imageView.setImageUrl(url, imageLoader);
			holder.imageTitle.setText(jsonPhoto.getString("title"));
		} catch (JSONException e) {}
		
		return convertView;
	}
}
