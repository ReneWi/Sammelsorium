package protectionPattern;

public interface RealRobot {
void drive(double deltaPos);
double getCurrentPosition();
}
class ProxyRobot{
	private RealRobot realRobot = new RealRobot();
	private double maxPosition = 100.00;
	private double minPosition = 0.00;
	
	boolean driveSafely(double deltaPos){
		double currentPosition = realRobot.getCurrentPosition();
		double desiredPosition = currentPosition + deltaPos;
		if(desiredPosition <= maxPosition && desiredPosition >= minPosition ){
			robot.drive(deltaPos);
			return true;
		}else{
			System.out.println("Illegal Movement requested!");
			return false;
		}
	}
}
