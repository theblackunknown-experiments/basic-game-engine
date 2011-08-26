package org.blackpanther.game
package engine
package strategy

sealed abstract class TimerType extends StrategyType

object TimerStrategyProvider extends StrategyProvider[TimerStrategy,TimerType] {

    object Default extends TimerType

    import engine.GameEngine.GameState

    def apply(request : TimerType) : TimerStrategy = request match {
        case Default => DefaultTimerStrategy
    }

    private object DefaultTimerStrategy extends TimerStrategy {
        def sleep(state : GameState) {
            println("Game is paused")
            Thread.sleep(100)
        }
    }

}
