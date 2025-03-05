package edu.neu.mad.eventhandling2;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
   implements View.OnClickListener {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState); // remember to call the super.
            setContentView(R.layout.activity_main); // inflate the layout

            TextView myTextView = findViewById(R.id.helloTextView); // get a reference to the hello textView
            myTextView.setOnClickListener(new View.OnClickListener() { // set the onClick listener to be this anonymous method
                @Override
                public void onClick(View view) { // override the onClick
                    // Don't next to check what was clicked on.  This was registered as the onClick listener for the hello textView.
                    Toast.makeText(getApplicationContext(),"Hello!",Toast.LENGTH_SHORT).show();
                }
            });
        }


        @Override
        public void onClick(View view)
        {
            int theId = view.getId(); // get the Id of the view that was clicked
            if (theId == R.id.bingoButton) { // if the bingoButton was clicked, show the Toast.
                Toast.makeText(getApplicationContext(),"Bingo!!!",Toast.LENGTH_SHORT).show();
            }
            // build an if-else chain to test other Ids to be handled.
            // Don't use switch because resource Ids are not final.  They used to be, so you may find sample code online that uses switch.

        }

    }
