package com.ankur.petukrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<DataModel> mList;
    private ItemAdapter adapter;
    FirebaseFirestore firebaseFirestore;
//    Button inc;
//    Button dec;
//    TextView count;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        dec=findViewById(R.id.decrement);
//        inc=findViewById(R.id.increment);
//        count=findViewById(R.id.count);
//        dec.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               int cnt = Integer.parseInt(count.getText().toString());
//             if (cnt>0)
//               {
//                   cnt-=1;
//                   count.setText(cnt);
//               }
//               else
//             {
//                 count.setText(0);
//             }
//            }
//        });
//        inc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int cnt = Integer.parseInt(count.getText().toString());
//                if (cnt>=0)
//                {
//                    cnt+=1;
//                    count.setText(cnt);
//                }
//
//
//            }
//        });
        RecyclerView recyclerView = findViewById(R.id.parentRecyclerview);
        firebaseFirestore=FirebaseFirestore.getInstance();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

            mList = new ArrayList<>();


        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        firebaseFirestore.collection("Pasta").get().addOnCompleteListener(task -> {
            if (task.isSuccessful())
            {
                list3.clear();
                for (QueryDocumentSnapshot s : task.getResult())
                {
                    list3.add(s.getId() +"   =>   "+s.getData());
                }
            }


        });

            firebaseFirestore.collection("Burger").get().addOnCompleteListener(task -> {
                if (task.isSuccessful())
                {
                    list1.clear();
                    for (QueryDocumentSnapshot s : task.getResult())
                    {
                        list1.add(s.getId() +"   =>   "+s.getData());
                    }
                }


            });

        firebaseFirestore.collection("Pizza").get().addOnCompleteListener(task -> {
            if (task.isSuccessful())
            {
                list2.clear();
                for (QueryDocumentSnapshot s : task.getResult())
                {
                    list2.add(s.getId() +"   =>   "+s.getData());
                }
            }


        });


            mList.add(new DataModel(list1 , "Burger",R.drawable.burger));
            mList.add(new DataModel( list2,"Pizza",R.drawable.pizzamain));
            mList.add(new DataModel( list3,"Pasta",R.drawable.pasta));


            adapter = new ItemAdapter(mList);
            recyclerView.setAdapter(adapter);
        }


}