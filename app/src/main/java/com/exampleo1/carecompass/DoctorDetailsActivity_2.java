package com.exampleo1.carecompass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity_2 extends AppCompatActivity {
    private String[][] doctor_details1 = {
            {"Doctor Name: Halum bagdum", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533777543", "500"},
            {"Doctor Name: malum tukum", "Hospital Address: Dhaka", "Exp: 3 years", "Mobile No:01533777546", "500"},
            {"Doctor Name: galum sulil", "Hospital Address: Jassore", "Exp: 2 years", "Mobile No:01533777545", "500"},
            {"Doctor Name: salum lalaa", "Hospital Address: Ratargul", "Exp: 4 years", "Mobile No:01533777541", "500"},
            {"Doctor Name: dalum dimuuu", "Hospital Address: koita", "Exp: 1 years", "Mobile No:01533777542", "500"}
    };

    private String[][] doctor_details2 = {
            {"Doctor Name: ralum", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533777512", "500"},
            {"Doctor Name: walum", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533777513", "500"},
            {"Doctor Name: qalum", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533777515", "500"},
            {"Doctor Name: salum", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533777514", "500"},
            {"Doctor Name: aalum", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533777511", "500"}
    };

    private String[][] doctor_details3 = {
            {"Doctor Name: wwlum", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533777123", "500"},
            {"Doctor Name: welum", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533777111", "500"},
            {"Doctor Name: qwlum", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533777121", "500"},
            {"Doctor Name: aalum", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533777122", "500"},
            {"Doctor Name: aslum", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533777222", "500"}
    };

    private String[][] doctor_details4 = {
            {"Doctor Name: Haum", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:0153377224", "500"},
            {"Doctor Name: Ham", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533777111", "500"},
            {"Doctor Name: Hlum", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:0153377124", "500"},
            {"Doctor Name: lum", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533756789", "500"},
            {"Doctor Name: Hau", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533771235", "500"}
    };

    private String[][] doctor_details5 = {
            {"Doctor Name: Hawqwe", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533711111", "500"},
            {"Doctor Name: Hadsd", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533722222", "500"},
            {"Doctor Name: Haqeq", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533733333", "500"},
            {"Doctor Name: Haas", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533755555", "500"},
            {"Doctor Name: adsam", "Hospital Address: Khulna", "Exp: 5 years", "Mobile No:01533744444", "500"}
    };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details2);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonLTBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians") == 0){
            doctor_details = doctor_details1;
        }
        else
        if(title.compareTo("Dietician")==0){
            doctor_details = doctor_details2;
        }
        else
        if(title.compareTo("Dentist")==0) {
            doctor_details = doctor_details3;
        } else
        if(title.compareTo("Surgeon")==0){
            doctor_details = doctor_details4;

        }
        else{
            doctor_details = doctor_details5;
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity_2.this, FindDoctorActivity2.class));
            }
        });

        list = new ArrayList();
        for(int i=0; i<doctor_details.length; i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add( item );

        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewLT);
        lst.setAdapter(sa);

         lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity_2.this, Book_Appointment2.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);

            }

        });

    }
}