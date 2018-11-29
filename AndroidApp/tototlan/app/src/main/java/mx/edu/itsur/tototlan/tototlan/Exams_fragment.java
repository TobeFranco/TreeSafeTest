package mx.edu.itsur.tototlan.tototlan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import mx.edu.itsur.tototlan.tototlan.modelo.Test;


public class Exams_fragment extends Fragment {
    View myFragment;

    RecyclerView listExam;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Test> testList=new ArrayList<>();
    Test test = new Test();



    public static Exams_fragment newInstance() {
        Exams_fragment exams_fragment = new Exams_fragment();
        return exams_fragment;

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  database = FirebaseDatabase.getInstance();
        //exams = database.getReference("Exam");
        Test test = new Test();
        test.setIdTest(1);
        test.setDesciption("Examen Faciito de esos que pasas bien chido");
        test.setTeacherName("Antonio Tierritas");
        test.setEndDate(Calendar.getInstance().getTime());
        test.setStartDate(Calendar.getInstance().getTime());
        testList.add(test);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragment = inflater.inflate(R.layout.exams_fragment,container,false);
        listExam = (RecyclerView)myFragment.findViewById(R.id.listExams);
        listExam.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(container.getContext());
        listExam.setLayoutManager(layoutManager);
        MyAdapter adapter = new MyAdapter(getContext(),testList);
        adapter.notifyDataSetChanged();
        listExam.setAdapter(adapter);

        return myFragment;
    }



    public class MyAdapter extends RecyclerView.Adapter<TestViewHolder> {

        Context c;
        ArrayList<Test> test;

        public MyAdapter(Context c, ArrayList<Test> test) {
            this.c = c;
            this.test = test;
        }

        @Override
        public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(c).inflate(R.layout.exam_layout,parent,false);
            return new TestViewHolder(v);
        }

        @Override
        public void onBindViewHolder(TestViewHolder holder, int position) {
            holder.txt_description.setText(test.get(position).getDesciption());
            holder.txt_teacher.setText(test.get(position).getTeacherName());
            holder.txt_star_date.setText(test.get(position).getStartDate().toString());
            holder.txt_end_date.setText(test.get(position).getEndDate().toString());
        }

        @Override
        public int getItemCount() {
            return test.size();
        }
    }

    public class TestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txt_description;
        public TextView txt_teacher;
        public TextView txt_star_date;
        public TextView txt_end_date;


        private ItemClickListener itemClickListener;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_description = (TextView) itemView.findViewById(R.id.txt_description);
            txt_teacher = (TextView) itemView.findViewById(R.id.txt_teacher_name);
            txt_star_date = (TextView) itemView.findViewById(R.id.txt_start_date);
            txt_end_date = (TextView) itemView.findViewById(R.id.txt_end_date);

            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {

            Intent startExam = new Intent(getActivity(),QuestionsContainer.class);
            startActivity(startExam);
        }
    }

}
