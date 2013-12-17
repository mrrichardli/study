package io.github.tianshanxuester.hellnetworksynchttp;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import java.nio.charset.Charset;

public class HelloNetwork extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new Thread(runnable).start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	// Reads an InputStream and converts it to a String.
	public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
	    final Reader reader = new InputStreamReader(stream, "gbk");        
	    char[] buffer = new char[len];
	    int count = reader.read(buffer, 0, len);
//	    int count = reader.read(buffer);
	    if (count < 0)
	    	return null;
	    return new String(buffer, 0, len);
	}
	private Runnable runnable = new Runnable(){

		@SuppressLint("NewApi")
		@Override
		public void run() {
		    URL url;
			try {
				Log.i("HelloNetwork", "start to connect");
				url = new URL("http://www.tom.com/");
			    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			    conn.setReadTimeout(10000 /* milliseconds */);
			    conn.setConnectTimeout(15000 /* milliseconds */);
			    conn.setRequestMethod("GET");
//			    conn.setDoInput(true);
			    // Starts the query
			    conn.connect();
			    InputStream in = conn.getInputStream();
			    if (in != null) {
			    	String str = null;
			    	Reader reader = new InputStreamReader(in, "gbk");
			    	int len = 1024 * 100;
		    	    byte[] buffer = new byte[len];
			    	do {
			    		int count = in.read(buffer);
//			    	    int count = reader.read(buffer, 0, len);
//			    	    int count = reader.read(buffer);
			    	    if (count < 0) {
			    	    	break;
			    	    }
			    		Log.i("HelloNetwork", "result is " + new String(buffer, 0, count, "gbk") );
			    	}while(true);
			    }
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}};

}
