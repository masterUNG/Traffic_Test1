package appewtc.masterung.traffic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create ListTitle
        createListTitle();

    }   // onCreate

    public void clickTest(View view) {
        startActivity(new Intent(this, TestActivity.class));
    }

    private void createListTitle() {

        MyData objMyData = new MyData();
        int[] intIcon = objMyData.addressIcon();

        String[] strTitle = getResources().getStringArray(R.array.title);

        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this, strTitle, intIcon);

        ListView titleListView = (ListView) findViewById(R.id.listView);
        titleListView.setAdapter(objMyAdapter);


    }   //createListTitle


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}   // Main Class
