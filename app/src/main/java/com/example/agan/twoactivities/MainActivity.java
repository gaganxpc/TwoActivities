package com.example.agan.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private EditText mMessageEditText;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;
    public static final String EXTRA_MESSAGE = "com.example.agan.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = (EditText) findViewById(R.id.Text_main);

        mReplyHeadTextView = (TextView) findViewById(R.id.text_header_reply);
        mReplyTextView = (TextView) findViewById(R.id.text_message_reply);

        Log.d(LOG_TAG, "------");
        Log.d(LOG_TAG, "onCreate");
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button Clicked");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    public void onRestart(){
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "onResume()");
    }

    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }


}
