package mx.edu.itsur.tototlan.tototlan;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.edu.itsur.tototlan.tototlan.TestViewHolder.TestViewHolder;
import mx.edu.itsur.tototlan.tototlan.modelo.Test;


public class Exams_fragment extends Fragment {
    View myFragment;

    RecyclerView listExam;
    RecyclerView.LayoutManager layoutManager;
    //FirebaseRecyclerAdapter<Test,TestViewHolder> adapter;
    //FirebaseDatabase database;
    //DatabaseReference exams;


    public static Exams_fragment newInstance() {
        Exams_fragment exams_fragment = new Exams_fragment();
        return exams_fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  database = FirebaseDatabase.getInstance();
        //exams = database.getReference("Exam");
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
        loadExams();
        return myFragment;
    }

    private void loadExams() {
        //adapter = new FirebaseRecyclerAdapter<Exam, ExamViewHolder>(
          //      Exam.class,
            //    R.layout.exam_layout,
              //  ExamViewHolder.class,
                //exams
        //) {
        //  @Override
          //  protected void populateViewHolder(ExamViewHolder viewHolder, final Exam model, int position) {
            //    viewHolder.exam_name.setText(model.getName());
              //  Picasso.with(getActivity())
                //        .load(model.getImage())
                  //      .into(viewHolder.exam_image);

                //viewHolder.setItemClickListener(new ItemClickListener() {
                //    @Override
               //     public void onClick(View view, int position, boolean isLongClick) {

                        //Toast.makeText(getActivity(),String.format("%s|%s",adapter.getRef(position).getKey(),model.getName()),Toast.LENGTH_SHORT).show();
                  //      Intent startExam = new Intent(getActivity(), Start.class);
                  //      Common.examenId = adapter.getRef(position).getKey();
                 //       startActivity(startExam);

              //      }
           //     });
           // }
      //  };

      //  adapter.notifyDataSetChanged();
     //   listExam.setAdapter(adapter);
    }
}
