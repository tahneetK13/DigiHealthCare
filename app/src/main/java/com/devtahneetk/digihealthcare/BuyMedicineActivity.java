package com.devtahneetk.digihealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages = {
            {"Uprise-03 1000IU Capsule", "", "", "", "50"},
            {"HealthVit Chromium Picolinate Capsule", "", "", "", "305"},
            {"Vitamin B Complex Capsule", "", "", "", "448"},
            {"Inlife Vitamin E Capsule", "", "", "", "539"},
            {"Dolo 650 Tablet", "", "", "", "30"},
            {"Crocin 650 Advance Tablet", "", "", "", "50"},
            {"Strepsile Medicated Lozenges for Sore Throat", "", "", "", "40"},
            {"Tata 1mg Calcium", "", "", "", "30"},
            {"Feronia -XT tablet", "", "", "", "130"},
    };
    private String[] package_details = {
            "Building and Keeping the bones and teeth strong\n" +
                    "reducing Fatique/Stress and mascular pain\n" +
                    "Boosting imunity and increasing resisitance against infection",
            "Chromium is a essential trace mineral that play an important role in helping insulin regulation \n" +
                    "Provide relief from vitamin B deficiencies\n" +
                    "Helps in formation of red blood cell\n" +
                    "Maintains healthy nervous system",
            "It promotes health as well as skin benefits.\n" +
                    "it help reduce skin blemishes.\n" +
                    "It act as safeguards the skin from harmfull UV rays",
            "Help relieve fever and bring down a high temprature\n" +
                    "Suitable with people with heart conditions",
            "Reduce the Symptoms of a bacterial throat infection ",
            "Reduce the risk of Calcium deficiency",
            "Helps in reduce the iron deficiency due to chronic blood loss"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMCartBack);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<package_details.length;i++){
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5","Total Cost:" +packages[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter( this, list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        lst.setAdapter (sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);

            }
        });
        
    }
}