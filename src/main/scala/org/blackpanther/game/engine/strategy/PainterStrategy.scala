package org.blackpanther.game
package engine
package strategy

import ui.GamePanel

object PainterStrategyProvider extends StrategyProvider {

    import engine.GameEngine.GameState

    object Default extends PainterStrategy {
        def apply(state : GameState) {

            GamePanel.repaint()
            
            println("Game is repainted")
        }
    }

}
