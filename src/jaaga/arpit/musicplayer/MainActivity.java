package jaaga.arpit.musicplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener {

	ListView l;
	MediaPlayer[] media = new MediaPlayer[26]; 
	int[] med = new int[]{R.raw.offo,R.raw.chaandaniya,R.raw.iski_uski,R.raw.locha_e_ulfat}; 
    String[] songs = {"offo","chaandaniya","iski_uski","locha_e_ulfat"};
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<4;i++)
        {
        	media[i]=MediaPlayer.create(this, med[i]);
        }
        l = (ListView) findViewById(R.id.listView1);
        ArrayAdapter<String> adt=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,songs);
        l.setAdapter(adt);
        l.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onItemClick(AdapterView<?> adt, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		//TextView temp = (TextView) arg1;
	    if(arg2 == 0)
	    {
	    	Log.e("banana", "0");
	    	md(1);
	    	md(2);
	    	md(3);
	    	media[0].start();
	    	
	    }
	    else if(arg2 == 1)
	    {
	    	Log.e("banana", "1");
	    	md(0);
	    	md(2);
	    	md(3);
	    	media[1].start();
	    	
	    }
	    else if(arg2 == 2)
	    {
	    	Log.e("banana", "2");
	    	md(1);
	    	md(0);
	    	md(3);
	    	media[2].start();
	    	
	    }
	    else if(arg2 == 3)
	    {
	    	Log.e("banana", "3");
	    	md(1);
	    	md(2);
	    	md(0);
	    	media[3].start();
	    }		
	}
	
	public void md(int m){
		if(media[m].isPlaying())
    	{
			media[m].pause();
    		media[m].reset();
    	}
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
    
}
