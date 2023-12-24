package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;

public class Constants {
    public static final double kThrottleGarRatio = 6.12;
    public static final double kWheelDiametor = 4 * 0.0254;
    public static final double kMaxThrottleSpeed = 6380 / 60 / kThrottleGarRatio * kThrottleGarRatio * Math.PI;

    public static final double kMaxRotatinoSpeed = kMaxThrottleSpeed / Math.sqrt(2 * Math.pow(0.5, 2));

    public static final double kThrottleVelocity = kWheelDiametor * Math.PI / kThrottleGarRatio * 10 / 2048;

    public static final int A_THROTTKE_ID = 1;
    public static final int B_THROTTKE_ID = 5;
    public static final int C_THROTTKE_ID = 2;
    public static final int D_THROTTKE_ID = 7;

    public static final int A_ROTOR_ID = 4;
    public static final int B_ROTOR_ID = 11;
    public static final int C_ROTOR_ID = 8;
    public static final int D_ROTOR_ID = 10;

    public static final int A_ENCODER_ID = 3;
    public static final int B_ENCODER_ID = 0;
    public static final int C_ENCODER_ID = 1;
    public static final int D_ENCODER_ID = 2;

    public static final int A_OFFSET = -91;
    public static final int B_OFFSET = -154;
    public static final int C_OFFSET = 172;
    public static final int D_OFFSET = 145;

    public static final Translation2d A_TRANSLATION2D = new Translation2d(0.25,0.25);
    public static final Translation2d B_TRANSLATION2D = new Translation2d(-0.25,0.25);
    public static final Translation2d C_TRANSLATION2D = new Translation2d(-0.25,-0.25);
    public static final Translation2d D_TRANSLATION2D = new Translation2d(0.25,-0.25);

    public static final SwerveDriveKinematics SWERVE_KINEMATICS = new SwerveDriveKinematics(A_TRANSLATION2D, B_TRANSLATION2D, C_TRANSLATION2D, D_TRANSLATION2D);
}
