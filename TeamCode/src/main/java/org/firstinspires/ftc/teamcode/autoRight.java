package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Right Auto", group="Robot")
public class autoRight extends LinearOpMode {
    Drivetrain drivetrain = new Drivetrain(this);
    Intake intake = new Intake(this);
    Arm arm = new Arm(this);
    @Override
    public void runOpMode() throws InterruptedException {
        //grab sample
        intake.mode(Intake.close);

        //move the bucket (unfinished)
        drivetrain.frontLeft.setPower(-1);
        drivetrain.frontRight.setPower(1);
        drivetrain.backLeft.setPower(-1);
        drivetrain.backRight.setPower(1);
        sleep(4000);
        drivetrain.frontLeft.setPower(0);
        drivetrain.frontRight.setPower(0);
        drivetrain.backLeft.setPower(0);
        drivetrain.backRight.setPower(0);

        //rotate arm
        arm.moveArm(75);

        //extend arm

    }
}
