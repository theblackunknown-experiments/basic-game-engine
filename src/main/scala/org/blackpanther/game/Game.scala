package org.blackpanther.game

import scala.swing._
import scala.swing.event._

import ui._
import engine._
import GameEngine._

object GameFrame extends SimpleSwingApplication {
    
    private val engine = new Thread(GameEngine)

    val top : Frame = new MainFrame {
        title = "Game Swing Application"
        contents = Component.wrap(GamePanel)
    }

    top.listenTo(top)
    top.reactions += {
        case WindowClosed(`top`) =>
            GameEngine.gameState = new GameState(running = false)
    }

    engine.start()

}
// vim: set ts=4 sw=4 et:
