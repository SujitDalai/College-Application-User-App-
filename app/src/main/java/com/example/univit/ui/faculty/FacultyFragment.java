package com.example.univit.ui.faculty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.univit.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {
    private Button fab;
    private RecyclerView soetDepartment, somDepartment, solDepartment, soeDepartment;
    private LinearLayout soetNoData, somNoData, solNoData, soeNoData;
    private List<TeacherData> list1, list2, list3, list4;
    private DatabaseReference reference, dbRef;
    private TeacherAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);
        soetDepartment = view.findViewById(R.id.soetDepartment);
        somDepartment = view.findViewById(R.id.somDepartment);
        solDepartment = view.findViewById(R.id.solDepartment);
        soeDepartment = view.findViewById(R.id.soeDepartment);

        soetNoData = view.findViewById(R.id.soetNoData);
        somNoData = view.findViewById(R.id.somNoData);
        solNoData = view.findViewById(R.id.solNoData);
        soeNoData = view.findViewById(R.id.soeNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        soetDepartment();
        somDepartment();
        solDepartment();
        soeDepartment();
        return view;
    }

    private void soetDepartment() {
        dbRef = reference.child("SOET");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list1 = new ArrayList<>();
                if(!datasnapshot.exists()){
                    soetNoData.setVisibility(View.VISIBLE);
                    soetDepartment.setVisibility(View.GONE);
                }else{
                    soetNoData.setVisibility(View.GONE);
                    soetDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    soetDepartment.setHasFixedSize(true);
                    soetDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    soetDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void somDepartment() {
        dbRef = reference.child("SOM");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list2 = new ArrayList<>();
                if(!datasnapshot.exists()){
                    somNoData.setVisibility(View.VISIBLE);
                    somDepartment.setVisibility(View.GONE);
                }else{
                    somNoData.setVisibility(View.GONE);
                    somDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    somDepartment.setHasFixedSize(true);
                    somDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    somDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void solDepartment() {
        dbRef = reference.child("SOL");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list3 = new ArrayList<>();
                if(!datasnapshot.exists()){
                    solNoData.setVisibility(View.VISIBLE);
                    solDepartment.setVisibility(View.GONE);
                }else{
                    solNoData.setVisibility(View.GONE);
                    solDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    solDepartment.setHasFixedSize(true);
                    solDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    solDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void soeDepartment() {
        dbRef = reference.child("SOE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list4 = new ArrayList<>();
                if(!datasnapshot.exists()){
                    soeNoData.setVisibility(View.VISIBLE);
                    soeDepartment.setVisibility(View.GONE);
                }else{
                    soeNoData.setVisibility(View.GONE);
                    soeDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: datasnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    soeDepartment.setHasFixedSize(true);
                    soeDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    soeDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}