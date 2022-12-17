// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;


public class ArcadeDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */
  private final Drivetrain drivetrain;

  // We put all the fields we need for this command here
  private final Supplier<Double> turnSpeed;
  private final Supplier<Double> forwardSpeed;

  public ArcadeDrive(Supplier<Double> turnSpeed, Supplier<Double> forwardSpeed) {
     // This is how to get all the subsystems
     this.drivetrain = Drivetrain.getInstance();

     // We store our speed suppliers here
     this.turnSpeed = turnSpeed;
     this.forwardSpeed = forwardSpeed;
 
     // Use addRequirements() here to declare subsystem dependencies.
     addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.arcadeDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.arcadeDrive(turnSpeed.get(), forwardSpeed.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
