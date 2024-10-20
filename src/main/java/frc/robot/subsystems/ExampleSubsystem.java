// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.ExampleMotor;
import frc.robot.utils.Loggable;

public class ExampleSubsystem extends SubsystemBase implements Loggable {

    @AutoLog
    public static class ExampleInputs {
        public double number;
    }

    private ExampleInputsAutoLogged inputs = new ExampleInputsAutoLogged();

    private ExampleMotor leftMotor = new ExampleMotor();
    private ExampleMotor rightMotor = new ExampleMotor();

    /** Creates a new ExampleSubsystem. */
    public ExampleSubsystem() {
    }

    /**
     * Example command factory method.
     *
     * @return a command
     */
    public Command exampleMethodCommand() {
        // Inline construction of command goes here.
        // Subsystem::RunOnce implicitly requires `this` subsystem.
        return runOnce(
                () -> {
                    /* one-time action goes here */
                });
    }

    /**
     * An example method querying a boolean state of the subsystem (for example, a
     * digital sensor).
     *
     * @return value of some boolean subsystem state, such as a digital sensor.
     */
    public boolean exampleCondition() {
        // Query some boolean state, such as a digital sensor.
        return false;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

        leftMotor.run(0.5);
        rightMotor.run(0.5);
        
        log("Subsystems", "ExampleSubsystem");
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

    @Override
    public void log(String subdirectory, String humanReadableName) {
        leftMotor.log(subdirectory + "/" + humanReadableName, "LeftMotor");
        rightMotor.log(subdirectory + "/" + humanReadableName, "RightMotor");


        inputs.number = Math.cos(Timer.getFPGATimestamp());

        Logger.processInputs(subdirectory + "/" + humanReadableName, inputs);
    }
}
