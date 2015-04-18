package com.example.desktopcontroller_client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText txtHost, txtPort;
	private Button btnConnect;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txtHost = (EditText) findViewById(R.id.txtHost);
		txtPort = (EditText) findViewById(R.id.txtPort);
		btnConnect = (Button) findViewById(R.id.btnConnect);
		
		btnConnect.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String host = txtHost.getText().toString();
				String port = txtPort.getText().toString();
				
				Intent intent = new Intent(getApplicationContext(), Client.class);
				intent.putExtra("host",host);
				intent.putExtra("",host);
				startActivity(intent);
			}
		});
	}

}
