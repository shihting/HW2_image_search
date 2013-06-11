package com.codepath.gridimagesearch;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;

import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class ImageSearchSetting extends Activity implements OnItemSelectedListener{
	Intent intent;
	Bundle bundle;
	
	String imgsz="small";
	String imgtype="red";
	String imgcolor="faces";
	String as_sitesearch="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_search_setting);
		
		intent = this.getIntent();
		bundle = intent.getExtras();
		
		
		Spinner spImgSize = (Spinner) findViewById(R.id.spImgSize);
		
		Spinner spColorFilter = (Spinner) findViewById(R.id.spColorFilter);
	
		Spinner spImgType = (Spinner) findViewById(R.id.spImgType);
	
	  
		
		ArrayAdapter<CharSequence> spImgSizeAdapter = ArrayAdapter.createFromResource(this, R.array.image_size_array, android.R.layout.simple_spinner_item);
		spImgSize.setAdapter(spImgSizeAdapter);
		
		
		ArrayAdapter<CharSequence> spColorFilterAdapter = ArrayAdapter.createFromResource(this, R.array.color_filter_array, android.R.layout.simple_spinner_item);
		spColorFilter.setAdapter(spColorFilterAdapter);
		
		ArrayAdapter<CharSequence> spImgTypeAdapter = ArrayAdapter.createFromResource(this, R.array.image_type_array, android.R.layout.simple_spinner_item);
		spImgType.setAdapter(spImgTypeAdapter);
		
	
		spImgSizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spImgSize.setOnItemSelectedListener((OnItemSelectedListener) this);
		
		
        spImgTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spImgType.setOnItemSelectedListener((OnItemSelectedListener) this);
		
        spColorFilterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spColorFilter.setOnItemSelectedListener((OnItemSelectedListener) this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image_display, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View selectView, int pos,
			long row) {
		String value =  parent.getItemAtPosition(pos).toString();
		  Log.d("DEBUG", "value" + value);
		switch (parent.getId()) {
		   case R.id.spColorFilter:
			   imgcolor = value;
			   break;
		   case R.id.spImgSize:
			   imgsz = value;
			   break;
		   case R.id.spImgType:
			   imgtype = value;
			   break;
		
		}
		
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void OnSettingsave(View V) {
		
		
        EditText etSiteFilter =  (EditText)findViewById(R.id.etSiteFilter);
        
        bundle.putString("imgsz", imgsz);
        bundle.putString("imgtype", imgtype);
        bundle.putString("imgcolor",imgcolor);
        
        
        bundle.putString("as_sitesearch", etSiteFilter.getText().toString());
        
     
        
        intent.putExtras(bundle);
    
        ImageSearchSetting.this.setResult(RESULT_OK, intent);
   
        ImageSearchSetting.this.finish();
	}

}
