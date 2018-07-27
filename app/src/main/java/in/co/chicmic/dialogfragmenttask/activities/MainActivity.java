package in.co.chicmic.dialogfragmenttask.activities;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;

import in.co.chicmic.dialogfragmenttask.R;
import in.co.chicmic.dialogfragmenttask.fragments.dialogs.CustomInputDialog;
import in.co.chicmic.dialogfragmenttask.fragments.dialogs.InputFragment;
import in.co.chicmic.dialogfragmenttask.fragments.dialogs.SumFragment;
import in.co.chicmic.dialogfragmenttask.utilities.AppConstants;

public class MainActivity extends AppCompatActivity
        implements InputFragment.InputFragmentListener, SumFragment.SumFragmentListener {

    @Override
    protected void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_main);
        DialogFragment dialog = CustomInputDialog.newInstance();
        dialog.setCancelable(false);
        dialog.show(getSupportFragmentManager(), AppConstants.INPUT_DIALOG_FRAGMENT);
    }

    @Override
    public void showSum(double pSum) {
    }
}
