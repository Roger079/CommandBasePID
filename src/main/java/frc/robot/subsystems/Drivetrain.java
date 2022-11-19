// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import static frc.robot.Constants.Drivetrain.*;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;

public class Drivetrain extends SubsystemBase {
  private final WPI_VictorSPX leftUpperMotor = new WPI_VictorSPX(upperLeftMotorPort);
  private final WPI_VictorSPX leftLowerMotor = new WPI_VictorSPX(lowerLeftMotorPort);
  private final WPI_VictorSPX rightUpperMotor = new WPI_VictorSPX(upperRightMotorPort);
  private final WPI_VictorSPX rightLowerMotor = new WPI_VictorSPX(lowerRightMotorPort);

  private final MotorControllerGroup rightMotors = new MotorControllerGroup(rightUpperMotor, rightLowerMotor);
  private final MotorControllerGroup leftMotors = new MotorControllerGroup(leftLowerMotor, leftUpperMotor);

  private final DifferentialDrive diffDrive = new DifferentialDrive(rightMotors, leftMotors);
  
  private final AHRS NavX = new AHRS(Port.kMXP);

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    rightMotors.setInverted(isRightInverted);
    leftMotors.setInverted(isLeftInverted);
  }
  
  public void drive(double x, double y){
    diffDrive.arcadeDrive(x,y);
  }
  public double getAngle(){
    return NavX.getAngle();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("AngleInformation", getAngle());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
