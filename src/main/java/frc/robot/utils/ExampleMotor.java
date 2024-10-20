package frc.robot.utils;

import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.Logger;

public class ExampleMotor implements Loggable {

    @AutoLog
    public static class MotorInputs {
        public double speed;
    }

    private double speed;

    private MotorInputsAutoLogged inputs = new MotorInputsAutoLogged();

    public ExampleMotor() {
        speed = 0;
    }

    public void run(double speed) {
        this.speed = speed;
    }

    @Override
    public void log(String subdirectory, String humanReadableName) {
        inputs.speed = speed;

        Logger.processInputs(subdirectory + "/" + humanReadableName, inputs);
    }
}
