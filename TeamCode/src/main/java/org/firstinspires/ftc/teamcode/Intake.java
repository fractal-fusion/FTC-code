package org.firstinspires.ftc.teamcode;

import android.hardware.HardwareBuffer;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    static final double open = 30;
    static final double close =0;
    private Servo clawServo;
    private Servo wristServo;
    public Intake(HardwareMap hardwareMap){
        clawServo = hardwareMap.get(Servo.class, "clawServo");
       wristServo  = hardwareMap.get(Servo.class, "wrist");
    }
    public void mode(double degrees){
       double servoTarget = degrees/360;
       wristServo.setPosition(servoTarget);
    }

}
