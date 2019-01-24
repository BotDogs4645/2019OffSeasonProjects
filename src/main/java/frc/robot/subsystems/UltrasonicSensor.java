package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.StopWithUltrasonic;

/**
 *
 */
public class UltrasonicSensor extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	AnalogInput dSensor= new AnalogInput(2);
	public double getDistance()
	{
		double distance= dSensor.getVoltage();
		double distancemm= ((distance*1000)/4.88)*5;
		double distancecm= distancemm/10;
		return distancecm;
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new StopWithUltrasonic());
	
	}
}