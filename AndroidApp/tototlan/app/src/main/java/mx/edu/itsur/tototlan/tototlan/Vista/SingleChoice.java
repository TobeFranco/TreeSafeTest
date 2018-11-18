package mx.edu.itsur.tototlan.tototlan.Vista;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mx.edu.itsur.tototlan.tototlan.R;
import mx.edu.itsur.tototlan.tototlan.modelo.Answer;
import mx.edu.itsur.tototlan.tototlan.modelo.Question;
import mx.edu.itsur.tototlan.tototlan.modelo.SingleChoicesQuestions;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SingleChoice.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SingleChoice#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SingleChoice extends QuestionFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "question";
    private static final String ARG_PARAM2 = "answer";

    // TODO: Rename and change types of parameters
    private SingleChoicesQuestions questions;
    private Answer answer;
    private  Activity activity;
    private LinearLayout linearLayout;


    private OnFragmentInteractionListener mListener;

    public SingleChoice() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SingleChoice newInstance(SingleChoicesQuestions question, Answer answer) {
        SingleChoice fragment = new SingleChoice();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, question);
        args.putSerializable(ARG_PARAM2, answer);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            questions = (SingleChoicesQuestions) getArguments().getSerializable(ARG_PARAM1);
            answer = (Answer) getArguments().getSerializable(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single_choice, container, false);
        linearLayout = view.findViewById(R.id.contenedor);
        generateRadios();

        return view;
    }

    public  void  generateRadios(){
        RadioGroup radioGroup = new RadioGroup(getContext());
        ArrayList<String> list = (ArrayList<String>) questions.getChoices();
        for (String choice:list) {
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setText(choice);
            radioGroup.addView(radioButton);
        }

        linearLayout.addView(radioGroup);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.activity=(Activity) context;
            //mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public String getAnswer() {
        return null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
