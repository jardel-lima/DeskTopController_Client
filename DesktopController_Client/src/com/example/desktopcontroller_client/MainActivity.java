package com.example.desktopcontroller_client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony.Mms.Part;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText txtHost, txtPort;
	private Button btnConnect;
	private Pattern hostPattern;
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
				int port = Integer.parseInt(txtPort.getText().toString());
				
				hostPattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
				Matcher match = hostPattern.matcher(host);
				
				if(match.matches() && port > 0){
					Intent intent = new Intent(getApplicationContext(), Client.class);
					intent.putExtra("host",host);
					intent.putExtra("port",port);
					startActivity(intent);
				}else{
					Toast.makeText(getApplicationContext(),"Invalid host address or port number", Toast.LENGTH_LONG).show();
				}
				
			}
		});
	}

}
