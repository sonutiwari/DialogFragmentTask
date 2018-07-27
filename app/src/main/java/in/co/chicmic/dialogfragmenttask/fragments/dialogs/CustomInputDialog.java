package in.co.chicmic.dialogfragmenttask.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

import in.co.chicmic.dialogfragmenttask.R;
import in.co.chicmic.dialogfragmenttask.interfaces.AskForSumInterface;
import in.co.chicmic.dialogfragmenttask.interfaces.ShowSumInterface;
import in.co.chicmic.dialogfragmenttask.utilities.AppConstants;

public class CustomInputDialog extends DialogFragment
        implements SumFragment.SumFragmentListener, AskForSumInterface
        , InputFragment.InputFragmentListener, ShowSumInterface {

    private TextView mSumTextView;
    private double mSum;

    public static CustomInputDialog newInstance() {
        return new CustomInputDialog();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater pInflater
            , @Nullable ViewGroup pContainer, @Nullable Bundle pSavedInstanceState) {
        View view = pInflater.inflate(R.layout.custom_input_dialog_layout, pContainer);
        mSumTextView = view.findViewById(R.id.txt_sum);
        this.getChildFragmentManager()
                .beginTransaction()
                .add(R.id.frame, InputFragment.newInstance(this)
                        , AppConstants.INPUT_DIALOG_FRAGMENT)
                .commit();
        return view;
    }

    public void loadAskForSumFragment(double pFirstNumber, double pSecondNumber) {
        mSumTextView.setVisibility(View.GONE);
        SumFragment fragment = SumFragment.newInstance(this);
        Double sum = pFirstNumber + pSecondNumber;
        Bundle bundle = new Bundle();
        bundle.putDouble(AppConstants.GET_SUM, sum);
        fragment.setArguments(bundle);
        this.getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.frame
                        , fragment, AppConstants.SUM_FRAGMENT_TAG)
                .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                .commit();
    }

    public void showSum(double pSum) {
        InputFragment fragment = InputFragment.newInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.GET_SUM, AppConstants.GET_SUM);
        fragment.setArguments(bundle);
        this.getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, fragment)
                .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                .commit();
        mSum = pSum;
    }

    @Override
    public void show() {
        mSumTextView
                .setText(String.format(Locale.ENGLISH
                        , "%s%f", getString(R.string.sum_message), mSum));
        mSumTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void isInputFragmentRunning(boolean status) {

    }
}
