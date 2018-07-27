package in.co.chicmic.dialogfragmenttask.fragments.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import in.co.chicmic.dialogfragmenttask.R;
import in.co.chicmic.dialogfragmenttask.utilities.AppConstants;


public class SumFragment extends Fragment {

    private static SumFragmentListener mListener;
    private double mSum = 0;

    public SumFragment() {
        // Required empty public constructor
    }

    public static SumFragment newInstance(CustomInputDialog pDialog) {
        mListener = pDialog;
        return new SumFragment();
    }

    @Override
    public void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater pInflater, ViewGroup pContainer,
                             Bundle pSavedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null){
            mSum = bundle.getDouble(AppConstants.GET_SUM);
        }
        // Inflate the layout for this fragment
        View view = pInflater.inflate(R.layout.fragment_sum, pContainer, false);
        Button sumButton = view.findViewById(R.id.btn_sum);
        final FragmentManager fragmentManager = this.getChildFragmentManager();
        sumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.popBackStack();
                mListener.showSum(mSum);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context pContext) {
        super.onAttach(pContext);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface SumFragmentListener {
        void showSum(double pSum);
    }
}
