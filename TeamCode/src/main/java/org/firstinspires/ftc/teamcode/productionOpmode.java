package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="productionOpmode Meet 1", group="Robot")
public class productionOpmode extends LinearOpMode {
    private double clampDouble(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }
    @Override
    public void runOpMode() throws InterruptedException {
        Drivetrain drivetrain = new Drivetrain(hardwareMap);
        Arm arm = new Arm(hardwareMap);
        double scoreDegrees = Arm.scoreBucketDegrees;
        double changeDegrees = 15 * clampDouble(gamepad2.left_trigger, 0, 1);
        double finalDegrees = scoreDegrees - changeDegrees;

        waitForStart();

        while (opModeIsActive())
        {
            drivetrain.drive(gamepad1);

            arm.controlViperslides(gamepad2);
            if (gamepad2.dpad_left)
            {
                arm.moveArm(0.0);
            }
            else if (gamepad2.left_bumper)
            {
                arm.moveArm(Arm.collectionDegrees);
            }
            else if (gamepad2.y)
            {
                arm.moveArm(finalDegrees);
            }



        }
    }
}
