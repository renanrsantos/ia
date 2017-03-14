/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robo;

import java.awt.Color;
import robocode.AdvancedRobot;
import robocode.BulletMissedEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 *
 * @author 38816
 */
public class K0BRA extends AdvancedRobot{
    
    boolean bScannedRobot = false;
    
    @Override
    public void run(){
        setBodyColor(Color.darkGray);
        setGunColor(Color.black);
        setRadarColor(Color.black);
        setBulletColor(Color.black);
        setScanColor(Color.red);
        
        while(true){
            if(!bScannedRobot){
                setAhead(100);
                setBack(100);                
                setTurnRight(360);
    //              setTurnGunRight(360);
                
            }
        }
        
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        stop();
        if(event.getDistance() > 200){
            if(getEnergy()>15){
                setFire(2);
            } else {
                setFire(1);
            }
            
        } else {
            if(getEnergy()>15){
                setFire(2);
            } else {
                setFire(1);
            }
        }
        resume();
        bScannedRobot= true;
    }

    @Override
    public void onHitRobot(HitRobotEvent event) {
        super.onHitRobot(event);
        
    }

    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        resume();
        setAdjustRadarForRobotTurn(false);
        setTurnRight(getHeight()+180);
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        resume();
        bScannedRobot = false;
    }

    @Override
    public void onBulletMissed(BulletMissedEvent event) {
        resume();
        bScannedRobot = false;
    }
    
    
    
    public int getDistanciaMovimento(){
        return 500;
    }
    
    
}
