package com.example.pc.work3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class tizhong extends Activity {
    private Button caculatorButton;
    private EditText weight;
    private CheckBox manCheckBox,womanCheckBox;
    private TextView ResultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tizhong);
        caculatorButton= (Button) findViewById(R.id.button);
        weight= (EditText) findViewById(R.id.editText);
        manCheckBox= (CheckBox) findViewById(R.id.man);
        womanCheckBox= (CheckBox) findViewById(R.id.woman);
        ResultTextView= (TextView) findViewById(R.id.textView6);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerEvent();
    }
    public void registerEvent(){
        caculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!weight.getText().toString().trim().equals("")) {
                    if (manCheckBox.isChecked() || womanCheckBox.isChecked()) {
                        Double editText = Double.parseDouble(weight.getText().toString());
                        StringBuffer sb = new StringBuffer();
                        sb.append("======评估结果========\n");
                        if (manCheckBox.isChecked()) {
                            sb.append("男标准身高：");
                            double textView6 = evaluateHeight(editText,"男");
                            sb.append((int)textView6+"(厘米)");
                        }
                        if(womanCheckBox.isChecked()){
                            sb.append("女性");
                            double textView6=evaluateHeight(editText,"女");
                            sb.append((int)textView6+"(厘米)");
                        }
                        ResultTextView.setText(sb.toString());

                    } else {
                        showMessage("请选择你的性别！");
                    }

                } else {
                    showMessage("请输入体重！");
                }
            }
        });
    }
    public double evaluateHeight(double weight, String sex){
        double height;
        if(sex=="男"){
            height=170-(62-weight)/0.6;
        }else{
            height=158-(52-weight)/0.5;
        }
        return height;
    }

    public void showMessage(String message){
        AlertDialog alert=new AlertDialog.Builder(this).create();
        alert.setTitle("系统信息");
        alert.setMessage(message);
        alert.setButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        alert.show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tizhong, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}




