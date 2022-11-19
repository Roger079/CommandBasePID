package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.Drivetrain;

import static frc.robot.Constants.Drivetrain.*;



/** A command that will turn the robot to the specified angle. */
public class TurnToAngle extends PIDCommand {
  /**
   * Turns to robot to the specified angle.
   *
   * @param targetAngleDegrees The angle to turn to
   * @param drivetrain The drive subsystem to use
   */
  public TurnToAngle(double targetAngleDegrees, Drivetrain drivetrain) {
    super(
        new PIDController(kP, kI, kD),
        // Close loop on heading
        drivetrain::getAngle,
        // Set reference to target
        targetAngleDegrees,
        // Pipe output to turn robot
        output -> drivetrain.drive(0, output),
        // Require the drive
        drivetrain);

    // Set the controller to be continuous (because it is an angle controller)
    getController().enableContinuousInput(-180, 180);
    // Set the controller tolerance - the delta tolerance ensures the robot is stationary at the
    // setpoint before it is considered as having reached the reference
    getController()
        .setTolerance(toleranceAngle, tolerancedVelocity);
  }

  @Override
  public boolean isFinished() {
    // End when the controller is at the reference.
    return getController().atSetpoint();
  }
}