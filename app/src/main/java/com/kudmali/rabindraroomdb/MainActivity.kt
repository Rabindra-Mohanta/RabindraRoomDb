package com.kudmali.rabindraroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var editText:EditText;
    lateinit var button:Button;
    lateinit var myDatabase: MyDatabase;
    lateinit var textView: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText=findViewById(R.id.edtText);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        myDatabase = MyDatabase.getDatabase(this);
        button.setOnClickListener(View.OnClickListener {

            GlobalScope.launch {
                myDatabase.getDao().insetData(MyModel(0,editText.text.toString(), Date(),0))
            }

        })

        myDatabase.getDao().getAllData().observe(this, Observer {

           // textView.setText("");
            for(i in 0..(it.size-1))
            {
                textView.setText(""+it.get(i).name+"\n"+it.get(i).createdDate);
            }
        })

    }
}