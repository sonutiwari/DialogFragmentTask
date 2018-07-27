package in.co.chicmic.dialogfragmenttask.fragments.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import in.co.chicmic.dialogfragmenttask.R;
import in.co.chicmic.dialogfragmenttask.interfaces.AskForSumInterface;
import in.co.chicmic.dialogfragmenttask.interfaces.ShowSumInterface;

public class InputFragment extends Fragment {

    private static AskForSumInterface mAskForSumInterface;
    private static ShowSumInterface mShowSumInterface;

    public InputFragment() {
        // Required empty public constructor
    }

    public static InputFragment newInstance(CustomInputDialog pDialog) {
        mAskForSumInterface = pDialog;
        mShowSumInterface = pDialog;
        return new InputFragment();
    }


    @Override
    public void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater pInflater, ViewGroup pContainer,
                             Bundle pSavedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = getArguments();
        if (bundle != null){
            mShowSumInterface.show();
        }
        View view = pInflater.inflate(R.layout.fragment_input, pContainer, false);
        Button nextButton = view.findViewById(R.id.btn_next);
        final TextInputEditText firstNumberTextInputEditText
                = view.findViewById(R.id.first_input_number);
        final TextInputEditText secondNumberTextInputEditText
                = view.findViewById(R.id.second_input_number);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double firstNumber = 0;
                double secondNumber = 0;
                if (!firstNumberTextInputEditText.getText().toString().equals("")){
                    firstNumber = Double.parseDouble(firstNumberTextInputEditText.getText().toString());
                }
                if (!secondNumberTextInputEditText.getText().toString().equals("")){
                    secondNumber = Double.parseDouble(secondNumberTextInputEditText.getText().toString());
                }
                mAskForSumInterface.loadAskForSumFragment(firstNumber, secondNumber);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context pContext) {
        super.onAttach(pContext);
        if (pContext instanceof InputFragmentListener) {
            // todo
        } else {
            throw new RuntimeException(pContext.toString()
                    + getString(R.string.must_implement));
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    public interface InputFragmentListener {
        void isInputFragmentRunning(boolean status);
    }
}
