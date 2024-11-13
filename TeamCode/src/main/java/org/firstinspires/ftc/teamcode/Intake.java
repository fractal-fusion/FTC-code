package org.firstinspires.ftc.teamcode;

import android.hardware.HardwareBuffer;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    static final double open = 30;
    static final double close =0;
    final double restingPos = 0.5;
    private Servo clawServo;
    private Servo wristServo;
    private double clampDouble(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }
    public Intake(HardwareMap hardwareMap){
        clawServo = hardwareMap.get(Servo.class, "clawServo");
       wristServo  = hardwareMap.get(Servo.class, "wrist");
    }
    public void mode(double degrees){
       double servoTarget = degrees/360;
       clawServo.setPosition(servoTarget);
    }
    public void wristPos(Gamepad gamepad2) {
        double servoTarget = 0;
        if (gamepad2.right_stick_x >= 0) {
            servoTarget = gamepad2.right_stick_x * 0.5 + restingPos;
        } else if (gamepad2.right_stick_x < 0) {
            servoTarget = gamepad2.right_stick_x * 0.5 + restingPos;
        }
        wristServo.setPosition(servoTarget);

    }
    public void setRestingPos(double servoPos){
        wristServo.setPosition(servoPos);
    }
}
