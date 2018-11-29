package mx.edu.itsur.tototlan.tototlan.Vista;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import mx.edu.itsur.tototlan.tototlan.R;
import mx.edu.itsur.tototlan.tototlan.modelo.Answer;
import mx.edu.itsur.tototlan.tototlan.modelo.MultipleChoiceQuestion;

public class MultipleChoiceFragment extends QuestionFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "question";
    private static final String ARG_PARAM2 = "answer";

    // TODO: Rename and change types of parameters
    private MultipleChoiceQuestion questions;
    private Answer answer;
    private Activity activity;
    private LinearLayout linearLayout;
    private LinearLayout linearCheck;
    private CheckBox checkBox;
    private TextView statement;

    private OnFragmentInteractionListener mListener;

    public MultipleChoiceFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MultipleChoiceFragment newInstance(MultipleChoiceQuestion question, Answer answer) {
        MultipleChoiceFragment fragment = new MultipleChoiceFragment();
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
            questions = (MultipleChoiceQuestion) getArguments().getSerializable(ARG_PARAM1);
            answer = (Answer) getArguments().getSerializable(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_multiple_choice, container, false);
        linearLayout = view.findViewById(R.id.frame_multiple);
        statement = view.findViewById(R.id.lblStatement_Multi);
        linearCheck = view.findViewById(R.id.linear_check);

        statement.setText(questions.getData().getStatement());

        List<String> list = questions.getChoices();
        for (int i=0; i < list.size(); i++){
            checkBox = new CheckBox(getContext());
            checkBox.setTextSize(20);
            checkBox.setId(i);
            checkBox.setText(list.get(i));
            checkBox.setPadding(16,16,16,16);
            linearCheck.addView(checkBox);
        }

        return view;
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