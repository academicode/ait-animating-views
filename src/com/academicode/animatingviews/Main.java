package com.academicode.animatingviews;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * This class will demonstrate the differences between 'tween and frame animations.
 * 
 * @author AcademiCode
 */
public class Main extends Activity {

	// These buttons will be used to switch between animations for the purpose of the demo.
	private Button startFrameAnimation;
	private Button startTweenAnimation;
	
	// These buttons represent the respective image views that will be hosting the animations.
	private ImageView tweenAnimation;
	private ImageView frameAnimation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// Helper method that sets up the views.
		initializeViews();
		
		startFrameAnimation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// Helper method to ensure that the View we are animating can be seen.
				ensureVisibility(frameAnimation);
				
				// Sets the background resource of the blank image view for the frame animation to
				// the resource that represents the animation.
				frameAnimation.setBackgroundResource(R.drawable.loading_animation);
				
				// Extracts an AnimationDrawable from the image view.
				AnimationDrawable frameAnimationDrawable = (AnimationDrawable) frameAnimation.getBackground();
				
				// Starts the animation!
				frameAnimationDrawable.start();
			}
		});
		
		startTweenAnimation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// Helper method to ensure that the View we are animating can be seen.
				ensureVisibility(tweenAnimation);
				
				// Builds the rotate animation from the XML resource "r.anim.rotate".
				Animation rotate = AnimationUtils.loadAnimation(Main.this, R.anim.rotate);
				
				// Begin the rotate animation!
				tweenAnimation.startAnimation(rotate);
			}
		});
	}

	/**
	 * Helper method that initializes the views.  Much of the boilerplate code is 
	 * encapsulated in here.
	 */
	private void initializeViews() {
		
		this.startFrameAnimation = (Button) findViewById(R.id.startFrame);
		this.startTweenAnimation = (Button) findViewById(R.id.startTween);
		
		this.tweenAnimation = (ImageView) findViewById(R.id.tweenAnimation);
		this.frameAnimation = (ImageView) findViewById(R.id.frameAnimation);
	} 
	
	/**
	 * Since we're sharing the middle of the screen with 2 views, this method will make sure that 
	 * the one you want to use is visible whereas the other is hidden.
	 * 
	 * @param image The image who's visibility you want to showcase.
	 */
	private void ensureVisibility(ImageView image) {
		
		if(image == tweenAnimation){
			
			frameAnimation.setVisibility(View.GONE);
			tweenAnimation.setVisibility(View.VISIBLE);
		}
		else if(image == frameAnimation){
			
			tweenAnimation.setVisibility(View.GONE);
			frameAnimation.setVisibility(View.VISIBLE);
		}
	}
}
