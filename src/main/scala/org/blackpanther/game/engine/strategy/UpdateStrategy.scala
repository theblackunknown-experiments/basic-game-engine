package org.blackpanther.game
package engine
package strategy

object UpdateStrategyProvider extends StrategyProvider {

    import engine.GameEngine.GameState

    object Default extends UpdateStrategy {
        def apply(state : GameState) {
            println("Game is updated")
        }
    }

}
