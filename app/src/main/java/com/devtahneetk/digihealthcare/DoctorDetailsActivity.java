package com.devtahneetk.digihealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 ={
            {"Doctor Name : Mehzabi Naaz","Hospital Address : Jharkhand", "Exp : 5yrs", "Mobile No:9845762145","900"},
            {"Doctor Name : Ashok Pande","Hospital Address : Pune", "Exp : 15yrs", "Mobile No:9845762145","900"},
            {"Doctor Name : Anwar Ekram","Hospital Address : Delhi", "Exp : 8yrs", "Mobile No:9845762145","600"},
            {"Doctor Name : prasad Pawar","Hospital Address : Ranchi", "Exp : 6yrs", "Mobile No:9845762145","700"},
            {"Doctor Name : Ajit Saste","Hospital Address : Hazaribagh", "Exp : 2yrs", "Mobile No:9845762145","400"},

    };
    private String[][] doctor_details2 ={
            {"Doctor Name : Bal Krishna Goyal","Hospital Address : Bihar", "Exp : 5yrs", "Mobile No:9845762145","900"},
            {"Doctor Name : Vikram Harshad Patel","Hospital Address : Jharkhand", "Exp : 15yrs", "Mobile No:9845762145","900"},
            {"Doctor Name : S. Natarajan","Hospital Address : Chhattisgarh", "Exp : 8yrs", "Mobile No:9845762145","600"},
            {"Doctor Name : Namrata Sharma","Hospital Address :Tamil Nadu", "Exp : 6yrs", "Mobile No:9845762145","700"},
            {"Doctor Name : Kaushal Sheth","Hospital Address : Manipur", "Exp : 2yrs", "Mobile No:9845762145","400"},

    };
    private String[][] doctor_details3 ={
            {"Doctor Name : Gaurav Kharya ","Hospital Address : Chennai", "Exp : 5yrs", "Mobile No:9845762145","900"},
            {"Doctor Name : Mohamed Rela","Hospital Address : Pune", "Exp : 15yrs", "Mobile No:9845762145","900"},
            {"Doctor Name :  Anandi Gopal Joshi","Hospital Address : Bengaluru", "Exp : 8yrs", "Mobile No:9845762145","600"},
            {"Doctor Name : Devi Shetty","Hospital Address : Kolkata", "Exp : 6yrs", "Mobile No:9845762145","700"},
            {"Doctor Name : Anita Bhardwaj","Hospital Address : Hazaribagh", "Exp : 2yrs", "Mobile No:9845762145","400"},

    };
    private String[][] doctor_details4 ={
            {"Doctor Name : Ashish Sabharwal","Hospital Address : Jharkhand", "Exp : 5yrs", "Mobile No:9845762145","900"},
            {"Doctor Name : Sanjay Sachdeva","Hospital Address : Pune", "Exp : 15yrs", "Mobile No:9845762145","900"},
            {"Doctor Name : Aditya Gupta","Hospital Address : Bengaluru", "Exp : 8yrs", "Mobile No:9867762145","600"},
            {"Doctor Name : H. S. Chhabra","Hospital Address : Ranchi", "Exp : 6yrs", "Mobile No:9843462145","700"},
            {"Doctor Name : Ajit Saste","Hospital Address : Kolkata", "Exp : 2yrs", "Mobile No:9845767845","400"},

    };
    private String[][] doctor_details5 ={
            {"Doctor Name : Rounaque Afroz Haider ","Hospital Address : Jamshedpur", "Exp : 5yrs", "Mobile No:7480005285","900"},
            {"Doctor Name : AMIT KUMAR","Hospital Address : Pune", "Exp : 15yrs", "Mobile No:9845862145","800"},
            {"Doctor Name : Siddhartha Mukherjee","Hospital Address : Delhi", "Exp : 8yrs", "Mobile No:9845762145","300"},
            {"Doctor Name : Naresh Trehan","Hospital Address : Ranchi", "Exp : 6yrs", "Mobile No:9844762145","700"},
            {"Doctor Name : Surbhi Anand","Hospital Address : Kolkata", "Exp : 2yrs", "Mobile No:9345762145","400"},

    };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);
         listView = findViewById(R.id.listViewDD);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physician")==0)
            doctor_details = doctor_details1;
            else
            if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
            else
            if (title.compareTo("Dentist")==0)
                doctor_details = doctor_details3;
            else
            if (title.compareTo("Surgeon")==0)
                doctor_details = doctor_details4;
            else
                doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDocActivity.class));
            }
        });
        list = new ArrayList();
        for (int i=0; i <doctor_details.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter( this, list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
);

        listView.setAdapter (sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra( "text2",doctor_details[i][0]);
                it.putExtra( "text3",doctor_details[i][1]);
                it.putExtra( "text4",doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }
        });

    }
}