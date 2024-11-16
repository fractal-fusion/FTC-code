package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="productionOpmode Meet 1", group="Robot")
public class productionOpmode extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        //initialize objects
        Drivetrain drivetrain = new Drivetrain(hardwareMap);
        Arm arm = new Arm(this);
        Intake intake = new Intake(hardwareMap);

        //set intake to resting position on init
        intake.setRestingPos();

        //telemetry to show the robot is initialized
        telemetry.addLine("Robot Ready.");
        telemetry.update();
        arm.moveArm(Arm.restingDegrees);
        waitForStart();

        while (opModeIsActive())
        {
            //gamepad 1 driving
            drivetrain.drive(gamepad1);

            //gamepad 2 arm
            arm.controlViperslides(gamepad2);
            intake.controlWrist(gamepad2);

            //preset positions for gamepad2
            if (gamepad2.dpad_down) {
                arm.moveArm(Arm.collectionDegrees);
            }
            else if (gamepad2.left_bumper) {
                arm.moveArm(Arm.clearBarrierDegrees);
            }
            else if (gamepad2.y) {
                arm.moveArm(Arm.scoreBucketDegrees);
            }
            //intake control
            else if (gamepad2.a) {
                intake.mode(Intake.close);
            }
            else if (gamepad2.b) {
                intake.mode(Intake.open);
            }
            //hanging control
            else if (gamepad2.dpad_left) {
                arm.moveArm(Arm.hangExtendedDegrees);
            }
            else if (gamepad2.dpad_right) {
                arm.moveArm(Arm.hangClimbDegrees);
            }

        }
    }
}
