package frc.robot.commands;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class TimedAutoDrive extends CommandBase {

    private final DriveTrain _drivetrain;
    private final Timer _timer;
    private double gear = 0.8;


    public TimedAutoDrive(DriveTrain dt) {
        // Use addRequirements() here to declare subsystem dependencies.
        _drivetrain = dt;
        _timer = new Timer();
    
        addRequirements(_drivetrain);
      }
    
    

@Override
public void initialize() {


}

@Override
public void execute() {
    /*_drivetrain.arcadeDrive(-gear * _joystick.getRawAxis(Constants.JoystickAxis.YAxis),
    gear * _joystick.getRawAxis(Constants.JoystickAxis.XAxis));
    if(_joystick.getRawButtonPressed(1)) {
    gear += 0.2;
        if(gear >= 1.6) gear = 0.2;
    }; */

    _timer.start();
    if(_timer.get() <= 100) {
        _drivetrain.tankDrive(0.6, 0.6);

    }
    else {
        _drivetrain.tankDrive(0, 0);
    }
}

@Override 
public void end(boolean interrupted) {

}

@Override
public boolean isFinished() {
    return false;
}
    
}
