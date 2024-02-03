package org.firstinspires.ftc.teamcode.drive.opmode.autonomous.CenterStage;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
@Autonomous(name = "redFront auto")
@Config
public class redFront extends LinearOpMode {


    // beginning placement of robot
    private final Pose2d redFrontStart = new Pose2d(12,-60, Math.toRadians(-90));
    private final Pose2d redFrontEnd = new Pose2d(48, -58, Math.toRadians(0));


    // drive forward 2 feet from start
    private final Pose2d centerOfLines = new Pose2d(12, -36, Math.toRadians(-90));


    // the poses for the lines on the ground


    private final Pose2d leftLine = new Pose2d(0, -32, Math.toRadians(0));
    private final Pose2d rightLine = new Pose2d(24, -32, Math.toRadians(0));
    private final Pose2d centerLine = new Pose2d(12, -24.5, Math.toRadians(-90));


    private int _pose;


    SampleMecanumDrive drive;


    @Override
    public void runOpMode() throws InterruptedException {
        drive.initArm();


        drive = new SampleMecanumDrive(hardwareMap);


        drive.setPoseEstimate(redFrontStart);
        if (_pose == 0) {
            drive.setPoseEstimate(redFrontStart);
            TrajectorySequence placePurpleBack = drive.trajectorySequenceBuilder(redFrontStart)
                    .lineToSplineHeading(leftLine)
                    .build();
            drive.followTrajectorySequence(placePurpleBack);
            drive.setFrontGrip(false);
            sleep(1000);
            TrajectorySequence gotoback = drive.trajectorySequenceBuilder(leftLine)
                    .lineToSplineHeading(redFrontEnd)
                    .build();
            drive.followTrajectorySequence(gotoback);


        }

        else if (_pose == 1) {
            drive.setPoseEstimate(redFrontStart);
            TrajectorySequence placePurpleBack = drive.trajectorySequenceBuilder(redFrontStart)
                    .lineToSplineHeading(centerLine)
                    .build();
            drive.followTrajectorySequence(placePurpleBack);
            drive.setFrontGrip(false);
            sleep(1000);
            TrajectorySequence gotoback = drive.trajectorySequenceBuilder(centerLine)
                    .lineToSplineHeading(redFrontEnd)
                    .build();
            drive.followTrajectorySequence(gotoback);
        }

        else if (_pose == 2) {
            drive.setPoseEstimate(redFrontStart);
            TrajectorySequence placePurpleBack = drive.trajectorySequenceBuilder(redFrontStart)
                    .lineToSplineHeading(rightLine)
                    .build();
            drive.followTrajectorySequence(placePurpleBack);
            drive.setFrontGrip(false);
            sleep(1000);
            TrajectorySequence gotoback = drive.trajectorySequenceBuilder(rightLine)
                    .lineToSplineHeading(redFrontEnd)
                    .build();
            drive.followTrajectorySequence(gotoback);

        }



    }
}

