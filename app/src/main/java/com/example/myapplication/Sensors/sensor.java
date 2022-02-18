package com.example.myapplication.Sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

public class sensor extends AppCompatActivity implements SensorEventListener{
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor);
        tv = findViewById(R.id.textView2);

        addLightSensor();
    }

    public  void addLightSensor()
    {
//        1 create senor manager
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);


//        2 Create a sensor to listen
        Sensor lightSensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

//        3 Registering Senso
        sm.registerListener(this,lightSensor,sm.SENSOR_DELAY_NORMAL);

    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        System.out.println(event.values.length);
        tv.setText("x=> "+event.values[0]+"y=> "+event.values[1]+"z=> "+event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
