package com.projects.karan.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.projects.karan.listviewdemo.model.Enquiry;

import java.util.ArrayList;

public class EnquiryActivity extends AppCompatActivity {

    // Spinner Declaration
    private Spinner spinnerCourses;
    private EditText editTextName, editTextContact, editTextDescription;
    private Button buttonSubmit;
    private ListView listViewEnquiry;


    // Data source
    private String[] courseNames = {"Android", "Java", ".NET", "C#"};
    private ArrayList<Enquiry> enquiryArrayList = new ArrayList<>();

    private ArrayAdapter<String> arrayAdapterCourses;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);

        setTitle("Enquiry");

        spinnerCourses = (Spinner) findViewById(R.id.spinnerCourses);
        editTextDescription = (EditText) findViewById(R.id.editTextDescription);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextContact = (EditText) findViewById(R.id.editTextContact);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        listViewEnquiry = (ListView) findViewById(R.id.listViewEnquiry);

        arrayAdapterCourses = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, courseNames);

        myAdapter = new MyAdapter();

        listViewEnquiry.setAdapter(myAdapter);

        spinnerCourses.setAdapter(arrayAdapterCourses);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                String courseName = courseNames[spinnerCourses.getSelectedItemPosition()];
                String contact = editTextContact.getText().toString();
                String description = editTextDescription.getText().toString();

                Enquiry enquiry = new Enquiry(contact, courseName, description, name);
                enquiryArrayList.add(enquiry);
                myAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_enquiry, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled = false;
        if(item.getItemId() == R.id.action_delete){
            handled = true;
            enquiryArrayList.remove(enquiryArrayList.size()-1);
            myAdapter.notifyDataSetChanged();
            Enquiry.setEnquiryCount(Enquiry.getEnquiryCount()-1);
        }
        return handled;
    }

    class MyAdapter extends BaseAdapter{

        // Return size of data source
        @Override
        public int getCount() {
            return enquiryArrayList.size();
        }

        // Return the item in data source @ position i
        @Override
        public Object getItem(int i) {
            return enquiryArrayList.get(i);
        }

        // Return the position of item
        @Override
        public long getItemId(int i) {
            return i;
        }



        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            // Getting data from source
            Enquiry enquiry = enquiryArrayList.get(i);

            // Get the xml
            View v = getLayoutInflater().inflate(R.layout.enquiry_row, null);

            // Extract views from xml
            TextView textViewId = (TextView) v.findViewById(R.id.textViewId);
            TextView textViewName = (TextView) v.findViewById(R.id.textViewName);
            TextView textViewContact = (TextView) v.findViewById(R.id.textViewContact);
            TextView textViewCourse = (TextView) v.findViewById(R.id.textViewCourse);

            // Binding data from source to views in row.xml
            textViewId.setText(""+enquiry.getEnquiryId());
            textViewName.setText(enquiry.getEnquirerName());
            textViewCourse.setText(enquiry.getCourseName());
            textViewContact.setText(enquiry.getContactNumber());

            // Return the view object
            return v;
        }
    }

}
