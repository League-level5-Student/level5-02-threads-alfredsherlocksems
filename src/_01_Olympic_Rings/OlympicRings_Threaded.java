package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main (String [] args) {
		OlympicRings_Threaded d = new OlympicRings_Threaded();
		Robot[] robots;
		robots = new Robot[5];
		robots[0] = new Robot(200, 700);
		robots[1] = new Robot(400, 700);
		robots[2] = new Robot(600, 700);
		robots[3] = new Robot(800, 700);
		robots[4] = new Robot(1000, 700);
		
		Thread one = new Thread(() -> d.drawCircle(robots[0 ]));
		Thread two = new Thread(() -> d.drawCircle(robots[1]));
		Thread three = new Thread(() -> d.drawCircle(robots[2 ]));
		Thread four = new Thread(() -> d.drawCircle(robots[3]));
		Thread five = new Thread(() -> d.drawCircle(robots[4 ]));
		one.start();
		two.start();
		three.start();
		four.start();
		five.start();
	}
	
	void drawCircle(Robot bob) {
		bob.setSpeed(10);
		bob.move(600);
		bob.penDown();
		int ang = -1;
		while (ang != -18) {
		bob.setAngle(ang);
		bob.move(5);
		ang = ang-3;
		}
		
		
		
	}
	
}

