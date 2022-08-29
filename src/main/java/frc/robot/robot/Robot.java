package frc.robot.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Auto.AutoModeExecutor;
import frc.robot.Auto.Modes.SimpleOneCargoAuto;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Gamepad;
import frc.robot.subsystems.Intake;

public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  private Drive mDrive;
  private Intake mIntake;
  private Shooter mShooter;
  private Timer timer;
  private Gamepad mGamepad;
  private AutoModeExecutor ame;

  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    mGamepad = Gamepad.getInstance();
    mDrive = Drive.getInstance();
    mShooter = Shooter.getInstance();
    mIntake = Intake.getInstance();
    timer = new Timer();
    ame = new AutoModeExecutor();
  }

  @Override
  public void robotPeriodic() {
    
  }

  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    System.out.println("Auto selected: " + m_autoSelected);
    timer.reset();
    timer.start();
    ame.setAutoMode(new SimpleOneCargoAuto());
    ame.start();
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    if (ame != null){
      ame.stop();
      ame.reset();
    }
  }

  @Override
  public void teleopPeriodic() {

    double speed = mGamepad.getForward() - mGamepad.getReverse();
    double rotation;
    
    if (Math.abs(mGamepad.getSensetiveSteering()) > 0.2){
        rotation = mGamepad.getSensetiveSteering() * 0.5;
    }
    else{
      rotation = mGamepad.getSteering() * 0.75;
    }
        mDrive.chassis.arcadeDrive(speed, rotation);

    if(mGamepad.getIntakeGamepad()){
      mIntake.IntakeRunForRotationClockwise();
    }
    else if(mGamepad.getIntakeReverseGamepad()){
      mIntake.IntakeRunForRotationAntiClockwise();
    }
    else{
      mIntake.IntakeStopAllMotors();
    }

    if(mGamepad.getDroppperReverseGamepad()){
      mShooter.shooterRunForRotationAntiClockwise();
    }
    else if(mGamepad.getDropperGamepad()){
      mShooter.shooterStopAllMotors();
      mIntake.IntakeRunForRotationClockwise();
    }
    else{
      mShooter.shooterStopAllMotors();
    }
    
  }

  @Override
  public void disabledInit() {
    if (ame != null){
      ame.stop();
      ame.reset();
    }
  }

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {
  }
}