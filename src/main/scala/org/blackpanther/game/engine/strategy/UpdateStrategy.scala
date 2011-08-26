package org.blackpanther.game
package engine
package strategy

sealed abstract class UpdateType extends StrategyType

object UpdateStrategyProvider extends StrategyProvider[UpdateStrategy,UpdateType] {

    object Default extends UpdateType

    import engine.GameEngine.GameState

    def apply(request : UpdateType) : UpdateStrategy = request match {
        case Default => DefaultUpdateStrategy
    }

    private object DefaultUpdateStrategy extends UpdateStrategy {
        def update(state : GameState) {
            println("Game is updated")
        }
    }

}
