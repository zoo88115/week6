package zooo88115.computer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View v){
        EditText n1 =(EditText)findViewById(R.id.number1);
        EditText n2 =(EditText)findViewById(R.id.number2);
        TextView textview1= (TextView)findViewById(R.id.answer);
        if(isValidNumber(n1.getText().toString())==true && isValidNumber(n2.getText().toString())==true) {
            double number3;
            if (v.getId() == R.id.add) {
                number3=Double.parseDouble(n1.getText().toString())+Double.parseDouble(n2.getText().toString());
                textview1.setText("答案 : "+String.format("%.4f",number3));
            } else if (v.getId() == R.id.cut) {
                number3=Double.parseDouble(n1.getText().toString())-Double.parseDouble(n2.getText().toString());
                textview1.setText("答案 : "+String.format("%.4f",number3));
            } else if (v.getId() == R.id.mul) {
                number3=Double.parseDouble(n1.getText().toString())*Double.parseDouble(n2.getText().toString());
                textview1.setText("答案 : "+String.format("%.4f",number3));
            } else if (v.getId() == R.id.div) {
                if(Double.parseDouble(n2.getText().toString())!=0) {
                    number3 = Double.parseDouble(n1.getText().toString()) / Double.parseDouble(n2.getText().toString());
                    textview1.setText("答案 : "+String.format("%.4f",number3));
                }
                else{
                    textview1.setText("答案 : 輸入錯誤!!分母不能為0");
                }
            }
        }
        else{
            textview1.setText("答案 : 數字輸入錯誤!!");
        }
        if (v.getId() == R.id.clear) {
            n1.setText("");
            n2.setText("");
        }
    }

    public boolean isValidNumber(String str){
        String Number="^[+-]?\\d+(\\.)?\\d*$";
        Pattern p=Pattern.compile(Number);
        Matcher m=p.matcher(str);
        return m.matches();
    }

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
}
