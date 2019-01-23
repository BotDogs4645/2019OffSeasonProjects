/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.OI;
import frc.robot.commands.DriveCommand;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 * 
 * @param <WPI_TalonSRX>
 */
public class MecanumDriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public WPI_TalonSRX frontLeft = new WPI_TalonSRX(1);
  public WPI_TalonSRX rearLeft = new WPI_TalonSRX(2);
  public WPI_TalonSRX frontRight = new WPI_TalonSRX(3);
  public WPI_TalonSRX rearRight = new WPI_TalonSRX(4);
  MecanumDrive mecDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveCommand());
  }

  public void driveWithJoystick()
  {
    mecDrive.driveCartesian(OI.joy.getY()*0.50, OI.joy.getX()*0.50, OI.joy.getZ()*0.50);
  }

  public void stop()
  {
    frontLeft.set(0);
    rearLeft.set(0);
    frontRight.set(0);
    rearRight.set(0);
  }
}
