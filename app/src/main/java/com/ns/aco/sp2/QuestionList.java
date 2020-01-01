package com.ns.aco.sp2;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

/**
 * Created by ns on 2016/10/23.
 */
public class QuestionList {

//    private Activity _activity = null;
    private View _selectView = null;
    private LinearLayout _questionList = null;
    private EditText _editAnswer = null;
    private EditText _editVotesPercent = null;
    private ToggleButton _buttonDelete = null;

    public View get_selectView(){
        return  _selectView;
    }

    public LinearLayout get_questionList(){
        return  _questionList;
    }

    public EditText get_editAnswer(){
        return  _editAnswer;
    }

    public EditText get_editVotesPercent(){
        return  _editVotesPercent;
    }

    public ToggleButton get_toggleEnable(){
        return  _buttonDelete;
    }

    QuestionList(Activity activity){
//        _activity = activity;
        _selectView = activity.getLayoutInflater().inflate(R.layout.question_list, null);
        _questionList = (LinearLayout)_selectView.findViewById(R.id.questionList);
        _editAnswer = (EditText)_selectView.findViewById(R.id.editAnswer);
        _editVotesPercent = (EditText)_selectView.findViewById(R.id.editVotesPercent1);
        _buttonDelete = (ToggleButton)_selectView.findViewById(R.id.toggleEnable);
    }
}
