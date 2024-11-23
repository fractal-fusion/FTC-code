package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Right Auto", group="Robot")
public class autoRight extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Drivetrain drivetrain = new Drivetrain(this);
        Intake intake = new Intake(this);
        Arm arm = new Arm(this);


        //grab sample
        intake.mode(Intake.close);

        //move to the bucket (unfinished)
        drivetrain.frontLeft.setPower(1);
        drivetrain.frontRight.setPower(1);
        drivetrain.backLeft.setPower(1);
        drivetrain.backRight.setPower(1);
        sleep(200);
        drivetrain.frontLeft.setPower(0);
        drivetrain.frontRight.setPower(0);
        drivetrain.backLeft.setPower(0);
        drivetrain.backRight.setPower(0);
        sleep(10);
        drivetrain.frontLeft.setPower(-1);
        drivetrain.frontRight.setPower(1);
        drivetrain.backLeft.setPower(1);
        drivetrain.backRight.setPower(-1);
        sleep(1500);
        drivetrain.frontLeft.setPower(0);
        drivetrain.frontRight.setPower(0);
        drivetrain.backLeft.setPower(0);
        drivetrain.backRight.setPower(0);
        sleep(10);
        drivetrain.frontLeft.setPower(-1);
        drivetrain.frontRight.setPower(1);
        drivetrain.backLeft.setPower(-1);
        drivetrain.backRight.setPower(1);
        sleep(100);
        drivetrain.frontLeft.setPower(0);
        drivetrain.frontRight.setPower(0);
        drivetrain.backLeft.setPower(0);
        drivetrain.backRight.setPower(0);
        sleep(100);



        //rotate arm
//        arm.moveArm(75);
//        arm.moveViperslides(34);
//        sleep(7000);
//        intake.mode(Intake.open);
//        drivetrain.frontLeft.setPower(-1);
//        drivetrain.frontRight.setPower(-1);
//        drivetrain.backLeft.setPower(-1);
//        drivetrain.backRight.setPower(-1);
//        sleep(200);
//        arm.moveViperslides(0);
//        sleep(7000);
//        arm.moveArm(10);
//        sleep(2000);
    }
}
