/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.OI;
import frc.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class MecanumDriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public WPI_TalonSRX motorL1 = new WPI_TalonSRX(4); //where argument is port #
  public WPI_TalonSRX motorL2 = new WPI_TalonSRX(3);
  public WPI_TalonSRX motorR1 = new WPI_TalonSRX(2); // always use WPI_TalonSRX for the motors!
  public WPI_TalonSRX motorR2 = new WPI_TalonSRX(4);

  MecanumDrive mecDrive = new MecanumDrive(motorL1, motorL2, motorR1, motorR2);


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveCommand());
  }

  public void init() {
  }

  public void driveWithJoystick() {
    double forward = OI.joystick.getY() * 0.2; // don't go too fast! multiply by 0.2. forward = speed
    double turn = OI.joystick.getZ() * 0.2;
    double x = OI.joystick.getX() * 0.2;

    /*if(Math.abs(forward) < 0.20) 
        forward = 0;

    if(Math.abs(turn) < 20) 
        turn = 0; */

    SmartDashboard.putNumber("Joystick Y:", forward);
    SmartDashboard.putNumber("Joystick Z:", turn);
    SmartDashboard.putNumber("Joystick X:", x);

    mecDrive.driveCartesian(forward, x, turn);
  }

  public void stop() {
    motorL1.set(0);
    motorL2.set(0);
    motorR1.set(0);
    motorR2.set(0);
  }
}
