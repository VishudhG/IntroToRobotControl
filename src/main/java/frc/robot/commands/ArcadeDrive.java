package frc.robot.commands;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class ArcadeDrive extends CommandBase {

    private final Joystick _joystick;
    private final DriveTrain _drivetrain;
    private double gear = 0.8;


    public ArcadeDrive(DriveTrain dt, Joystick j) {
        // Use addRequirements() here to declare subsystem dependencies.
        _drivetrain = dt;
       _joystick = j;
    
        addRequirements(_drivetrain);
      }
    
    

@Override
public void initialize() {}

@Override
public void execute() {
    _drivetrain.arcadeDrive(-gear * _joystick.getRawAxis(Constants.JoystickAxis.YAxis),
    gear * _joystick.getRawAxis(Constants.JoystickAxis.XAxis));
    if(_joystick.getRawButtonPressed(1)) {
    gear += 0.2;
        if(gear >= 1.6) gear = 0.2;
    };
}

@Override 
public void end(boolean interrupted) {

}

@Override
public boolean isFinished() {
    return false;
}
    
}
