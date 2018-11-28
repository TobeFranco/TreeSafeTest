package mx.edu.itsur.tototlan.tototlan.Vista;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import mx.edu.itsur.tototlan.tototlan.R;
import mx.edu.itsur.tototlan.tototlan.modelo.Answer;
import mx.edu.itsur.tototlan.tototlan.modelo.Question;
import mx.edu.itsur.tototlan.tototlan.modelo.TrueFalseQuestion;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TrueFalseQuestionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TrueFalseQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrueFalseQuestionFragment extends QuestionFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "question";
    private static final String ARG_PARAM2 = "answer";

    // TODO: Rename and change types of parameters
    private Question question;
    private Answer answer;
    private OnFragmentInteractionListener mListener;
    RadioGroup radioGroup;
    RadioButton radioButtonTrue,radioButtonFalse;
    private Activity activity;
    public TrueFalseQuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment OpenQuestion.
     */
    // TODO: Rename and change types and number of parameters
    public static TrueFalseQuestionFragment newInstance(TrueFalseQuestion question, Answer answer) {
        TrueFalseQuestionFragment fragment = new TrueFalseQuestionFragment();
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
            question = (Question) getArguments().getSerializable(ARG_PARAM1);
            answer = (Answer) getArguments().getSerializable(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        if (getArguments() != null) {
        View view = inflater.inflate(R.layout.fragment_true_false_question, container, false);
        radioButtonFalse = view.findViewById(R.id.rbFalse);
        radioButtonTrue = view.findViewById(R.id.rbTrue);
        radioGroup = view.findViewById(R.id.RGButtons);
//        String respuestaPrevia = answer.getAnswer();
//        editText.setText(respuestaPrevia);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
        if (radioButtonTrue.isSelected()){
            return (String) radioButtonFalse.getText();
        }else if (radioButtonFalse.isSelected()){
            return (String) radioButtonTrue.getText();
        }else{
            return "";
        }
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
