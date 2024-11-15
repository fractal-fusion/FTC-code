package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    //declare the servos
    private Servo claw;
    private Servo wrist;

    //define preset degrees for the opening and closing of the claw
    public static final double open = 30.0;
    public static final double close = 0.0;

    //define the resting position.
    final double restingPos = 0.5;

    //constructor which acts as an initialization function for whenever an object of the class is created
    public Intake(HardwareMap hardwareMap){
        claw = hardwareMap.get(Servo.class, "claw");
        wrist = hardwareMap.get(Servo.class, "wrist");
    }

    //sets the open or close mode of the claw
    public void mode(double degrees) {
        double servoTarget = degrees/300.0;
        claw.setPosition(servoTarget);
    }

    //lets the passed in gamepad control the wrist
    public void controlWrist(Gamepad gamepad) {
        //since restingPos is 0.5, max position to the left would be 0.5 + -0.5 resulting in zero and 0.5 + 0.5
        //would result in one
        double servoTarget = (gamepad.right_stick_x * 0.5) + restingPos;
        wrist.setPosition(servoTarget);
    }

    //returns the wrist to resting position
    public void setRestingPos() {
        wrist.setPosition(restingPos);
    }
}