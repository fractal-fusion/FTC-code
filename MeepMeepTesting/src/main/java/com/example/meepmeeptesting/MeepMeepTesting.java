package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {

    public static void main(String[] args) {
        double tilelength = 23.5;

        MeepMeep meepMeep = new MeepMeep(700);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-tilelength, -61, Math.toRadians(90)))
                //TODO: close claw to grab sample
                //move to bucket
                .splineTo(new Vector2d(-52.5,-52.5), Math.toRadians(225))
                //TODO: move arm, extend viperslide and open claw to drop sample, then retract viperslides
                // and move back arm to collection position
                //turn to pick up first rightmost sample from drivers perspective
                .turnTo(Math.toRadians(90))
                //move to rightmost sample
                .strafeTo(new Vector2d(-48.2,-36.5))
                //TODO: close claw to grab sample
                //move to bucket
                .splineTo(new Vector2d(-52.5,-52.5), Math.toRadians(210))
                //TODO: move arm, extend viperslide and open claw to drop sample, then retract viperslides
                // and move back arm to collection position
                //turn to pick up the middle sample
                .turnTo(Math.toRadians(90))
                //move to middle sample
                .strafeTo(new Vector2d(-(2*tilelength+11),-37.1))
                //TODO: close claw to grab sample
                //move to bucket
                .splineTo(new Vector2d(-52.5,-52.5), Math.toRadians(245))
                //TODO: move arm, extend viperslide and open claw to drop sample, then retract viperslides
                // and move back arm to collection position
                //turn to pickup leftmost sample
                .turnTo(Math.toRadians(180))
                //move to leftmost sample
                .strafeTo(new Vector2d(-(2*tilelength+11),-27.5))
                //TODO: close claw to grab sample
                //move to basket
                .splineTo(new Vector2d(-52.5,-52.5), Math.toRadians(150))
                //TODO: move arm, extend viperslide and open claw to drop sample, then retract viperslides
                // and move back arm to collection position

                //park
                .strafeTo(new Vector2d(-28,0))
                .turnTo(Math.toRadians(0))
//                .lineToY(-55)
//                .turn(Math.toRadians(90))
//                .lineToX(-50)
//                .turn(Math.toRadians(45))
//                .turn(Math.toRadians(-135))
//                .lineToY(-35)
                //.linetoY
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}