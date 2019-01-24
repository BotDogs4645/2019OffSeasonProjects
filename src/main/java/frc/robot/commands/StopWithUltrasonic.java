package frc.robot.commands;



import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.UltrasonicSensor;

/**
 *
 */
public class StopWithUltrasonic extends Command {

    public StopWithUltrasonic() {
    	requires(Robot.ultrasonicob);
    	requires(Robot.motorob);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.motorob.goForward();
        //SmartDashboard.getNumber("ultrasonic sensor", Robot.ultrasonicob.getDistance());
        System.out.println(Robot.ultrasonicob.getDistance());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (35 <= Robot.ultrasonicob.getDistance());
        
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}