package generated.main;

import de.fhg.iais.roberta.ast.syntax.*;
import de.fhg.iais.roberta.codegen.lejos.Hal;

import de.fhg.iais.roberta.ast.syntax.action.*;
import de.fhg.iais.roberta.ast.syntax.sensor.*;
import de.fhg.iais.roberta.hardwarecomponents.ev3.*;
import de.fhg.iais.roberta.brickconfiguration.ev3.*;
public class Test1 {
    private EV3BrickConfiguration brickConfiguration = new EV3BrickConfiguration.Builder()
    .setWheelDiameter(5.6)
    .setTrackWidth(13.0)
    .addActor(ActorPort.B, new EV3Actor(HardwareComponentEV3Actor.EV3_LARGE_MOTOR, true, DriveDirection.FOREWARD, MotorSide.LEFT))
    .addActor(ActorPort.C, new EV3Actor(HardwareComponentEV3Actor.EV3_LARGE_MOTOR, true, DriveDirection.FOREWARD, MotorSide.RIGHT))
    .addSensor(SensorPort.S1, new EV3Sensor(HardwareComponentEV3Sensor.EV3_TOUCH_SENSOR))
    .addSensor(SensorPort.S4, new EV3Sensor(HardwareComponentEV3Sensor.EV3_ULTRASONIC_SENSOR))
    .build();

    public static void main(String[] args) {
        new Test1().run();
    }

    public void run() {
        Hal hal = new Hal(brickConfiguration);
        hal.drawText("Hallo", 0, 0);
        while ( true ) {
            if ( hal.isPressed(SensorPort.S1) == true ) {
                break;
            }
        }
        hal.playTone(300, 100);
        while ( true ) {
            if ( hal.isPressed(SensorPort.S1) == true ) {
                break;
            }
        }
        hal.drawText(String.valueOf(hal.getUltraSonicSensorValue(SensorPort.S4)), 0, 0);
        while ( true ) {
            if ( hal.isPressed(SensorPort.S1) == true ) {
                break;
            }
        }
        hal.rotateDirectionAngle(ActorPort.B, ActorPort.C, false, TurnDirection.LEFT, 50, 180);
        try {
            Thread.sleep(2000);
        } catch ( InterruptedException e ) {
            // ok
        }
    }
}