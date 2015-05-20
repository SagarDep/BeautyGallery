package com.xiaozhi.beautygallery.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.xiaozhi.beautygallery.R;
import com.xiaozhi.beautygallery.util.ImageLoaderUtil;

public class BeautyFragment extends Fragment {

	public static final String URL = "url";

	private String url;

	private ImageView mBeautyImg;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_beauty, container, false);
		mBeautyImg = (ImageView) v.findViewById(R.id.beautyImg);
		ImageAware imageAware = new ImageViewAware(mBeautyImg, false);
		ImageLoaderUtil.displayImage(url, imageAware,
				ImageLoaderUtil.getDefaultOptions());
		return v;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getArguments();
		if (bundle != null)
			url = bundle.getString(URL);
	}

	public static BeautyFragment newInstance(String url) {
		Bundle bundle = new Bundle();
		bundle.putString(URL, url);
		BeautyFragment beautyFragment = new BeautyFragment();
		beautyFragment.setArguments(bundle);
		return beautyFragment;
	}
}