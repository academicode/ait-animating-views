package com.academicode.animatingviews;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Main extends ActionBarActivity {

	private Button startFrameAnimation;
	private Button startTweenAnimation;
	
	private ImageView tweenAnimation;
	private ImageView frameAnimation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		initializeViews();
		
		startFrameAnimation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// TODO: Implement frame animation here.
			}
		});
		
		startTweenAnimation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// TODO: Implement 'tween animation here.
			}
		});
	}

	private void initializeViews() {
		
		this.startFrameAnimation = (Button) findViewById(R.id.startFrame);
		this.startTweenAnimation = (Button) findViewById(R.id.startTween);
		
		this.tweenAnimation = (ImageView) findViewById(R.id.tweenAnimation);
		this.frameAnimation = (ImageView) findViewById(R.id.frameAnimation);
	} 
}
