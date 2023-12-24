package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;

public class SwerveModule{
    private TalonFX throttle;
    private TalonFX rotor;
    private CANCoder encoder;
    private double encoderOffset;
    private PIDController rotorPID = new PIDController(0.012, 0, 0);

    public SwerveModule(int throttleID, int rotorID, int CanCoderID, double encoderOffset){
        throttle = new TalonFX(throttleID);
        rotor = new TalonFX(rotorID);
        encoder = new CANCoder(CanCoderID);
        this.encoderOffset = encoderOffset;
        setup();
    }

    public SwerveModuleState getState(){
        return new SwerveModuleState(
            throttle.getActiveTrajectoryVelocity() * Constants.kThrottleVelocity,
            Rotation2d.fromDegrees(encoder.getAbsolutePosition())
        );
    }

    public void setState(SwerveModuleState state){
        double throttleOutput = state.speedMetersPerSecond / Constants.kMaxThrottleSpeed;
        double roborOutput = rotorPID.calculate(getState().angle.getDegrees(), state.angle.getDegrees());
        throttle.set(TalonFXControlMode.PercentOutput,throttleOutput);
        rotor.set(TalonFXControlMode.PercentOutput,-roborOutput);
    }

    private void setup(){
        throttle.configFactoryDefault();
        rotor.configFactoryDefault();
        encoder.configFactoryDefault();
        throttle.setNeutralMode(NeutralMode.Brake);
        rotor.setNeutralMode(NeutralMode.Brake);
        encoder.configAbsoluteSensorRange(AbsoluteSensorRange.Signed_PlusMinus180);
        encoder.configMagnetOffset(encoderOffset);
        encoder.configSensorInitializationStrategy(SensorInitializationStrategy.BootToAbsolutePosition);
        rotorPID.enableContinuousInput(-180, 180);
    }
}
