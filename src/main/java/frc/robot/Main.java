//url
//https://maven.ctr-electronics.com/release/com/ctre/phoenix/Phoenix5-frc2023-latest.json
//https://dev.studica.com/releases/2023/NavX.json

package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

public final class Main {
  private Main() {}
  
  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}
