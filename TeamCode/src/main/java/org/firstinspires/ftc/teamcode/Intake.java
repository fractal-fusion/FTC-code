package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    //declare the servos
    public Servo claw;
    public Servo wrist;

    //define preset degrees for the opening and closing of the claw
    public static final double open = 0.25;
    public static final double close = 0.0;

    //define the resting position.
    final double wristHorizontalPos = 0.0;
    final double wristVerticalPos = 0.25;
    private boolean lastState;

    private OpMode opMode;

    //constructor which acts as an initialization function for whenever an object of the class is created
    public Intake(OpMode linearopmode){
        this.opMode = linearopmode;
        claw = opMode.hardwareMap.get(Servo.class, "claw");
        wrist = opMode.hardwareMap.get(Servo.class, "wrist");
    }

    //sets the open or close mode of the claw
    public void mode(double servoPos) {
        claw.setPosition(servoPos);
        opMode.telemetry.addData("claw position", servoPos);
    }

    //lets the passed in gamepad control the wrist
    public void controlWrist(Gamepad gamepad) {
        //since restingPos is 0.5, max position to the left would be 0.5 + -0.5 resulting in zero and 0.5 + 0.5
        //would result in one
        double servoTarget = (gamepad.right_stick_x * 0.5);
        wrist.setPosition(servoTarget);
    }

    public void shouldToggle(boolean currentBtnState)
    {
        if(currentBtnState && !lastState) {
            lastState = true;

            wrist.setPosition(wristHorizontalPos);
        }
        else if (!currentBtnState) {
            lastState = false;
        }
        wrist.setPosition(wristVerticalPos);
    }

//    public void toggleWristPosition(Gamepad gamepad) {
//        if (!wristHorizontal && gamepad.x) {
//            wrist.setPosition(wristHorizontalPos);
//            wristHorizontal= true;
//        }
//        else if (wristHorizontal && gamepad.x) {
//            wrist.setPosition(wristVerticalPos);
//            wristHorizontal = false;
//        }
//    }

    //returns the wrist to resting position
    public void setRestingPos() {
        wrist.setPosition(wristHorizontalPos);
    }
}