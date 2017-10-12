package com.mediatek.factorymode.motor;

import com.mediatek.factorymode.R;
import com.mediatek.factorymode.Utils;

import android.app.Activity;
import android.app.Service;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Motor;
import android.util.Log;
import android.view.View;

public class MotorActivity extends Activity {

	public Motor mMotor;

	public Handler mHandler = new Handler() {
	};
	public Runnable mRunnable = new Runnable() {

		@Override
		public void run() {
			try {
				mMotor.robot_stop();
				mMotor.robot_h_stop();
				Log.i("stop", "stop all");
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	};
	public Runnable wheelRunnable = new Runnable() {

		@Override
		public void run() {
			try {
				mMotor.robot_stop();
				Log.i("stop", "stop wheel");
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	};
	public Runnable headRunnable = new Runnable() {

		@Override
		public void run() {
			try {
				mMotor.robot_h_stop();
				Log.i("stop", "stop head");
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_motor);

		try {
			if (mMotor == null) {
				mMotor = (Motor) getSystemService(Service.MOTOR_SERVICE);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public void button001(View view) {
		try {
			mMotor.robot_forward(0);
			mHandler.postDelayed(wheelRunnable, 1200);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void button002(View view) {
		try {
			mMotor.robot_back(1);
			mHandler.postDelayed(wheelRunnable, 1200);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void button003(View view) {
		try {
			mMotor.robot_turn_left(2);
			mHandler.postDelayed(wheelRunnable, 1200);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void button004(View view) {
		try {
			mMotor.robot_turn_right(3);
			mHandler.postDelayed(wheelRunnable, 1200);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void button005(View view) {
		try {
			mMotor.robot_head_up(4);
			mHandler.postDelayed(headRunnable, 1200);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void button006(View view) {
		try {
			mMotor.robot_head_down(5);
			mHandler.postDelayed(headRunnable, 1200);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void button007(View view) {
		try {
			mMotor.robot_head_left(6);
			mHandler.postDelayed(headRunnable, 1200);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void button008(View view) {
		try {
			mMotor.robot_head_right(7);
			mHandler.postDelayed(headRunnable, 1200);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void button009(View view) {
		SharedPreferences sharedPreferences = getSharedPreferences("FactoryMode", 0);
		Utils.SetPreferences(this, sharedPreferences, R.string.motor, "success");
		finish();
	}

	public void button010(View view) {
		SharedPreferences sharedPreferences = getSharedPreferences("FactoryMode", 0);
		Utils.SetPreferences(this, sharedPreferences, R.string.motor, "failed");
		finish();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
