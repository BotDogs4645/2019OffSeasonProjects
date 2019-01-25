public class Gryo extends Subsystem {
  public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  private WPI_TalonSRX motor = new WPI_TalonSRX(10);
  public double finalAngle;
  int count = 0;
  
  public void changeAngularPosition(double pFinalAngle) {
    SmartDashboard.putNumber("current angle", gyro.getAngle());
    System.out.println("Current angle: " + gyro.getAngle());
    SmartDashboard.putNumber("current rate", gyro.getRate());
    System.out.println("Current rate: " + gyro.getRate());
    count++;
    finalAngle = pFinalAngle;
    SmartDashboard.putNumber("final angle", finalAngle);
    SmartDashboard.putNumber("count", count);
    System.out.println("Count: " + count);
    SmartDashboard.putBoolean("gyro connected", gyro.isConnected());
    System.out.println("Gyro connected: " + gyro.isConnected());
/*  
    double currentAngle = gyro.getAngle();
    double angleChange = finalAngle - currentAngle;
    if (angleChange > 0.0) {
      if(currentAngle < finalAngle) {
        motor.set(0.50);
        currentAngle = gyro.getAngle();
      }  
    }
    else if (angleChange < 0.0) {
      if(currentAngle > finalAngle) {
        motor.set(-0.50);
        currentAngle = gyro.getAngle();
      }  
    }
    else if (currentAngle == finalAngle) {
      motor.set(0.0);
    }
    */
  }

  public boolean angleIsReached(){
    return gyro.getAngle() == finalAngle;
  }
  public void reset() {
    gyro.reset();
  } 

  @Override
  public void initDefaultCommand() { 
  }
}
