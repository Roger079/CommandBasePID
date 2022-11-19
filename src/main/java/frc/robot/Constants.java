// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
   
    // Idk if this Drivetrain stuff needs to be here
    public final class Drivetrain {
        public static final int upperRightMotorPort = 2;
        public static final int lowerRightMotorPort = 1;
        public static final int upperLeftMotorPort = 3;
        public static final int lowerLeftMotorPort = 4;

        public static final boolean isRightInverted = false;
        public static final boolean isLeftInverted = true;

        public static final double kP = .037;
        public static final double kI = 0;
        public static final double kD = 0.004;
        public static final double toleranceAngle = 3;
        public static final double tolerancedVelocity = 2;

    }

        
        

    // Add the VictorIDs here
}


