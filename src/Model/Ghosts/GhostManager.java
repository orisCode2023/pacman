package Model.Ghosts;

import Model.EntitiesDynamic;
import Model.MapPacman;

import javax.swing.plaf.PanelUI;
import java.awt.*;

public class GhostManager {
    public GhostInky gInky;
    public GhostClyde gClyde;
    public GhostBlinky gBlinky;
    public GhostPinky gPinky;

    public GhostManager() {
        gInky = new GhostInky();
        gClyde = new GhostClyde();
        gBlinky = new GhostBlinky();
        gPinky = new GhostPinky();
    }
    public void directionGhosts(){
        gPinky.direction();
        gClyde.direction();
        gBlinky.direction();
        gInky.direction();
    }
    public void spriteGhosts(){
        gInky.checkSprite();
        gClyde.checkSprite();
        gBlinky.checkSprite();
        gPinky.checkSprite();

    }
    public void updateGhosts(){
        directionGhosts();
        spriteGhosts();
    }

    public void drawGhost(Graphics2D g2) {
            gBlinky.draw(g2);
            gClyde.draw(g2);
            gInky.draw(g2);
            gPinky.draw(g2);
        }
    }

