package com.esiea.appli;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

  /*----------------ne rien ecrire avant--------------*/
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  
 

  ListView ll = (ListView)findViewById(R.id.lv_examples);
  ListView ll2 = (ListView)findViewById(R.id.lv_examples2);
  
  final String[] lls = {"test", "tetes", "ter"};
  
  ll.setAdapter(new BaseAdapter() {

    @Override
    public int getCount() {
      // TODO Auto-generated method stub
      return lls.length;
    }

    @Override
    public String getItem(int position) {
      // TODO Auto-generated method stub
      return lls[position];
    }

    @Override
    public long getItemId(int position) {
      // TODO Auto-generated method stub
      return position;
    }

    /*--------------Ecrire une view--------------*/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      // TODO Auto-generated method stub
      String ms = getItem(position);
      
      if(convertView == null) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        
      }
   /*   TextView tv = new TextView(getApplicationContext()); créer un textview
      tv.setText(ms);*/
      
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent);
    TextView tv = (TextView)v.findViewById(R.id.tv);
    tv.setText(ms);
      return tv;  
      }
    });
  /*-------------------------------------------*/
  
  /*----------------------et ici--------------------------*/
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
      //Toast.makeText(getApplicationContext(), "Toast", Toast.LENGTH_LONG).show(); //créer un toast qui apparaît quand on clique sur setting
     // DialogFragment df = new DialogFragment();
     // df.show(getFragmentManager(), "dialog");
      return true;
    }
     
    
    return super.onOptionsItemSelected(item);
  
}
  /*Classe qui créer un dialogue*/
  
  public static class MyDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState) {
      AlertDialog.Builder builder  = new AlertDialog.Builder(getActivity());
      builder.setMessage("salut");
      return builder.create();
    }
}
  /*--------------------------*/
}
