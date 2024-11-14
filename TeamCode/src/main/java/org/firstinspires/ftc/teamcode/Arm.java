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

    private final double extensionEncoderPulsesPerRevolution = 537.7;
    private final double rotationEncoderPulsesPerRevolution = 	1993.6;

    private final double rotationGearReduction = 5.0;
    private final double extensionGearReduction = 1.0;

    private final double viperslideMaxInches = 38.4;
    private final double viperslideSpeedInchesPerSecond = 2.0;
    //Subtracted from the max inches of the viperslide to limit its extension
    private final double viperLimit = 5.0;

    private final double encoderTicksPerDegrees = (rotationEncoderPulsesPerRevolution * rotationGearReduction)
                                                / (360);
    private final double encoderTicksPerInches = (extensionEncoderPulsesPerRevolution * extensionGearReduction)
                                                / (pulleyDiameterInches * Math.PI);
    public final static double collectionDegrees = 15.0;
    public final static double scoreBucketDegrees = 75.0;
    //probably not accurate values
    public final static double hangExtendedDegrees = 120.0;
    public final static double hangClimbDegrees = 0.0;

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
        double extension_factor = clampDouble(gamepad.left_stick_y, 0.0, 1.0);
        int target = (int) (extension_factor * (encoderTicksPerInches * (viperslideMaxInches - viperLimit) ));

        viperslideLeft.setTargetPosition(target);
        viperslideRight.setTargetPosition(target);

        viperslideLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        viperslideRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //sets the power of the motors so that it moves the speed of how many inches per second specified
        ((DcMotorEx) viperslideLeft).setVelocity(encoderTicksPerInches * viperslideSpeedInchesPerSecond);
        ((DcMotorEx) viperslideRight).setVelocity(encoderTicksPerInches * viperslideSpeedInchesPerSecond);
    }

    public void moveArm(double degrees) {
        int target = (int) (degrees * encoderTicksPerDegrees);
        armRotationLeft.setTargetPosition(target);
        armRotationRight.setTargetPosition(target);

        armRotationLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armRotationRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}
