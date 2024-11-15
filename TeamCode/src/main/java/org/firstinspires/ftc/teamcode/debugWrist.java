package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="debugWrist", group="Robot")

public class debugWrist extends LinearOpMode {

    public Servo wrist = null;
    public Servo claw = null;
    double servoposition = 0.5;
    public void runOpMode() {
        wrist  = hardwareMap.get(Servo.class, "wrist");
        claw = hardwareMap.get(Servo.class, "claw");
        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.x) {
                wrist.setPosition(0);
                claw.setPosition(0);
            }
            if (gamepad1.right_bumper) {
                servoposition += 0.1;
            }
            if (gamepad1.left_bumper) {
                servoposition -= 0.1;
            }

            wrist.setPosition(servoposition);
            claw.setPosition(servoposition);

            telemetry.addData("wrist position: ", wrist.getPosition());
            telemetry.update();
        }

    }

}
