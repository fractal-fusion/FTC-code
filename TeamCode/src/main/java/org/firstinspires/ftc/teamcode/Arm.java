package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Arm {
    //utility function
    private double clampDouble(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    //define motors
    private DcMotor armRotationLeft;
    private DcMotor armRotationRight;
    private DcMotor viperslideLeft;
    private DcMotor viperslideRight;

    //36.2mm
    private final double pulleyDiameterInches = 1.425197;

    //encoder resolution used to calculate conversion factors
    private final double extensionEncoderPulsesPerRevolution = 537.7;
    private final double rotationEncoderPulsesPerRevolution = 	1993.6;

    //gear ratios used to calculate conversion factors
    private final double rotationGearReduction = 5.0;
    private final double extensionGearReduction = 1.0;

    //viperslide constants used in extension
    private double viperslideMaxInches = 35.5;
    private final double viperslideSpeedInchesPerSecond = 8.5;

    //the amount of inches or degrees to increment on each run of the opmode loop
    private final double viperslideIncrementInches = 0.1;
    private final double rotationIncrementDegrees = 0.5;

    //Subtracted from the max inches of the viperslide to limit its extension
    private final double viperLimit = 5.0;
    //running total of viperslide inches and rotation degrees to hold them in place
    //when there are no joystick inputs
    private double viperslideIncrementTotalInches = 0.0;
    private double rotationIncrementTotalDegrees = 0.0;

    //rotation angle variable
    private double rotationAngle;

//    private final double rotationIncrementDegrees = 0.5;
//    double rotationIncrementTotalDegrees = 0.0;

    //calculate conversion factors
    private final double encoderTicksPerDegrees = (rotationEncoderPulsesPerRevolution * rotationGearReduction)
                                                / (360);
    private final double encoderTicksPerInches = (extensionEncoderPulsesPerRevolution * extensionGearReduction)
                                                / (pulleyDiameterInches * Math.PI);

    //define preset positions of the arm.
    public final static double clearBarrierDegrees = 15.0;
    public final static double scoreBucketDegrees = 75.0;
    public final static double hangExtendedDegrees = 110.0;
    public final static double hangClimbDegrees = 15.0;
    public final static double collectionDegrees = 4.0;
//    public final static double restingDegrees = 10.0;

    private OpMode opMode;

    //constructor which acts as an initialization function for whenever an object of the class is created
    public Arm(OpMode linearopmode) {
        this.opMode = linearopmode;
        armRotationLeft = opMode.hardwareMap.get(DcMotor.class, "armleft");
        armRotationRight = opMode.hardwareMap.get(DcMotor.class, "armright");
        viperslideLeft = opMode.hardwareMap.get(DcMotor.class, "viperleft");
        viperslideRight = opMode.hardwareMap.get(DcMotor.class, "viperright");

        armRotationLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armRotationRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        viperslideLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        viperslideRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        armRotationLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        armRotationRight.setDirection(DcMotorSimple.Direction.FORWARD);

        viperslideLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        viperslideRight.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    //main function which controls extension of the viperslides.
    public void controlViperslides(Gamepad gamepad) {
        //old method of extension that does not hold the position of the viperslide on release of the joystick

        //double extension_factor = clampDouble(gamepad.left_stick_y, 0.0, 1.0);
        // int target = (int) (extension_factor * (encoderTicksPerInches * (viperslideMaxInches - viperLimit) ));

        //mathematical software viperslide extension limitation attempt
//        viperslideMaxInches = 42/Math.cos(rotationAngle);

        //restrict the horizontal extension
        if (rotationAngle < 75) {
            viperslideMaxInches = 15.0;
        }
        else {
            viperslideMaxInches = 35.5;
        }

        //new method with a running total which holds the position of the viperslide
        viperslideIncrementTotalInches += -gamepad.left_stick_y * viperslideIncrementInches;
        viperslideIncrementTotalInches = clampDouble(viperslideIncrementTotalInches, 0.0, viperslideMaxInches);
        int target = (int) (viperslideIncrementTotalInches * encoderTicksPerInches);

        viperslideLeft.setTargetPosition(target);
        viperslideRight.setTargetPosition(target);

        //sets the power of the motors so that it moves the speed of how many inches per second specified, multiplied by the speed multiplier
//        ((DcMotorEx) viperslideLeft).setVelocity(encoderTicksPerInches * (viperslideSpeedInchesPerSecond * maxSpeedMultiplier));
//        ((DcMotorEx) viperslideRight).setVelocity(encoderTicksPerInches * (viperslideSpeedInchesPerSecond * maxSpeedMultiplier));

        viperslideLeft.setPower(1.0);
        viperslideRight.setPower(1.0);

        viperslideLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        viperslideRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        opMode.telemetry.addData("viperslide target: ", target);
        opMode.telemetry.addData("viperslide inches: ", viperslideIncrementTotalInches);
        opMode.telemetry.addData("viperslide max inches", viperslideMaxInches);
        opMode.telemetry.update();
    }

    public void moveViperslides(double inches) {
        int target = (int) (inches * encoderTicksPerInches);

        viperslideLeft.setTargetPosition(target);
        viperslideRight.setTargetPosition(target);

        viperslideLeft.setPower(1.0);
        viperslideRight.setPower(1.0);

        viperslideLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        viperslideRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    //main function for controlling the position of the arm in degrees.
    public void moveArm(double degrees) {
        rotationAngle = degrees;
        int target = (int) (rotationAngle * encoderTicksPerDegrees);
        armRotationLeft.setTargetPosition(target);
        armRotationRight.setTargetPosition(target);

        armRotationLeft.setPower(0.7);
        armRotationRight.setPower(0.7);

        armRotationLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armRotationRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    // manual arm controls
//    public void controlArm(Gamepad gamepad) {
//        rotationIncrementTotalDegrees += rotationIncrementDegrees * (gamepad.left_trigger + -gamepad.right_trigger);
//        rotationIncrementTotalDegrees = clampDouble(rotationIncrementTotalDegrees, 0.0, 110.0);
//        int target = (int) (rotationIncrementTotalDegrees * encoderTicksPerDegrees);
//        armRotationLeft.setTargetPosition(target);
//        armRotationRight.setTargetPosition(target);
//
//        ((DcMotorEx) armRotationLeft).setVelocity(2100);
//        ((DcMotorEx) armRotationRight).setVelocity(2100);
//
//        armRotationLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        armRotationRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//        opMode.telemetry.addData("arm degrees: ", rotationAngle);
//        opMode.telemetry.addData("arm target: ", target);
//        opMode.telemetry.update();
//    }

//    public void controlArm(Gamepad gamepad) {
//
//    }
}
