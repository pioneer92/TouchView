package com.TouchView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TouchView1 extends Activity implements OnTouchListener {

    private TextView eventlable;
    private TextView histroy;
    private TextView touchView_q;
    private TextView touchView_w;
    private TextView touchView_e;
    private TextView touchView_r;
    private TextView touchView_t;
    private TextView touchView_y;
    private TextView touchView_u;
    private TextView touchView_i;
    private TextView touchView_o;
    private TextView touchView_p;
    private TextView touchView_l;
    private TextView touchView_k;
    private TextView touchView_j;
    private TextView touchView_h;
    private TextView touchView_g;
    private TextView touchView_f;
    private TextView touchView_d;
    private TextView touchView_s;
    private TextView touchView_a;
    private TextView touchView_m;
    private TextView touchView_n;
    private TextView touchView_b;
    private TextView touchView_v;
    private TextView touchView_c;
    private TextView touchView_x;
    private TextView touchView_z;
    private Button switchButton;
    private EditText editText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        editText=(EditText)findViewById(R.id.editText1);
        histroy =(TextView)findViewById(R.id.history_label);
        eventlable =(TextView)findViewById(R.id.event_label);
        switchButton=(Button)findViewById(R.id.switchButton);
        

        touchView_q=(TextView)findViewById(R.id.touch_q);
        touchView_q.setOnTouchListener(this);
        touchView_w =(TextView)findViewById(R.id.touch_w);
        touchView_w.setOnTouchListener(this);
        touchView_e =(TextView)findViewById(R.id.touch_e);
        touchView_e.setOnTouchListener(this);
        touchView_r =(TextView)findViewById(R.id.touch_r);
        touchView_r.setOnTouchListener(this);
        touchView_t =(TextView)findViewById(R.id.touch_t);
        touchView_t.setOnTouchListener(this);
        touchView_y =(TextView)findViewById(R.id.touch_y);
        touchView_y.setOnTouchListener(this);
        touchView_u =(TextView)findViewById(R.id.touch_u);
        touchView_u.setOnTouchListener(this);
        touchView_i =(TextView)findViewById(R.id.touch_i);
        touchView_i.setOnTouchListener(this);
        touchView_o =(TextView)findViewById(R.id.touch_o);
        touchView_o.setOnTouchListener(this);
        touchView_p=(TextView)findViewById(R.id.touch_p);
        touchView_p.setOnTouchListener(this);
        touchView_l =(TextView)findViewById(R.id.touch_l);
        touchView_l.setOnTouchListener(this);
        touchView_k =(TextView)findViewById(R.id.touch_k);
        touchView_k.setOnTouchListener(this);
        touchView_j =(TextView)findViewById(R.id.touch_j);
        touchView_j.setOnTouchListener(this);
        touchView_h =(TextView)findViewById(R.id.touch_h);
        touchView_h.setOnTouchListener(this);
        touchView_g =(TextView)findViewById(R.id.touch_g);
        touchView_g.setOnTouchListener(this);
        touchView_f =(TextView)findViewById(R.id.touch_f);
        touchView_f.setOnTouchListener(this);
        touchView_d =(TextView)findViewById(R.id.touch_d);
        touchView_d.setOnTouchListener(this);
        touchView_s =(TextView)findViewById(R.id.touch_s);
        touchView_s.setOnTouchListener(this);
        touchView_a=(TextView)findViewById(R.id.touch_a);
        touchView_a.setOnTouchListener(this);
        touchView_m =(TextView)findViewById(R.id.touch_m);
        touchView_m.setOnTouchListener(this);
        touchView_n =(TextView)findViewById(R.id.touch_n);
        touchView_n.setOnTouchListener(this);
        touchView_b =(TextView)findViewById(R.id.touch_b);
        touchView_b.setOnTouchListener(this);
        touchView_v =(TextView)findViewById(R.id.touch_v);
        touchView_v.setOnTouchListener(this);
        touchView_c =(TextView)findViewById(R.id.touch_c);
        touchView_c.setOnTouchListener(this);
        touchView_x =(TextView)findViewById(R.id.touch_x);
        touchView_x.setOnTouchListener(this);
        touchView_z =(TextView)findViewById(R.id.touch_z);
        touchView_z.setOnTouchListener(this);
        
        switchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/TouchView");
        if (!file.exists()) {
     	   file.mkdir();
        }
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		int action =event.getAction();
		switch(action){
		//当按下的时候
		case (MotionEvent.ACTION_DOWN):
			Display("ACTION_DOWN",event,v);
		break;
		//当按上的时候
		case(MotionEvent.ACTION_UP):
			int historysize=ProcessHistory(event);
		    histroy.setText("历史数据"+historysize);
		    Display("ACTION_UP",event,v);
		    break;
		 //当触摸的时候
		case(MotionEvent.ACTION_MOVE):
			Display("ACTION_MOVE",event,v);
		}
		return true;
	}
    public void Display(String eventType,MotionEvent event,View v){
    	//触点相对坐标的信息
    	int x =(int) event.getX();
    	int y=(int)event.getY();
    	//表示触屏压力大小
    	float pressure =event.getPressure();
    	//表示触点尺寸
    	float size=event.getSize();
    	//获取绝对坐标信息
    	int RawX=(int)event.getRawX();
    	int RawY=(int)event.getRawY();
    	
    	float major=event.getTouchMajor();
    	float minor=event.getToolMinor();
    	
    	String msg="";
    	String string="";
    	switch (v.getId()) {
		case R.id.touch_q:
			string="q";
			break;

		case R.id.touch_w:
			string="w";
			break;

		case R.id.touch_e:
			string="e";
			break;

		case R.id.touch_r:
			string="r";
			break;

		case R.id.touch_t:
			string="t";
			break;

		case R.id.touch_y:
			string="y";
			break;

		case R.id.touch_u:
			string="u";
			break;

		case R.id.touch_i:
			string="i";
			break;

		case R.id.touch_o:
			string="o";
			break;
		case R.id.touch_p:
			string="p";
			break;

		case R.id.touch_l:
			string="l";
			break;

		case R.id.touch_k:
			string="k";
			break;

		case R.id.touch_j:
			string="j";
			break;

		case R.id.touch_h:
			string="h";
			break;

		case R.id.touch_g:
			string="g";
			break;

		case R.id.touch_f:
			string="f";
			break;

		case R.id.touch_d:
			string="d";
			break;

		case R.id.touch_s:
			string="s";
			break;
		case R.id.touch_a:
			string="a";
			break;

		case R.id.touch_m:
			string="m";
			break;

		case R.id.touch_n:
			string="n";
			break;

		case R.id.touch_b:
			string="b";
			break;

		case R.id.touch_v:
			string="v";
			break;

		case R.id.touch_c:
			string="c";
			break;

		case R.id.touch_x:
			string="x";
			break;

		case R.id.touch_z:
			string="z";
			break;

		default:
			break;
		}
        String name=Environment.getExternalStorageDirectory().getAbsolutePath()+"/TouchView/"+string+".txt";
    	if (event.getAction()==MotionEvent.ACTION_DOWN) {
        	editText.setText(editText.getText()+string);
		}
    	msg+="事件按钮"+string+"\n";
    	msg+="事件类型"+eventType+"\n";
    	msg+="相对坐标"+String.valueOf(x)+","+String.valueOf(y)+"\n";
    	msg+="绝对坐标"+String.valueOf(RawX)+","+String.valueOf(RawY)+"\n";
    	msg+="触点压力"+String.valueOf(pressure)+",";
    	msg+="触点尺寸"+String.valueOf(size)+"\n";
    	msg+="触点长轴"+String.valueOf(major)+"\n";
    	msg+="触点短轴"+String.valueOf(minor)+"\n";
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

}
