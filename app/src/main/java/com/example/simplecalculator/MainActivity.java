package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mEditText_1;
    EditText mEditText_2;
    TextView result_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing the required variables.
        mEditText_1 = findViewById(R.id.input_1);
        mEditText_2 = findViewById(R.id.input_2);
        result_view = findViewById(R.id.result_view);

    }

    public void doOperation(View view) {

        // Getting the id of the button clicked.
        int viewId = view.getId();
        String input_1 = mEditText_1.getText().toString();
        String input_2 = mEditText_2.getText().toString();


        // Check weather the input field is empty or not before taking the input
        if (TextUtils.isEmpty(input_1) || !isNum(input_1)) {
            mEditText_1.setError("Invalid Input");

        } else {
            if (TextUtils.isEmpty(input_2) || !isNum(input_2)) {
                mEditText_2.setError("Invalid Input");

            } else {
                // Getting the input from input fields.
                float num1 = Float.parseFloat(input_1);
                float num2 = Float.parseFloat(input_2);

                String result = String.valueOf(calculate(viewId, num1, num2));

                // Setting the result to result TextView.
                result_view.setText(result);
            }
        }
    }


    public float calculate(int viewId, float num1, float num2) {
        // Doing operation on the basis of button id.
        switch (viewId) {
            case R.id.add_button:
                return num1 + num2;

            case R.id.sub_button:
                return num1 - num2;

            case R.id.mul_button:
                return num1 * num2;

            case R.id.div_button:
                return num1 / num2;
            default:
                break;
        }
        return Float.parseFloat("");
    }

    public void clearFields(View view) {
        mEditText_2.getText().clear();
        mEditText_1.getText().clear();
        result_view.setText("");
    }

    public boolean isNum(String string){
        if(string.trim().equals(".") ||  string.trim().equals("-")) {
            return false;
        } else {
            return true;
        }
    }
}
