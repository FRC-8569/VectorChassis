package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.SPI;

public class Chassis {
    private AHRS ahrs = new AHRS(SPI.Port.kMXP);
    private SwerveModule moduleA = new SwerveModule(Constants.A_THROTTKE_ID, Constants.A_ROTOR_ID, Constants.A_ENCODER_ID, Constants.A_OFFSET);
    private SwerveModule moduleB = new SwerveModule(Constants.B_THROTTKE_ID, Constants.B_ROTOR_ID, Constants.B_ENCODER_ID, Constants.B_OFFSET);
    private SwerveModule moduleC = new SwerveModule(Constants.C_THROTTKE_ID, Constants.C_ROTOR_ID, Constants.C_ENCODER_ID, Constants.C_OFFSET);
    private SwerveModule moduleD = new SwerveModule(Constants.D_THROTTKE_ID, Constants.D_ROTOR_ID, Constants.D_ENCODER_ID, Constants.D_OFFSET);

    public Chassis(){}

    public void drive(double xAxis, double yAxis, double rAxis){
        double xSpeed = xAxis * Constants.kMaxThrottleSpeed;
        double ySpeed = yAxis * Constants.kMaxThrottleSpeed;
        double rSpeed = rAxis * Constants.kMaxRotatinoSpeed;
        SwerveModuleState [] states = Constants.SWERVE_KINEMATICS.toSwerveModuleStates(
            ChassisSpeeds.fromFieldRelativeSpeeds(xSpeed, ySpeed, rSpeed, geRotation2d())
        );
        setModuleStates(states);
    }

    public void setModuleStates(SwerveModuleState [] status){
        moduleA.setState((status[0]));
        moduleB.setState((status[1]));
        moduleC.setState((status[2]));
        moduleD.setState((status[3]));
    }

    private Rotation2d geRotation2d(){
        return Rotation2d.fromDegrees(ahrs.getAngle());
    }
}
