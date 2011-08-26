package org.blackpanther.game
package engine
package strategy

sealed abstract class RenderType extends StrategyType

object RenderStrategyProvider extends StrategyProvider[RenderStrategy,RenderType] {

    object Default extends RenderType
    object Buffered extends RenderType

    import engine.GameEngine.GameState

    def apply(request : RenderType) : RenderStrategy = request match {
        case Buffered => BufferedRenderStrategy
        case Default => DefaultRenderStrategy
    }

    private object DefaultRenderStrategy extends RenderStrategy {
        def render(state : GameState) {
            println("Game is rendered")
        }
    }

    private object BufferedRenderStrategy extends RenderStrategy {
        def render(state : GameState) {
            println("Game is rendered")
        }
    }

}
