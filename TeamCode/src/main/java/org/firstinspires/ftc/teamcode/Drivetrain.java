package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Drivetrain {

    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor frontRight;
    private DcMotor backRight;

    public Drivetrain(HardwareMap hardwareMap)
    {
        frontLeft = hardwareMap.get(DcMotor.class, "frontleft");
        backLeft = hardwareMap.get(DcMotor.class, "backleft");
        frontRight = hardwareMap.get(DcMotor.class, "frontright");
        backRight = hardwareMap.get(DcMotor.class, "backright");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
    }

    public void drive(Gamepad gamepad)
    {
        double y = -gamepad.left_stick_y;
        double x = gamepad.left_stick_x * 1.1;
        double rx = gamepad.right_stick_x;

        double maxSpeed = 0.5;
        double maxSpeedMultiplier;

        maxSpeedMultiplier = maxSpeed + ((-gamepad.right_trigger * (maxSpeed * 0.7)) + (gamepad.left_trigger * maxSpeed));
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        frontLeft.setPower(frontLeftPower * maxSpeedMultiplier);
        backLeft.setPower(backLeftPower * maxSpeedMultiplier);
        frontRight.setPower(frontRightPower * maxSpeedMultiplier);
        backRight.setPower(backRightPower * maxSpeedMultiplier);
    }
}
