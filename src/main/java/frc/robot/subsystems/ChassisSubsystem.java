package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class ChassisSubsystem implements Subsystem {

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

    /**
     * The Singleton instance of this chassisSubsystem. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private final static ChassisSubsystem INSTANCE = new ChassisSubsystem();
    private WPI_VictorSPX  leftFront_tank, leftBack_tank, rightFront_tank, rightBack_tank;


    /**
     * Returns the Singleton instance of this chassisSubsystem. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code chassisSubsystem.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static ChassisSubsystem getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new instance of this chassisSubsystem. This constructor
     * is private since this class is a Singleton. Code should use
     * the {@link #getInstance()} method to get the singleton instance.
     */
    private ChassisSubsystem() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        leftFront_tank = new WPI_VictorSPX(RobotMap.Tank.leftFrontMotor);
        leftBack_tank = new WPI_VictorSPX(RobotMap.Tank.leftBackMotor);
        rightBack_tank = new WPI_VictorSPX(RobotMap.Tank.rightBackMotor);
        rightFront_tank = new WPI_VictorSPX(RobotMap.Tank.rightFrontMotor);
        
        leftBack_tank.follow(leftFront_tank);
        rightBack_tank.follow(rightFront_tank);

        rightBack_tank.setInverted(true);
        rightFront_tank.setInverted(false);

        leftBack_tank.setInverted(true);
        leftFront_tank.setInverted(false);
    }

    public void rightSet (double speed) {
        if (speed <= 0.03) return;
        rightFront_tank.set(speed);
    }

    public void leftSet (double speed) {
        if (speed <= 0.03) return;
        leftFront_tank.set(speed);
    }
}

