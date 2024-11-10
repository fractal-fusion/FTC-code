package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Arm {

    private double clampDouble(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    DcMotor armRotationLeft;
    DcMotor armRotationRight;
    DcMotor viperslideLeft;
    DcMotor viperslideRight;

    //36.2mm
    private final double pulleyDiameterInches = 1.425197;
    private final double encoderPulsesPerRevolution = 537.7;
    private final double gearReduction = 0.0;

    private final double viperslideMaxInches = 38.4;
    private final double viperslideSpeedInchesPerSecond = 2;

    private final double getEncoderTicksPerDegrees = 19.7924893140647;
    private final double encoderTicksPerInches = (encoderPulsesPerRevolution * gearReduction)
                                                / (pulleyDiameterInches * Math.PI);

    public Arm(HardwareMap hardwareMap) {
        armRotationLeft = hardwareMap.get(DcMotor.class, "armleft");
        armRotationRight = hardwareMap.get(DcMotor.class, "armright");
        viperslideLeft = hardwareMap.get(DcMotor.class, "viperleft");
        viperslideRight = hardwareMap.get(DcMotor.class, "viperright");

        armRotationLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armRotationRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        viperslideLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        viperslideRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        armRotationLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        viperslideLeft.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public void controlViperslides(Gamepad gamepad) {
        double extension_factor = clampDouble(gamepad.left_stick_y, 0, 1);
        int target = (int) (extension_factor * (encoderTicksPerInches * (viperslideMaxInches - 5) ));

        viperslideLeft.setTargetPosition(target);
        viperslideRight.setTargetPosition(target);

        viperslideLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        viperslideRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //sets the power of the motors so that it moves the speed of how many inches per second specified
        ((DcMotorEx) viperslideLeft).setVelocity(encoderTicksPerInches * viperslideSpeedInchesPerSecond);
        ((DcMotorEx) viperslideRight).setVelocity(encoderTicksPerInches * viperslideSpeedInchesPerSecond);
    }
}
