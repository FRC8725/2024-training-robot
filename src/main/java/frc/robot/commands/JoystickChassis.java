// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ChassisSubsystem;

public class JoystickChassis extends Command {
  /** Creates a new JoystickChassis. */
  private final ChassisSubsystem chassisSubsystem = ChassisSubsystem.getInstance();
  Supplier<Double> leftSupplier;
  Supplier<Double> rightSupplier;
  public JoystickChassis(Supplier<Double> leftJoystick, Supplier<Double> rightJoystick) {
    leftSupplier = leftJoystick;
    rightSupplier = rightJoystick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(ChassisSubsystem.getInstance());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    chassisSubsystem.leftSet(leftSupplier.get());
    chassisSubsystem.rightSet(rightSupplier.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
