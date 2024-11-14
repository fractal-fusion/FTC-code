package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    static final double open = 30.0;
    static final double close = 0.0;
    final double restingPos = 0.5;
    private Servo claw;
    private Servo wrist;

    public Intake(HardwareMap hardwareMap){
        claw = hardwareMap.get(Servo.class, "claw");
        wrist = hardwareMap.get(Servo.class, "wrist");
    }
    public void mode(double degrees) {
        double servoTarget = degrees/300.0;
        claw.setPosition(servoTarget);
    }
    public void controlWrist(Gamepad gamepad) {
        double servoTarget = gamepad.right_stick_x * (restingPos/2.0) + restingPos;
        wrist.setPosition(servoTarget);
    }

    public void setRestingPos() {
        wrist.setPosition(0.0);
    }
}