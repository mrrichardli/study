package com.ingphone.helloprogressdialog;

import com.ingphone.helloprogressdialog.R;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

/**
 * @author gqs
 * @version 创建时间：2012-11-23 上午10:59:43
 * 类说明
 */
public class MyDialog  extends ProgressDialog{

	public MyDialog(Context context, int theme) {
		super(context, theme);
		// TODO dvsdfads
	}

	public MyDialog(Context context) {
		super(context);
		// TODO sdfsdf
		
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	
//		progressDialog.setIndeterminate(true);
		setCancelable(false);

		//progressDialog.show()
		setContentView(R.layout.custom_progress_diaolog);
		
    }
    public void showDialog()
    {
    	show();
    }
}