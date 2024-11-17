package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="strafe right", group="Robot")
public class autoRight extends LinearOpMode {
    Drivetrain drivetrain = new Drivetrain(this);

    @Override
    public void runOpMode() throws InterruptedException {
        drivetrain.frontLeft.setPower(-1);
        drivetrain.frontRight.setPower(1);
        drivetrain.backLeft.setPower(-1);
        drivetrain.backRight.setPower(1);

        sleep(200);
    }
}
