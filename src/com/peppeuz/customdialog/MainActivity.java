package com.peppeuz.customdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	final Context context = this;
	Button button;
	TextView mainText;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button = (Button) findViewById(R.id.CustomDialog_btn);
		mainText = (TextView) findViewById(R.id.mainText);

		// add button listener
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				// custom dialog
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.custom);
				dialog.setTitle("AndroidWorld");


				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText("Digita qui il testo che vuoi far apparire:");
				
				final EditText input = (EditText) dialog
						.findViewById(R.id.inputText);

				Button buttonDialog = (Button) dialog
						.findViewById(R.id.dialogButtonOK);

				buttonDialog.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						String testo = input.getText().toString();
						mainText.setText(testo);
						dialog.dismiss();
					}
				});

				dialog.show();
			}
		});
	}
}