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

        //move to the bucket (untested)
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
        sleep(300);
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



        //rotate arm and Score Sample(untested)
        arm.moveArm(75);
        sleep(100);
        arm.moveViperslides(34);
        sleep(6000);
        intake.mode(Intake.open);
        sleep(100);
        drivetrain.frontLeft.setPower(-1);
        drivetrain.frontRight.setPower(-1);
        drivetrain.backLeft.setPower(-1);
        drivetrain.backRight.setPower(-1);
        sleep(80);
        arm.moveViperslides(0);
        sleep(6000);
        arm.moveArm(15);
        sleep(2000);
        


        //pick up the rightmost sample from drive team perspective(untested)
        drivetrain.frontLeft.setPower(1);
        drivetrain.frontRight.setPower(-1);
        drivetrain.backLeft.setPower(1);
        drivetrain.backRight.setPower(-1);
        sleep(120);
        drivetrain.frontLeft.setPower(0);
        drivetrain.frontRight.setPower(0);
        drivetrain.backLeft.setPower(0);
        drivetrain.backRight.setPower(0);
        sleep(10);
        drivetrain.frontLeft.setPower(1);
        drivetrain.frontRight.setPower(-1);
        drivetrain.backLeft.setPower(-1);
        drivetrain.backRight.setPower(1);
        sleep(80);
        arm.moveArm(5);
        sleep(500)
        intake.mode(Intake.close);
    }
}
