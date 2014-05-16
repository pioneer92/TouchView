package com.TouchView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TouchView extends Activity implements OnTouchListener {

    private TextView eventlable;
    private TextView histroy;
    private TextView touchView_1;
    private TextView touchView_2;
    private TextView touchView_3;
    private TextView touchView_4;
    private TextView touchView_5;
    private TextView touchView_6;
    private TextView touchView_7;
    private TextView touchView_8;
    private TextView touchView_9;
    private Button switchButton;
    private EditText editText;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        editText=(EditText)findViewById(R.id.editText);
        histroy =(TextView)findViewById(R.id.history_label);
        eventlable =(TextView)findViewById(R.id.event_label);
        switchButton=(Button)findViewById(R.id.switchButton);
        touchView_1 =(TextView)findViewById(R.id.touch_1);
        touchView_1.setOnTouchListener(this);
        touchView_2=(TextView)findViewById(R.id.touch_2);
        touchView_2.setOnTouchListener(this);
        touchView_3 =(TextView)findViewById(R.id.touch_3);
        touchView_3.setOnTouchListener(this);
        touchView_4 =(TextView)findViewById(R.id.touch_4);
        touchView_4.setOnTouchListener(this);
        touchView_5 =(TextView)findViewById(R.id.touch_5);
        touchView_5.setOnTouchListener(this);
        touchView_6 =(TextView)findViewById(R.id.touch_6);
        touchView_6.setOnTouchListener(this);
        touchView_7 =(TextView)findViewById(R.id.touch_7);
        touchView_7.setOnTouchListener(this);
        touchView_8 =(TextView)findViewById(R.id.touch_8);
        touchView_8.setOnTouchListener(this);
        touchView_9 =(TextView)findViewById(R.id.touch_9);
        touchView_9.setOnTouchListener(this);
        switchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(TouchView.this, TouchView1.class);
				startActivity(intent);
			}
		});
       File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/TouchView");
       if (!file.exists()) {
    	   file.mkdir();
       }
    }
    public void Display(String eventType,MotionEvent event,View v){
    	//��������������Ϣ
    	int x =(int) event.getX();
    	int y=(int)event.getY();
    	//��ʾ����ѹ����С
    	float pressure =event.getPressure();
    	//��ʾ����ߴ�
    	float size=event.getSize();
    	//��ȡ����������Ϣ
    	int RawX=(int)event.getRawX();
    	int RawY=(int)event.getRawY();
    	
    	float major=event.getTouchMajor();
    	float minor=event.getToolMinor();
    	
    	String msg="";
    	String string="";
    	switch (v.getId()) {
		case R.id.touch_1:
			string="1";
			break;

		case R.id.touch_2:
			string="2";
			break;

		case R.id.touch_3:
			string="3";
			break;

		case R.id.touch_4:
			string="4";
			break;

		case R.id.touch_5:
			string="5";
			break;

		case R.id.touch_6:
			string="6";
			break;

		case R.id.touch_7:
			string="7";
			break;

		case R.id.touch_8:
			string="8";
			break;

		case R.id.touch_9:
			string="9";
			break;

		default:
			break;
		}
        String name=Environment.getExternalStorageDirectory().getAbsolutePath()+"/TouchView/"+string+".txt";
    	if (event.getAction()==MotionEvent.ACTION_DOWN) {
        	editText.setText(editText.getText()+string);
		}
    	msg+="�¼���ť"+string+"\n";
    	msg+="�¼�����"+eventType+"\n";
    	msg+="�������"+String.valueOf(x)+","+String.valueOf(y)+"\n";
    	msg+="��������"+String.valueOf(RawX)+","+String.valueOf(RawY)+"\n";
    	msg+="����ѹ��"+String.valueOf(pressure)+",";
    	msg+="����ߴ�"+String.valueOf(size)+"\n";
    	msg+="���㳤��"+String.valueOf(major)+"\n";
    	msg+="�������"+String.valueOf(minor)+"\n";
    	eventlable.setText(msg);
    	try {
			FileOutputStream fileOutputStream=new FileOutputStream(name,true);
			fileOutputStream.write("-----------------\n".getBytes());
			fileOutputStream.write(msg.getBytes());
			fileOutputStream.write("-----------------\n".getBytes());
			fileOutputStream.flush();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public int ProcessHistory(MotionEvent event){
    	int history =event.getHistorySize();
    	for(int i=0;i<history;i++){
    		long time=event.getHistoricalEventTime(i);
    		float pressure=event.getHistoricalPressure(i);
    		float x=event.getHistoricalX(i) ;
    		float y=event.getHistoricalY(i);
    	    float size=event.getHistoricalSize(i);	
    	}
    	
		return history;
    	
    }
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		int action =event.getAction();
		switch(action){
		//�����µ�ʱ��
		case (MotionEvent.ACTION_DOWN):
			Display("ACTION_DOWN",event,v);
		break;
		//�����ϵ�ʱ��
		case(MotionEvent.ACTION_UP):
			int historysize=ProcessHistory(event);
		    histroy.setText("��ʷ����"+historysize);
		    Display("ACTION_UP",event,v);
		    break;
		 //��������ʱ��
		case(MotionEvent.ACTION_MOVE):
			Display("ACTION_MOVE",event,v);
		}
		return true;
	}
    
}