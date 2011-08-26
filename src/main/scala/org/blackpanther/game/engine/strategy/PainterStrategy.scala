package org.blackpanther.game
package engine
package strategy

sealed abstract class PainterType extends StrategyType

object PainterStrategyProvider extends StrategyProvider[PainterStrategy,PainterType] {

    object Default extends PainterType

    import engine.GameEngine.GameState

    def apply(request : PainterType) : PainterStrategy = request match {
        case Default => DefaultPainterStrategy
    }

    private object DefaultPainterStrategy extends PainterStrategy {
        def repaint(state : GameState) {
            println("Game is repainted")
        }
    }

}
