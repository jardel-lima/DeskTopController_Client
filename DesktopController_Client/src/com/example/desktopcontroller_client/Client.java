package com.example.desktopcontroller_client;

import java.net.Socket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Client extends Activity {
	private String hostAddress;
	private int port;
	Socket client;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.client_layout);
		
		try{
			
			Intent data = getIntent();
			hostAddress = data.getStringExtra("host");
			port = data.getIntExtra("port", 0 );
			
			client = new Socket(hostAddress,port);
			String msg = "Connected to: "+client.getInetAddress().getHostAddress();
			Toast.makeText(this, msg ,Toast.LENGTH_LONG).show();
			client.close();
			
		}catch(Exception ex){
			Toast.makeText(this, "Error: "+ex.getMessage(),Toast.LENGTH_LONG).show();
		}
		
	}

}
