package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Left Side Auto Macro", group="Robot")
public class autoLeftMacro extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Drivetrain drivetrain = new Drivetrain(this);
        Intake intake = new Intake(this);
        Arm arm = new Arm(this);

        waitForStart();

        //grab sample
        //intake.mode(Intake.close);
        //sleep(1500);
        arm.moveArm(Arm.collectionDegrees);
        sleep(2000);

        //move to the bucket (tested)
        //forward
        drivetrain.frontLeft.setPower(1);
        drivetrain.frontRight.setPower(1);
        drivetrain.backLeft.setPower(1);
        drivetrain.backRight.setPower(1);
        sleep(145);
        drivetrain.frontLeft.setPower(0);
        drivetrain.frontRight.setPower(0);
        drivetrain.backLeft.setPower(0);
        drivetrain.backRight.setPower(0);
        sleep(10);
        //strafe left
        drivetrain.frontLeft.setPower(-1);
        drivetrain.frontRight.setPower(1);
        drivetrain.backLeft.setPower(1);
        drivetrain.backRight.setPower(-1);
        sleep(400);
        drivetrain.frontLeft.setPower(0);
        drivetrain.frontRight.setPower(0);
        drivetrain.backLeft.setPower(0);
        drivetrain.backRight.setPower(0);
        sleep(100);
        //rotate left
        drivetrain.frontLeft.setPower(-0.8);
        drivetrain.frontRight.setPower(0.8);
        drivetrain.backLeft.setPower(-0.8);
        drivetrain.backRight.setPower(0.8);
        sleep(555);
        drivetrain.frontLeft.setPower(0);
        drivetrain.frontRight.setPower(0);
        drivetrain.backLeft.setPower(0);
        drivetrain.backRight.setPower(0);
        sleep(10);
        //move forward
        drivetrain.frontLeft.setPower(0.5);
        drivetrain.frontRight.setPower(0.5);
        drivetrain.backLeft.setPower(0.5);
        drivetrain.backRight.setPower(0.5);
        sleep(35);
        drivetrain.frontLeft.setPower(0);
        drivetrain.frontRight.setPower(0);
        drivetrain.backLeft.setPower(0);
        drivetrain.backRight.setPower(0);
        //rotate viper slides
        arm.moveArm(Arm.scoreBucketDegrees);
        sleep(2000);
        //extend slides
        arm.moveViperslides(34);
        sleep(3000);
        //intake.mode(Intake.open);
        //sleep(1000);
        //de-extend slides
        arm.moveViperslides(0);
        sleep(2000);
        //rotate right
        drivetrain.frontLeft.setPower(0.8);
        drivetrain.frontRight.setPower(-0.8);
        drivetrain.backLeft.setPower(0.8);
        drivetrain.backRight.setPower(-0.8);
        sleep(555);
        drivetrain.frontLeft.setPower(0);
        drivetrain.frontRight.setPower(0);
        drivetrain.backLeft.setPower(0);
        drivetrain.backRight.setPower(0);
        sleep(20);
        drivetrain.frontLeft.setPower(0.8);
        drivetrain.frontRight.setPower(-0.8);
        drivetrain.backLeft.setPower(0.8);
        drivetrain.backRight.setPower(-0.8);
        sleep(100);
        drivetrain.frontLeft.setPower(0);
        drivetrain.frontRight.setPower(0);
        drivetrain.backLeft.setPower(0);
        drivetrain.backRight.setPower(0);
        sleep(30);
        //go forward towards sample
        drivetrain.frontLeft.setPower(1);
        drivetrain.frontRight.setPower(1);
        drivetrain.backLeft.setPower(1);
        drivetrain.backRight.setPower(1);
        sleep(200);
        drivetrain.frontLeft.setPower(0);
        drivetrain.frontRight.setPower(0);
        drivetrain.backLeft.setPower(0);
        drivetrain.backRight.setPower(0);
        sleep(20);
        //untested
        arm.moveArm(Arm.collectionDegrees);
        sleep(2000);
        drivetrain.frontLeft.setPower(-0.8);
        drivetrain.frontRight.setPower(0.8);
        drivetrain.backLeft.setPower(-0.8);
        drivetrain.backRight.setPower(0.8);
        sleep(200);
        drivetrain.frontLeft.setPower(0);
        drivetrain.frontRight.setPower(0);
        drivetrain.backLeft.setPower(0);
        drivetrain.backRight.setPower(0);
        sleep(10);




////        sleep(6000);
////        arm.moveArm(15);
////        sleep(2000);



        //pick up the rightmost sample from drive team perspective(untested)
//        drivetrain.frontLeft.setPower(1);
//        drivetrain.frontRight.setPower(-1);
//        drivetrain.backLeft.setPower(1);
//        drivetrain.backRight.setPower(-1);
//        sleep(120);
//        drivetrain.frontLeft.setPower(0);
//        drivetrain.frontRight.setPower(0);
//        drivetrain.backLeft.setPower(0);
//        drivetrain.backRight.setPower(0);
//        sleep(10);
//        drivetrain.frontLeft.setPower(1);
//        drivetrain.frontRight.setPower(-1);
//        drivetrain.backLeft.setPower(-1);
//        drivetrain.backRight.setPower(1);
//        sleep(80);
//        drivetrain.frontLeft.setPower(0);
//        drivetrain.frontRight.setPower(0);
//        drivetrain.backLeft.setPower(0);
//        drivetrain.backRight.setPower(0);
//        sleep(10);
//        arm.moveArm(4);
//        sleep(500);
//        intake.mode(Intake.close);

    }
};