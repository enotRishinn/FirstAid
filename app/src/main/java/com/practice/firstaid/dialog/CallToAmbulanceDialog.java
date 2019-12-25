package com.practice.firstaid.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.fragment.app.DialogFragment;

import com.practice.firstaid.R;

public class CallToAmbulanceDialog extends DialogFragment {

    private CallToAmbulanceDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),
                R.style.Theme_Sphinx_Dialog_Alert);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.call_to_ambulance_dialog, null);

        builder.setView(view)
                .setTitle(R.string.call_to_ambulance_dialog_title)
                .setIcon(R.drawable.ic_first_aid_24dp)
                .setNegativeButton(getString(R.string.call_to_ambulance_dialog_negative_btn),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                .setPositiveButton(getString(R.string.call_to_ambulance_dialog_positive_btn),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(new Intent(Intent.ACTION_DIAL,
                                        Uri.parse("tel:112")));
                            }
                        }
                );


        final AlertDialog dialog = builder.create();
        dialog.show();

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); //create a new one
        layoutParams.weight = 10;
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setLayoutParams(layoutParams);
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setLayoutParams(layoutParams);

        int titleDividerId = getResources().getIdentifier("titleDivider", "id", "android");
        View titleDivider = dialog.findViewById(titleDividerId);
        if (titleDivider != null)
            titleDivider.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));

        return dialog;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (CallToAmbulanceDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement AddDialogListener");
        }
    }

    public interface CallToAmbulanceDialogListener {
    }

}
