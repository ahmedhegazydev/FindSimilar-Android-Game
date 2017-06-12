package com.ahmed.level5;

import java.util.ArrayList;
import java.util.Random;

import com.ahmed.level1.R;

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

public class Level5 extends Activity{
	
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
			//*****************************************Original*********************************************************************
			R.drawable.image0,R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,
			R.drawable.image6,
			R.drawable.image7,R.drawable.image8,R.drawable.image9,R.drawable.image10,R.drawable.image11,R.drawable.image12,
			R.drawable.image13,R.drawable.image14,R.drawable.image15,R.drawable.image16,R.drawable.image17,
			//*******************************************Copy*******************************************************************
			R.drawable.imagecopy0,R.drawable.imagecopy1,R.drawable.imagecopy2,R.drawable.imagecopy3,R.drawable.imagecopy4,
			R.drawable.imagecopy5,R.drawable.imagecopy6,R.drawable.imagecopy7,R.drawable.imagecopy8,R.drawable.imagecopy9,
			R.drawable.imagecopy10,R.drawable.imagecopy11,R.drawable.imagecopy12,R.drawable.imagecopy13,R.drawable.imagecopy14,
			R.drawable.imagecopy15,R.drawable.imagecopy16,R.drawable.imagecopy17
			
	};
	
	String strArr[] = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17",
			"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"
	};
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level5);
		
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
		
		//playGame();
		
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
            linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            //layoutParams.setMargins(1, 1, 1, 1);
            linearLayout.setLayoutParams(layoutParams);
            for (int j = 0; j < sizeOfImgViews; j++) {
                ImageView imageView = new ImageView(this);
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
		this.arrayList = new ArrayList<String>();
		this.tempString = new ArrayList<String>();
		
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
			this.tempString.add(this.arrayList.get(r));
			drawables.remove(r);
			arrayList.remove(r);
			
			//list.get(i).setBackgroundResource(arr[i]);
			
			
			
		}
		
		
		
		
	}
	
	public void clearImageViews (ArrayList<ImageView> list) {
		
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setBackgroundResource(R.drawable.deflevel5);
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
								val1 = Level5.this.tempString.get(j);
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
									val2 = Level5.this.tempString.get(j);
									
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
																	Intent intent = new Intent(getApplicationContext(), com.ahmed.level6.Level6.class);
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
										arrayList.get(pos1).setBackgroundResource(R.drawable.deflevel5);
										arrayList.get(pos2).setBackgroundResource(R.drawable.deflevel5);
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
