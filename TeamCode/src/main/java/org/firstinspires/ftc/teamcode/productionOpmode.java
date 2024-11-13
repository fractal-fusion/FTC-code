package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="productionOpmode Meet 1", group="Robot")
public class productionOpmode extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Drivetrain drivetrain = new Drivetrain(hardwareMap);
        Arm arm = new Arm(hardwareMap);
        Intake intake = new Intake(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            drivetrain.drive(gamepad1);

            arm.controlViperslides(gamepad2);
            if (gamepad2.dpad_left)
            {
                arm.moveArm(0.0);
            } else if (gamepad2.left_bumper)
            {
                arm.moveArm(Arm.collectionDegrees);
            } else if (gamepad2.y)
            {
                arm.moveArm(Arm.scoreBucketDegrees);
            }
            if (gamepad2.a) {
                intake.mode(Intake.open);
            }
            else if (gamepad2.b) {
                intake.mode(Intake.close);
            }
        }

        }
    }

