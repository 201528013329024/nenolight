package com.example.nenolight;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.provider.CalendarContract.Colors;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity implements Runnable {
	
	private int[] colors = new int[]{0xFFFF0000,0xFFFF0000,0xFF02FF00,0xFF0000FF,0xFFFF00FF,0xFF00FFFF};
	private int[] nextColorPointers = new int[]{1,2,3,4,0};
	private View[] views ;
	private int currentColorPointer = 0;
	private Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		views = new View[]{
			findViewById(R.id.textView5),
			findViewById(R.id.textView4),
			findViewById(R.id.textView3),
			findViewById(R.id.textView2),
			findViewById(R.id.textView1)
		};
		
		handler = new Handler();
		handler.postDelayed(this, 200);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int nextColorPointer = currentColorPointer;
		
		for (int i = views.length-1; i >= 0; i--) {
			views[i].setBackgroundColor(colors[nextColorPointers[nextColorPointer]]);
			nextColorPointer = nextColorPointers[nextColorPointer];
		}
		
		currentColorPointer++;
		
		if (currentColorPointer == 5) {
			currentColorPointer = 0;
		}
		
		handler.postDelayed(this, 200);
	}
}
