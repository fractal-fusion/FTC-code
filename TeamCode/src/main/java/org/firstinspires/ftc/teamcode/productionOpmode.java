package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="productionOpmode Meet 1", group="Robot")
public class productionOpmode extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Drivetrain drivetrain = new Drivetrain(hardwareMap);
        Arm arm = new Arm(hardwareMap);

        waitForStart();

        while (opModeIsActive())
        {
            drivetrain.drive(gamepad1);

            arm.controlViperslides(gamepad2);
        }
    }
}
