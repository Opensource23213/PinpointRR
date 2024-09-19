package org.firstinspires.ftc.teamcode;


import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;

public class LimeLightTest extends LinearOpMode {
    public Limelight3A cam;

    @Override
    public void runOpMode() throws InterruptedException {
        cam = hardwareMap.get(Limelight3A.class, "limelight");
        telemetry.setMsTransmissionInterval(11);
        cam.pipelineSwitch(0);

        cam.start();

        while (opModeIsActive() && !isStopRequested()) {
            LLResult result = cam.getLatestResult();
            if (result != null && result.isValid()) {
                Pose3D botpose = result.getBotpose();
                Pose2d pose = new Pose2d(botpose.getPosition().x, botpose.getPosition().y, botpose.getOrientation().getYaw(AngleUnit.RADIANS));
            }

        }
    }
}
