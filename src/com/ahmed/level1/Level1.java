package com.ahmed.level1;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Level1 extends Activity{
	
	LinearLayout mainLl = null, linearLayout = null;
	ArrayList<ImageView> imageViewArrayList = null;
	ArrayList<Integer> tempRandom = null, drawables = null;
	boolean click1 = true, click2 = true;
	String val1, val2;
	ArrayList<String> arrayList = null, tempString = null, tempTags = null;
	Handler handler = null;
	ArrayList<ImageView> imageViews = null;
	int pos1, pos2, count = 0;
	
	
	int arr[] = {
			
			R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,
			R.drawable.img8,R.drawable.img9,R.drawable.img10,R.drawable.img11,R.drawable.img12,/*R.drawable.img13,*/R.drawable.img14,
			R.drawable.img15,R.drawable.img16,R.drawable.img17,R.drawable.img18,R.drawable.img19,
			
			R.drawable.copy1,R.drawable.copy2,R.drawable.copy3,R.drawable.copy4,R.drawable.copy5,R.drawable.copy6,R.drawable.copy7,
			R.drawable.copy8,R.drawable.copy9,R.drawable.copy10,R.drawable.copy11,R.drawable.copy12,/*R.drawable.copy13,*/R.drawable.copy14,
			R.drawable.copy15,R.drawable.copy16,R.drawable.copy17,R.drawable.copy18,R.drawable.copy19
			
	};
	
	String strArr[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
			"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"
	};
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level1);
		
		playGame();
		
		//sleepFewSeconds (7000, imageViews);
		
		
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		//playGame();
		
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		playGame();
		
	}
	
	public void playGame (){
		Toast.makeText(getApplicationContext(), "Start Game", Toast.LENGTH_SHORT).show();
		imageViews = setBackground(6, 6);
		setImagesForIv(imageViews);
		clearImageViews(imageViews);
		setClickListener(imageViews);
	}
	
	private void sleepFewSeconds(final int seconds, final ArrayList<ImageView> imageViews) {
		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				handler.post(new Runnable() {
//					@Override
//					public void run() {
//						try {
//							Thread.sleep(seconds);
//						} catch (Exception e) {
//							// TODO: handle exception
//						}finally {
//							clearImageViews(imageViews);
//							setClickListener(imageViews);
//						}
//					}
//				});
//			}
//		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				
						try {
							Thread.sleep(seconds);
						} catch (Exception e) {
							// TODO: handle exception
						}finally {
							clearImageViews(imageViews);
							setClickListener(imageViews);
						}
			}
			
		}).start();
		
		//thread.start();
		
	}

	public ArrayList<ImageView> setBackground (int sizeOfImgViews, int sizeOfLayouts){
		mainLl = (LinearLayout) findViewById(R.id.mainLinearLayout);
		mainLl.removeAllViews();
		mainLl.setBackgroundColor(Color.CYAN);
        imageViewArrayList = new ArrayList<ImageView>();
        for (int i = 0; i < sizeOfLayouts; i++) {
            linearLayout = new LinearLayout(Level1.this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            //layoutParams.setMargins(1, 1, 1, 1);
            linearLayout.setLayoutParams(layoutParams);
            for (int j = 0; j < sizeOfImgViews; j++) {
                ImageView imageView = new ImageView(Level1.this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                		LinearLayout.LayoutParams.WRAP_CONTENT, 
                		LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(8, 8, 8, 8);
                imageView.setLayoutParams(params);
                imageView.setTag(String.valueOf(i)+String.valueOf(j));
                //imageView.setBackgroundColor(Color.MAGENTA);
                //imageView.setBackgroundResource(R.drawable.img1);
                imageViewArrayList.add(imageView);
                linearLayout.addView(imageView);
            }
            mainLl.addView(linearLayout);
        }
        return imageViewArrayList;
    }
	
	public ArrayList<String> getTagsFromIvs (ArrayList<ImageView> list) {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			arrayList.add((String)list.get(i).getTag());
		}
		
		return arrayList;
		
	}
	
	public boolean isTagExists (String tag) {
		tempTags = new ArrayList<String>();
		for (int i = 0; i < tempTags.size(); i++) {
			if (tempTags.get(i).equals(tag)) {
				return true;//exist
			} else {
				tempTags.add(tag);
				return false;
			}
		}
		
		return false;
	}
	
	public void setImagesForIv (ArrayList<ImageView> list) {
		
		tempRandom = new ArrayList<Integer>();
		drawables = new ArrayList<Integer>();
		Level1.this.arrayList = new ArrayList<String>();
		Level1.this.tempString = new ArrayList<String>();
		
		Random random = new Random();
		
		
		for (int i = 0; i < arr.length; i++) {
			drawables.add(arr[i]);
		}
		
		for (int i = 0; i < strArr.length; i++) {
			this.arrayList.add(strArr[i]);
		}
		
		
		for (int i = 0; i < list.size(); i++) {
			int r = random.nextInt(drawables.size());
			//list.get(i).setBackgroundResource(drawables.get(r));
			tempRandom.add(drawables.get(r));
			Level1.this.tempString.add(this.arrayList.get(r));
			drawables.remove(r);
			arrayList.remove(r);
			
			//list.get(i).setBackgroundResource(arr[i]);
			
			
			
		}
		
		
		
		
	}
	
	public void clearImageViews (ArrayList<ImageView> list) {
		
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setBackgroundResource(R.drawable.def2);
		}
		
	}
	
	public void setClickListener (final ArrayList<ImageView> arrayList) {
		
		for (int i = 0; i < arrayList.size(); i++) {
			
			arrayList.get(i).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					if (click1) {
						for (int j = 0; j < arrayList.size(); j++) {
							if (v.getTag().equals(arrayList.get(j).getTag())) {
								
								arrayList.get(j).setBackgroundResource(tempRandom.get(j));
								arrayList.get(j).setClickable(false);
								val1 = Level1.this.tempString.get(j);
								pos1 = j;
								break;
							}	
						}
						click1 = false;
						
					} else {
						
						if (click2) {
							
							click2 = false;
							for (int j = 0; j < arrayList.size(); j++) {
								
								if (v.getTag().equals(arrayList.get(j).getTag())) {
									
									arrayList.get(j).setBackgroundResource(tempRandom.get(j));
									//set image and border in xml file for image view 
									val2 = Level1.this.tempString.get(j);
									
									pos2 = j;
									
									if (val1.equals(val2)) {
										Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
										arrayList.get(pos1).setClickable(false);
										arrayList.get(pos2).setClickable(false);
										
										
										click1 = click2 = true;
										count += 2;
										if (count == 36) {
											//Toast.makeText(getApplicationContext(), "Win ", Toast.LENGTH_SHORT).show();
//											handler = new Handler();
//											Thread t = new Thread(new Runnable() {
//												@Override
//												public void run() {
//													for (int j = arrayList.size(); j > 0; j--) {
//														final int f = j;
//														handler.post(new Runnable() {
//															@Override
//															public void run() {
//																arrayList.get(f).setBackgroundResource(R.drawable.def2);
//																if (f == 0) {
																	Intent intent = new Intent(getApplicationContext(), com.ahmed.level2.Level2.class);
																	startActivity(intent);
																}
//															}
//														});
//														try {
//															Thread.sleep(200);
//															
//														} catch (InterruptedException e) {
//															e.printStackTrace();
//														}
//													}
//													
//												}
//											});
//											t.start();
//										}
									}
									else{
										arrayList.get(pos1).setBackgroundResource(R.drawable.def2);
										arrayList.get(pos2).setBackgroundResource(R.drawable.def2);
										arrayList.get(pos1).setClickable(true);
										arrayList.get(pos2).setClickable(true);
										click1 = click2 = true;
									}
									
								}
							}
							
							
							
						}
						
						
					}
					
					//*******************************************************************************
					//Check if the game finished
//					for (int j = 0; j < arrayList.size(); j++) {
//						if (arrayList.get(j).isClickable()) {
//							count++;
//						}
//					}
					
					
				}
			});
			
		}
		
		
		
		
	}
	
	
	
	
	
	
}
