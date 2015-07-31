package appewtc.masterung.traffic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    //Explicit
    private String[] questionStrings;
    private TextView questionTextView;
    private ImageView trafficImageView;
    private int imageAnInt[], radioAnInt, indexInts;
    private RadioGroup choiceRadioGroup;
    private RadioButton choice1RadioButton, choice2RadioButton, choice3RadioButton, choice4RadioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //Bind Widget
        bindWidget();

        //Setup Text ดึงค่า String ของคำถาม
        setupText();

        //Setup Image ดึง Integer ตำแหน่งของภาพ
        setupImage();

        //Setup RadioAnInt
        setupRadio();

    }   // onCreate

    private void setupRadio() {
        choiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton:
                        radioAnInt = 1;
                        break;
                    case R.id.radioButton2:
                        radioAnInt = 2;
                        break;
                    case R.id.radioButton3:
                        radioAnInt = 3;
                        break;
                    case R.id.radioButton4:
                        radioAnInt = 4;
                        break;
                    default:
                        radioAnInt = 0;
                        break;
                }
            }
        });
    }

    public void clickTest(View view) {

        if (radioAnInt == 0) {
            Toast.makeText(TestActivity.this, "โปรตอบคำถาม", Toast.LENGTH_SHORT).show();
        } else {
            if (indexInts == 9) {
                startActivity(new Intent(this, ShowScoreActivity.class));
                finish();
            } else {

                //Increase indexAnInt
                indexInts += 1;

                //Change View
                changeView();
            }
        }

    } // clickTest

    private void changeView() {

        //Change Question
        questionTextView.setText(questionStrings[indexInts]);

        //Change Image
        trafficImageView.setImageResource(imageAnInt[indexInts]);

        //Change Choice
        changeChoice();

    }   // changeView

    private void changeChoice() {
        MyData objMyData = new MyData();
        int[] intTimes = objMyData.choiceTimes();

        String[] strChoice = getResources().getStringArray(intTimes[indexInts]);
        choice1RadioButton.setText(strChoice[0]);
        choice2RadioButton.setText(strChoice[1]);
        choice3RadioButton.setText(strChoice[2]);
        choice4RadioButton.setText(strChoice[3]);

    }

    private void setupImage() {
        MyData objMyData = new MyData();
        imageAnInt = objMyData.addressIcon();
    }

    private void bindWidget() {
        questionTextView = (TextView) findViewById(R.id.txtQuestion);
        trafficImageView = (ImageView) findViewById(R.id.imvShowTraffic);
        choiceRadioGroup = (RadioGroup) findViewById(R.id.ragChoice);
        choice1RadioButton = (RadioButton) findViewById(R.id.radioButton);
        choice2RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        choice3RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        choice4RadioButton = (RadioButton) findViewById(R.id.radioButton4);
    }   // bindWidget

    @Override
    protected void onStart() {
        super.onStart();
        //แสดงคำถามแรก
        questionTextView.setText(questionStrings[0]);

        //แสดงภาพแรก
        trafficImageView.setImageResource(imageAnInt[0]);

        //แสดง Choice ต่างๆ
        String[] strTime1 = getResources().getStringArray(R.array.times1);
        choice1RadioButton.setText(strTime1[0]);
        choice2RadioButton.setText(strTime1[1]);
        choice3RadioButton.setText(strTime1[2]);
        choice4RadioButton.setText(strTime1[3]);

    }

    private void setupText() {
        questionStrings = getResources().getStringArray(R.array.question);
    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
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
