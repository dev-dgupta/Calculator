package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean subtraction, addition, division, remainder, multiplication, isFloatNum;
    float value1, value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeValues();
    }

    public void clr(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        TextView textToShow = (TextView) findViewById(R.id.textToShow);
        number.setText(null);
        textToShow.setText(null);
        initializeValues();
    }

    public void subtract(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        TextView textToShow = (TextView) findViewById(R.id.textToShow);
        String numEntered = number.getText().toString();
        if (value1 == 0.0f) {
            value1 = Float.parseFloat(numEntered);
            textToShow.setText(numEntered + " - ");
        } else {
            value2 = Float.parseFloat(numEntered);
            float ans = getAns();
            setAns(textToShow, ans, " - ");
            reinitializeValues(ans);
        }
        subtraction = true;
        number.setText(null);
    }

    public void divide(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        TextView textToShow = (TextView) findViewById(R.id.textToShow);
        String numEntered = number.getText().toString();
        if (value1 == 0.0f) {
            value1 = Float.parseFloat(numEntered);
            textToShow.setText(numEntered + " / ");
        } else {
            value2 = Float.parseFloat(numEntered);
            float ans = getAns();
            setAns(textToShow, ans, " / ");
            reinitializeValues(ans);
        }
        division = true;
        number.setText(null);
    }

    public void multiply(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        TextView textToShow = (TextView) findViewById(R.id.textToShow);
        String numEntered = number.getText().toString();
        if (value1 == 0.0f) {
            value1 = Float.parseFloat(numEntered);
            textToShow.setText(numEntered + " * ");
        } else {
            value2 = Float.parseFloat(numEntered);
            float ans = getAns();
            setAns(textToShow, ans, " * ");
            reinitializeValues(ans);
        }
        multiplication = true;
        number.setText(null);
    }

    public void add(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        TextView textToShow = (TextView) findViewById(R.id.textToShow);
        String numEntered = number.getText().toString();
        if (value1 == 0.0f) {
            value1 = Float.parseFloat(numEntered);
            textToShow.setText(numEntered + " + ");
        } else {
            value2 = Float.parseFloat(numEntered);
            float ans = getAns();
            setAns(textToShow, ans, " + ");
            reinitializeValues(ans);
        }
        addition = true;
        number.setText(null);
    }

    public void remainder(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        TextView textToShow = (TextView) findViewById(R.id.textToShow);
        String numEntered = number.getText().toString();
        if (value1 == 0.0f) {
            value1 = Float.parseFloat(numEntered);
            textToShow.setText(numEntered + " % ");
        } else {
            value2 = Float.parseFloat(numEntered);
            float ans = getAns();
            setAns(textToShow, ans, " % ");
            reinitializeValues(ans);
        }
        remainder = true;
        number.setText(null);
    }

    public void backspace(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        String currenttxt = number.getText().toString();
        if (!currenttxt.isEmpty()) {
            char[] strArr = currenttxt.toCharArray();
            if (strArr[strArr.length - 1] == '+' ||
                    strArr[strArr.length - 1] == '-' ||
                    strArr[strArr.length - 1] == '*' ||
                    strArr[strArr.length - 1] == '/' ||
                    strArr[strArr.length - 1] == '%') {
                initializeValues();
            } else if (strArr[strArr.length - 1] == '.') {
                isFloatNum = false;
            }
            number.setText(currenttxt.substring(0, currenttxt.length() - 1));
        }
    }

    public void equals(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        TextView textToShow = (TextView) findViewById(R.id.textToShow);
        String numEntered = number.getText().toString();
        if (!numEntered.isEmpty() && value1 != 0.0f) {
            value2 = Float.parseFloat(numEntered);
            float ans = getAns();
            setAns(number, ans);
            textToShow.setText(null);
            initializeValues();
        } else {
            Toast.makeText(this, "Enter atleast two numbers for the result", Toast.LENGTH_SHORT);
        }
    }

    private float getAns() {
        float ans = 0.0f;
        if (subtraction) {
            ans = value1 - value2;
        } else if (addition) {
            ans = value1 + value2;
        } else if (division) {
            ans = value1 / value2;
        } else if (remainder) {
            ans = value1 % value2;
        } else if (multiplication) {
            ans = value1 * value2;
        }
        return ans;
    }

    private void setAns(TextView textToShow, float ans, String bodmasChar) {
        if (isFloatNum) {
            textToShow.setText(ans + bodmasChar);
        } else {
            textToShow.setText(((int) ans) + bodmasChar);
        }
    }

    private void setAns(EditText textToShow, float ans) {
        if (isFloatNum) {
            textToShow.setText(String.valueOf(ans));
        } else {
            textToShow.setText(String.valueOf((int) ans));
        }
    }

    private void initializeValues() {
        isFloatNum = subtraction = addition = division = multiplication = remainder = false;
        value1 = value2 = 0.0f;
    }

    private void reinitializeValues(float ans) {
        subtraction = addition = division = multiplication = remainder = false;
        value2 = 0.0f;
        value1 = ans;
    }

    public void decimal(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        number.setText(number.getText().toString() + ".");
        isFloatNum = true;
    }

    public void btn0(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        number.setText(number.getText().toString() + "0");
    }

    public void btn1(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        number.setText(number.getText().toString() + "1");
    }

    public void btn2(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        number.setText(number.getText().toString() + "2");
    }

    public void btn3(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        number.setText(number.getText().toString() + "3");
    }

    public void btn4(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        number.setText(number.getText().toString() + "4");
    }

    public void btn5(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        number.setText(number.getText().toString() + "5");
    }

    public void btn6(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        number.setText(number.getText().toString() + "6");
    }

    public void btn7(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        number.setText(number.getText().toString() + "7");
    }

    public void btn8(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        number.setText(number.getText().toString() + "8");
    }

    public void btn9(View view) {
        EditText number = (EditText) findViewById(R.id.digitEditText);
        number.setText(number.getText().toString() + "9");
    }
}