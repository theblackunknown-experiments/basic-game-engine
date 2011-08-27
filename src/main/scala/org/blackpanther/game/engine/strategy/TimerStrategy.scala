package org.blackpanther.game
package engine
package strategy

object TimerStrategyProvider extends StrategyProvider {

    import engine.GameEngine.GameState

    object Default extends TimerStrategy {
        def apply(state : GameState) {
            val sleepTime = 1000
            Thread.sleep(sleepTime)
            println("Game slept for %d" format sleepTime)
        }
    }

}
